package reservation.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;
import hosInfo.dto.HosInfo;
import reservation.dao.face.ReservationDao;
import reservation.dto.Pet;

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
			ps.setInt(1, hosCode.getHos_code());
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				hosInfo = new HosInfo();
				
				hosInfo.setHos_code( rs.getInt("hos_code"));
				hosInfo.setHos_name( rs.getString("hos_name"));
				hosInfo.setHos_add( rs.getString("hos_add"));
				hosInfo.setHos_zip( rs.getInt("hos_zip"));
				hosInfo.setHos_call( rs.getString("hos_call"));
				hosInfo.setHos_time( rs.getString("hos_time"));
				hosInfo.setHos_trans( rs.getString("hos_trans"));
				hosInfo.setHos_park( rs.getString("hos_park"));
				hosInfo.setHos_price( rs.getInt("hos_price"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return hosInfo;
	}
	
	//----------------------------------------doPost----------------------------
	
	
	@Override
	public int selectNextPetNo(Connection conn) {
		
		String sql = "SELECT pet_seq.nextval FROM dual";
		
		int nextval = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			rs.next();
			
			nextval = rs.getInt(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return nextval;
	}
	
	@Override
	public int insert(Connection conn, Pet pet) {

		String sql = "";
		sql += "INSERT INTO pet (pet_no, pet_name, pet_age, pet_sex ,pet_type)";
		sql += " VALUES( ?, ?, ?, ?, ? )";
		
		int result = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, pet.getPetNo());
			ps.setString(2, pet.getPetName());
			ps.setInt(3, pet.getPetAge());
			ps.setString(4, pet.getPetSex());
			ps.setString(5, pet.getPetType());
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return result;
	}
	
}
