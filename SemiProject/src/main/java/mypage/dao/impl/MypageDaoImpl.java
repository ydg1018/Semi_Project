package mypage.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;
import login.dto.Hospital;
import login.dto.Owner;
import mypage.dao.face.MypageDao;
import reservation.dto.Reservation;

public class MypageDaoImpl implements MypageDao {
	
	private PreparedStatement ps; //SQL수행 객체
	private ResultSet rs;	//SQL조회 결과 객체

	@Override
	public Owner getOwner(Connection conn, Owner param) {
		System.out.println("MypageDao getOwner() - 시작");
		
		//SQL작성
		String sql = "";
		sql += "SELECT * FROM owner";
		sql += " WHERE owner_no = ?";
		
		//결과 저정할 객체
		Owner result = new Owner();
		
		try {
			//SQL수행 객체
			ps = conn.prepareStatement(sql); 
			
			//SQL 파라메터 셋팅
			ps.setInt(1, param.getOwnerNo());
			
			//SQL수행 및 결과 집합 저장
			rs = ps.executeQuery(); 
			
			//조회 결과 처리
			while(rs.next()) {
				result.setOwnerNo(rs.getInt("owner_no"));
				result.setOwnerId(rs.getString("owner_id"));
				result.setOwnerName(rs.getString("owner_name"));
				result.setOwnerEmail(rs.getString("owner_email"));
				result.setOwnerCall(rs.getInt("owner_call"));
				result.setOwnerNick(rs.getString("owner_nick"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		System.out.println("MypageDao getOwner() - 끝");
		
		return result; //최종 결과 반환
	}
	
	@Override
	public int updateOwner(Connection conn, Owner param) {
		System.out.println("MypageDao updateOwner() - 시작");
		
		//SQL작성
		String sql = "";
		sql += "UPDATE owner SET ";
		sql += "  owner_name = ?";
		sql += " ,owner_email = ?";
		sql += " ,owner_call = ?";
		sql += " ,owner_nick = ?";
		sql += " WHERE owner_no = ?";
		
		//결과 저정할 객체
		int result = 0;
		
		try {
			//SQL수행 객체
			ps = conn.prepareStatement(sql); 
			
			//SQL 파라메터 셋팅
			ps.setString(1, param.getOwnerName());
			ps.setString(2, param.getOwnerEmail());
			ps.setInt(3, param.getOwnerCall());
			ps.setString(4, param.getOwnerNick());
			ps.setInt(5, param.getOwnerNo());

			//SQL수행 및 결과 집합 저장
			result = ps.executeUpdate(); 
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		System.out.println("MypageDao updateOwner() - 끝");
		
		return result; //최종 결과 반환
	}
	
	@Override
	public int deleteOwner(Connection conn, Owner param) {
		System.out.println("MypageDao deleteOwner() - 시작");
		
		//SQL작성
		String sql = "";
		sql += "DELETE FROM owner";
		sql += " WHERE owner_no = ?";
		
		//결과 저정할 객체
		int result = 0;
		
		try {
			//SQL수행 객체
			ps = conn.prepareStatement(sql); 
			
			//SQL 파라메터 셋팅
			ps.setInt(1, param.getOwnerNo());

			//SQL수행 및 결과 집합 저장
			result = ps.executeUpdate(); 
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		System.out.println("MypageDao deleteOwner() - 끝");
		
		return result; //최종 결과 반환
	}
//----------------------------------------------------------------------

	@Override
	public Reservation getReservationOnwner(Connection conn, Reservation param) {
		System.out.println("MypageDao getReservationOnwner() - 시작");
		
		//SQL작성
		String sql = "";
		sql += "SELECT * FROM reservation";
		sql += " WHERE owner_no = ?";
		
		//결과 저정할 객체
		Reservation result = new Reservation();
		
		try {
			//SQL수행 객체
			ps = conn.prepareStatement(sql); 
			
			//SQL 파라메터 셋팅
			ps.setInt(1, param.getOwnerNo());
			
			//SQL수행 및 결과 집합 저장
			rs = ps.executeQuery(); 
			
			//조회 결과 처리
			while(rs.next()) {
				result.setResNo(rs.getInt("res_no"));
				result.setResDate(rs.getDate("res_date"));
				result.setResDetail(rs.getString("res_detail"));
				result.setOwnerNo(rs.getInt("owner_no"));
				result.setPetNo(rs.getInt("pet_no"));
				result.setHosNo(rs.getInt("hos_no"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		System.out.println("MypageDao getReservationOnwner() - 끝");
		
		return result; //최종 결과 반환
	}
	
	@Override
	public Reservation getReservationHospital(Connection conn, Reservation param) {
		System.out.println("MypageDao getReservationHospital() - 시작");
		
		//SQL작성
		String sql = "";
		sql += "SELECT * FROM reservation";
		sql += " WHERE hosNo = ?";
		
		//결과 저정할 객체
		Reservation result = new Reservation();
		
		try {
			//SQL수행 객체
			ps = conn.prepareStatement(sql); 
			
			//SQL 파라메터 셋팅
			ps.setInt(1, param.getHosNo());
			
			//SQL수행 및 결과 집합 저장
			rs = ps.executeQuery(); 
			
			//조회 결과 처리
			while(rs.next()) {
				result.setResNo(rs.getInt("res_no"));
				result.setResDate(rs.getDate("res_date"));
				result.setResDetail(rs.getString("res_detail"));
				result.setOwnerNo(rs.getInt("owner_no"));
				result.setPetNo(rs.getInt("pet_no"));
				result.setHosNo(rs.getInt("hos_no"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		System.out.println("MypageDao getReservationHospital() - 끝");
		
		return result; //최종 결과 반환
	}
	
//----------------------------------------------------------------------
	@Override
	public Hospital getHospital(Connection conn, Hospital param) {
		System.out.println("MypageDao getHospital() - 시작");
		
		//SQL작성
		String sql = "";
		sql += "SELECT * FROM hospital";
		sql += " WHERE hos_no = ?";
		
		//결과 저정할 객체
		Hospital result = new Hospital();
		
		try {
			//SQL수행 객체
			ps = conn.prepareStatement(sql); 
			
			//SQL 파라메터 셋팅
			ps.setInt(1, param.getHosNo());
			
			//SQL수행 및 결과 집합 저장
			rs = ps.executeQuery(); 
			
			//조회 결과 처리
			while(rs.next()) {
				result.setHosNo(rs.getInt("hos_no"));
				result.setHosId(rs.getString("hos_id"));
				result.setHosPw(rs.getString("hos_pw"));
//				result.setHosLic(rs.getString("hos_lic"));
				result.setHosCode(rs.getInt("hos_code"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		System.out.println("MypageDao getHospital() - 끝");
		
		return result; //최종 결과 반환
	}
	
	@Override
	public int updateHospital(Connection conn, Hospital param) {
		System.out.println("MypageDao updateHospital() - 시작");
		
		//SQL작성
		String sql = "";
		sql += "UPDATE hospital SET ";
		sql += "  hos_id = ?";
		sql += " ,hos_pw = ?";
		sql += " ,hos_lic = ?";
		sql += " ,hos_code = ?";
		sql += " WHERE hos_no = ?";
		
		//결과 저정할 객체
		int result = 0;
		
		try {
			//SQL수행 객체
			ps = conn.prepareStatement(sql); 
			
			//SQL 파라메터 셋팅
//			ps.setString(1, param.getOwnerName());
//			ps.setString(2, param.getOwnerEmail());
//			ps.setInt(3, param.getOwnerCall());
//			ps.setString(4, param.getOwnerNick());
//			ps.setInt(5, param.getOwnerNo());

			//SQL수행 및 결과 집합 저장
			result = ps.executeUpdate(); 
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		System.out.println("MypageDao updateHospital() - 끝");
		
		return result; //최종 결과 반환
	}
	
	@Override
	public int deleteHospital(Connection conn, Hospital param) {
		System.out.println("MypageDao deleteHospital() - 시작");
		
		//SQL작성
		String sql = "";
		sql += "DELETE FROM hospital";
		sql += " WHERE hospital_no = ?";
		
		//결과 저정할 객체
		int result = 0;
		
		try {
			//SQL수행 객체
			ps = conn.prepareStatement(sql); 
			
			//SQL 파라메터 셋팅
			ps.setInt(1, param.getHosNo());

			//SQL수행 및 결과 집합 저장
			result = ps.executeUpdate(); 
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		System.out.println("MypageDao deleteHospital() - 끝");
		
		return result; //최종 결과 반환
	}
}