package mypage.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;
import hosInfo.dto.HosInfo;
import login.dto.Hos;
import login.dto.Owner;
import mypage.dao.face.MypageDao;
import reservation.dto.Pet;
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
				result.setOwnerPw(rs.getString("owner_pw"));
				result.setOwnerName(rs.getString("owner_name"));
				result.setOwnerEmail(rs.getString("owner_email"));
				result.setOwnerCall(rs.getString("owner_call"));
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
		sql += " ,owner_pw = ?";
		sql += " WHERE owner_no = ?";
		
		//결과 저정할 객체
		int result = 0;
		
		try {
			//SQL수행 객체
			ps = conn.prepareStatement(sql); 
			
			//SQL 파라메터 셋팅
			ps.setString(1, param.getOwnerName());
			ps.setString(2, param.getOwnerEmail());
			ps.setString(3, param.getOwnerCall());
			ps.setString(4, param.getOwnerNick());
			ps.setString(5, param.getOwnerPw());
			ps.setInt(6, param.getOwnerNo());

			//SQL수행 및 결과 집합 저장
			result = ps.executeUpdate(); 
			
			if(result > 0) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}
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
			
			if(result > 0) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}
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
	public Reservation getOwnerReservation(Connection conn, Reservation param) {
		System.out.println("MypageDao getOwnerReservation() - 시작");
		
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
				result.setResDate(rs.getString("res_date"));
				result.setResDetail(rs.getString("res_detail"));
				result.setOwnerNo(rs.getInt("owner_no"));
				result.setPetNo(rs.getInt("pet_no"));
				result.setHosCode(rs.getInt("hos_code"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		System.out.println("MypageDao getOwnerReservation() - 끝");
		
		return result; //최종 결과 반환
	}
	
	@Override
	public Reservation getHosReservation(Connection conn, Reservation param) {
		System.out.println("MypageDao getHosReservation() - 시작");
		
		//SQL작성
		String sql = "";
		sql += "SELECT * FROM reservation";
		sql += " WHERE hos_code = ?";
		
		//결과 저정할 객체
		Reservation result = new Reservation();
		
		try {
			//SQL수행 객체
			ps = conn.prepareStatement(sql); 
			
			//SQL 파라메터 셋팅
			ps.setInt(1, param.getHosCode());
			
			//SQL수행 및 결과 집합 저장
			rs = ps.executeQuery(); 
			
			//조회 결과 처리
			while(rs.next()) {
				result.setResNo(rs.getInt("res_no"));
				result.setResDate(rs.getString("res_date"));
				result.setResDetail(rs.getString("res_detail"));
				result.setOwnerNo(rs.getInt("owner_no"));
				result.setPetNo(rs.getInt("pet_no"));
				result.setHosCode(rs.getInt("hos_code"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		System.out.println("MypageDao getHosReservation() - 끝");
		
		return result; //최종 결과 반환
	}
	
//----------------------------------------------------------------------
	@Override
	public Hos getHospital(Connection conn, Hos param) {
		System.out.println("MypageDao getHospital() - 시작");
		
		//SQL작성
		String sql = "";
		sql += "SELECT * FROM hos";
		sql += " WHERE hos_no = ?";
		
		//결과 저장할 객체
		Hos result = new Hos();
		
		try {
			//SQL수행 객체
			ps = conn.prepareStatement(sql); 
			
			//SQL 파라메터 셋팅
			ps.setInt(1, param.getHosNo());
			//2.쿼리에 보낼 데이터에 병원꾸러미에 잇는 데이터 넣어주는거지
			
			//SQL수행 및 결과 집합 저장
			rs = ps.executeQuery(); 
			
			//조회 결과 처리
			while(rs.next()) {
				result.setHosNo(rs.getInt("hos_no"));
				result.setHosId(rs.getString("hos_id"));
				result.setHosName(rs.getString("hos_name"));
				result.setHosPw(rs.getString("hos_pw"));
				result.setHosLic(rs.getInt("hos_lic"));
				result.setHosCode(rs.getInt("hos_code"));
				//1.병원에 데이터 넣어주는거고
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
	public int updateHospital(Connection conn, Hos param) {
		System.out.println("MypageDao updateHospital() - 시작");
		
		//SQL작성
		String sql = "";
		sql += "UPDATE hos SET ";
//		sql += "  hos_id = ?";
		sql += " hos_pw = ?";
		sql += " ,hos_lic = ?";
		sql += " ,hos_name = ?";
		sql += " ,hos_code = ?";
		sql += " WHERE hos_no = ?";
		
		//결과 저정할 객체
		int result = 0;
		
		try {
			//SQL수행 객체
			ps = conn.prepareStatement(sql); 
			
			//SQL 파라메터 셋팅
			ps.setString(1, param.getHosPw());
			ps.setInt(2, param.getHosLic());
			ps.setString(3, param.getHosName());
			ps.setInt(4, param.getHosCode());
			ps.setInt(5, param.getHosNo());
//			ps.setString(2, param.getHosId());

			//SQL수행 및 결과 집합 저장
			result = ps.executeUpdate(); 
			
			if(result > 0) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}		
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
	public int deleteHospital(Connection conn, Hos param) {
		System.out.println("MypageDao deleteHospital() - 시작");
		
		//SQL작성
		String sql = "";
		sql += "DELETE FROM hos";
		sql += " WHERE hos_no = ?";
		
		//결과 저정할 객체
		int result = 0;
		
		try {
			//SQL수행 객체
			ps = conn.prepareStatement(sql); 
			
			//SQL 파라메터 셋팅
			ps.setInt(1, param.getHosNo());

			//SQL수행 및 결과 집합 저장
			result = ps.executeUpdate(); 
			
			if(result > 0) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		System.out.println("MypageDao deleteHospital() - 끝");
		
		return result; //최종 결과 반환
	}
	
//-----------------------------------------------------------
	@Override
	public HosInfo getHosInfo(Connection conn, HosInfo param) {
		System.out.println("MypageDao getHosInfo() - 시작");
		
		//SQL작성
		String sql = "";
		sql += "SELECT * FROM HosInfo";
		sql += " WHERE hos_code = ?";
		
		//결과 저장할 객체
		HosInfo result = new HosInfo();
		
		try {
			//SQL수행 객체
			ps = conn.prepareStatement(sql); 
			
			//SQL 파라메터 셋팅
			ps.setInt(1, param.getHos_code());
			//2.쿼리에 보낼 데이터에 병원꾸러미에 잇는 데이터 넣어주는거지
			
			//SQL수행 및 결과 집합 저장
			rs = ps.executeQuery(); 
			
			//조회 결과 처리
			while(rs.next()) {
				result.setHos_code(rs.getInt("hos_code"));
				result.setHos_name(rs.getString("hos_name"));
				result.setHos_add(rs.getString("hos_add"));
				result.setHos_zip(rs.getInt("hos_zip"));
				result.setHos_call(rs.getString("hos_call"));
				result.setHos_time(rs.getString("hos_time"));
				result.setHos_trans(rs.getString("hos_trans"));
				result.setHos_park(rs.getString("hos_park"));
				result.setHos_price(rs.getInt("hos_price"));

				//1.병원에 데이터 넣어주는거고
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		System.out.println("MypageDao getHosInfo() - 끝");
		
		return result; //최종 결과 반환
	}
	
	@Override
	public int updateHosInfo(Connection conn, HosInfo param) {
		System.out.println("MypageDao updateHosInfo() - 시작");
		
		//SQL작성
		String sql = "";
		sql += "UPDATE hosInfo SET ";
		sql += " hos_name = ?";
		sql += " ,hos_add = ?";
		sql += " ,hos_zip = ?";
		sql += " ,hos_call = ?";
		sql += " ,hos_time = ?";
		sql += " ,hos_trans = ?";
		sql += " ,hos_park = ?";
		sql += " ,hos_price = ?";
		sql += " WHERE hos_code = ?";
		
		//결과 저정할 객체
		int result = 0;
		
		try {
			//SQL수행 객체
			ps = conn.prepareStatement(sql); 
			
			//SQL 파라메터 셋팅
			ps.setString(1, param.getHos_name());
			ps.setString(2, param.getHos_add());
			ps.setInt(3, param.getHos_zip());
			ps.setString(4, param.getHos_call());
			ps.setString(5, param.getHos_time());
			ps.setString(6, param.getHos_trans());
			ps.setString(7, param.getHos_park());
			ps.setInt(8, param.getHos_price());
			ps.setInt(9, param.getHos_code());

			//SQL수행 및 결과 집합 저장
			result = ps.executeUpdate(); 
			
			if(result > 0) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		System.out.println("MypageDao updateInfo() - 끝");
		
		return result; //최종 결과 반환
	}
	
	@Override
	public int deleteHosInfo(Connection conn, HosInfo param) {
		System.out.println("MypageDao deleteHosInfo() - 시작");
		
		//SQL작성
		String sql = "";
		sql += "DELETE FROM HosInfo";
		sql += " WHERE HosCode = ?";
		
		//결과 저정할 객체
		int result = 0;
		
		try {
			//SQL수행 객체
			ps = conn.prepareStatement(sql); 
			
			//SQL 파라메터 셋팅
			ps.setString(1, param.getHos_name());


			//SQL수행 및 결과 집합 저장
			result = ps.executeUpdate(); 
			
			if(result > 0) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		System.out.println("MypageDao deleteHosInfo() - 끝");
		
		return result; //최종 결과 반환
	}
	
	@Override
	public Pet getPet(Connection conn, Pet param) {
		System.out.println("MypageDao getPet() - 시작");
		
		//SQL작성
		String sql = "";
		sql += "SELECT * FROM pet";
		sql += " WHERE pet_no = ?";
		
		//결과 저정할 객체
		Pet result = new Pet();
		
		try {
			//SQL수행 객체
			ps = conn.prepareStatement(sql); 
			
			//SQL 파라메터 셋팅
			ps.setInt(1, param.getPetNo());
			
			//SQL수행 및 결과 집합 저장
			rs = ps.executeQuery(); 
			
			//조회 결과 처리
			while(rs.next()) {
				result.setPetNo(rs.getInt("pet_no"));
				result.setPetName(rs.getString("pet_name"));
				result.setPetAge(rs.getInt("pet_age"));
				result.setPetSex(rs.getString("pet_sex"));
				result.setPetType(rs.getString("pet_type"));
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
}