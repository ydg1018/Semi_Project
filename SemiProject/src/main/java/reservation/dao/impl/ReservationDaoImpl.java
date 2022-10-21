package reservation.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;
import hosInfo.dto.HosInfo;
import reservation.dao.face.ReservationDao;

public class ReservationDaoImpl implements ReservationDao {

	private PreparedStatement ps;
	private ResultSet rs;
	
	@Override
	public HosInfo selectHosByHosCode(Connection conn, HosInfo hosCode) {
		
		String sql = "";
		sql += "SELECT";
		sql += "	hos_code, hos_name, hos_add, hos_zip, hos_call, hos_time, hos_trans, hos_park, hos_price";
		sql += " FROM hosinfo";
		sql += " WHERE hos_code = ?";
		
		HosInfo hosInfo = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, hosCode.getHosCode());
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				hosInfo = new HosInfo();
				
				hosInfo.setHosCode( rs.getInt("hos_code"));
				hosInfo.setHosName( rs.getString("hos_name"));
				hosInfo.setHosAdd( rs.getString("hos_add"));
				hosInfo.setHosZip( rs.getInt("hos_zip"));
				hosInfo.setHosCall( rs.getString("hos_call"));
				hosInfo.setHosTime( rs.getString("hos_time"));
				hosInfo.setHosTrans( rs.getString("hos_trans"));
				hosInfo.setHosPark( rs.getString("hos_park"));
				hosInfo.setHosPrice( rs.getInt("hos_price"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return hosInfo;
	}
	
}
