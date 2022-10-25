package reservation.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import hosInfo.dto.HosInfo;
import reservation.dao.face.SearchReserDao;
import util.Paging;

public class SearchReserDaoImpl implements SearchReserDao {

	private PreparedStatement ps;
	private ResultSet rs;
	
	@Override
	public List<HosInfo> selectAll(Connection conn, Paging paging) {
		System.out.println("SearchReserDao selectAll() 시작");
		
		String sql = "";
		sql += "SELECT";
		sql += "	hos_code, hos_name, hos_add, hos_zip, hos_call, hos_time, hos_trans, hos_park, hos_price";
		sql += " FROM hosinfo";
		sql += " WHERE hos_code BETWEEN ? AND ?";
		sql += " ORDER BY hos_code";
		
		List<HosInfo> list = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				HosInfo hos = new HosInfo();
				
				hos.setHosCode( rs.getInt("hos_code"));
				hos.setHosName( rs.getString("hos_name"));
				hos.setHosAdd( rs.getString("hos_add"));
				hos.setHosZip( rs.getInt("hos_zip"));
				hos.setHosCall( rs.getString("hos_call"));
				hos.setHosTime( rs.getString("hos_time"));
				hos.setHosTrans( rs.getString("hos_trans"));
				hos.setHosPark( rs.getString("hos_park"));
				hos.setHosPrice( rs.getInt("hos_price"));
				
				list.add(hos);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return list;
	}
	
	
	@Override
	public int selectCntAll(Connection conn) {
		
		String sql = "";
		sql += "SELECT count(*) cnt FROM hosinfo";
		
		int count = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				count = rs.getInt("cnt");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return count;
	}
	
	@Override
	public List<HosInfo> selectHosInfoByHosName(Connection conn, HosInfo hosName) {
		
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "	SELECT rownum rnum, H.* FROM (";
		sql += "	        SELECT * FROM hosinfo";
		sql += "	        WHERE INSTR(hos_name, ? ) > 0";
		sql += "		ORDER BY hos_code";
		sql += " 	)H";
		sql += " )hos";
		
		List<HosInfo> hosInfo = new ArrayList<>();
		
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, hosName.getHosName());
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				HosInfo hos = new HosInfo();
				
				hos.setHosCode( rs.getInt("hos_code"));
				hos.setHosName( rs.getString("hos_name"));
				hos.setHosAdd( rs.getString("hos_add"));
				hos.setHosZip( rs.getInt("hos_zip"));
				hos.setHosCall( rs.getString("hos_call"));
				hos.setHosTime( rs.getString("hos_time"));
				hos.setHosTrans( rs.getString("hos_trans"));
				hos.setHosPark( rs.getString("hos_park"));
				hos.setHosPrice( rs.getInt("hos_price"));
				
				hosInfo.add(hos);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
				
		return hosInfo;
	}
	
//	@Override
//	public int selectCntdetail(Connection conn, HosInfo hosName) {
//		String sql = "";
//		sql += "SELECT count(*) cnt FROM hosinfo";
//		sql += " WHERE INSTR(hos_name, ? ) > 0";
//		
//		int count = 0;
//		
//		try {
//			ps = conn.prepareStatement(sql);
//			ps.setString(1, hosName.getHosName() );
//			rs = ps.executeQuery();
//			
//			while( rs.next() ) {
//				count = rs.getInt("cnt");
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			JDBCTemplate.close(rs);
//			JDBCTemplate.close(ps);
//		}
//		
//		return count;
//	}
	
}
