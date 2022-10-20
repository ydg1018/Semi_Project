package hosInfo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import hosInfo.dao.face.HosInfoDao;
import hosInfo.dto.HosInfo;

public class HosInfoDaoImpl implements HosInfoDao {
	
	//SQL수행 객체
	private PreparedStatement ps;
	
	//SQL조회 결과 객체
	private ResultSet rs;
	
	@Override
	public List<HosInfo> selectAll(Connection conn) {
		
		//SQL 작성
		String sql = "";
		sql += "SELECT hos_name, hos_add, hos_zip, hos_call, hos_time, hos_trans, hos_park FROM hosInfo";
		sql += " ORDER BY hos_price";
		
		//결과 저장할 List
		List<HosInfo> hosInfo = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			
			rs = ps.executeQuery(); //SQL수행 및 결과 집합 저장
			
			//조회 결과 처리
			while(rs.next()) {
				
				//조회 결과 행 저장 DTO객체
				HosInfo h = new HosInfo();
				
				h.setHos_name(rs.getString("hos_name"));
				h.setHos_add(rs.getString("hos_add"));
				h.setHos_zip(rs.getInt("hos_zip"));
				h.setHos_call(rs.getString("hos_call"));
				h.setHos_time(rs.getString("hos_time"));
				h.setHos_trans(rs.getString("hos_trans"));
				h.setHos_park(rs.getString("hos_park"));
				
				//리스트에 결과값 저장하기
				hosInfo.add(h);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return hosInfo;
	}
	
	@Override
	public HosInfo selectHosByHosname(Connection conn, HosInfo hos_name) {

		String sql = "";
		sql += "SELECT";
		sql += "	hos_name, hos_add, hos_zip, hos_call, hos_time, hos_trans, hos_park";
		sql += " FROM HosInfo";
		sql += " WHERE hos_name = ?";
		
		HosInfo h = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, hos_name.getHos_name());
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				h = new HosInfo();
				
				h.setHos_name(rs.getString("hos_name"));
				h.setHos_add(rs.getString("hos_add"));
				h.setHos_zip(rs.getInt("hos_zip"));
				h.setHos_call(rs.getString("hos_call"));
				h.setHos_time(rs.getString("hos_time"));
				h.setHos_trans(rs.getString("hos_trans"));
				h.setHos_park(rs.getString("hos_park"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return h;
	}
}
