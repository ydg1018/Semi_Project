package mypage.service.impl;

import java.sql.Connection;

import common.JDBCTemplate;
import hosInfo.dto.HosInfo;
import login.dto.Hos;
import login.dto.Owner;
import mypage.dao.face.MypageDao;
import mypage.dao.impl.MypageDaoImpl;
import mypage.service.face.MypageService;
import reservation.dto.Pet;
import reservation.dto.Reservation;

public class MypageServiceImpl implements MypageService {

	//DAO객체
	private MypageDao mypageDao = new MypageDaoImpl();

	@Override
	public Owner getOwner(Owner param) {
		System.out.println("MypageService getOwner()");
		
		//DB연결 객체
		Connection conn = JDBCTemplate.getConnection();

		//DB조회결과 반환
		return mypageDao.getOwner(conn, param);
		 
	}

	@Override
	public int updateOwner(Owner param) {
		 System.out.println("MypageService updateOwner()");

		 //DB연결 객체
		 Connection conn = JDBCTemplate.getConnection();
			
		 //DB조회결과 반환
		 return mypageDao.updateOwner(conn, param);
		 
	}

	@Override
	public int deleteOwner(Owner param) {
		 System.out.println("MypageService deleteOwner()");
		 
		 //DB연결 객체
		 Connection conn = JDBCTemplate.getConnection();

		 //DB조회결과 반환
		 return mypageDao.deleteOwner(conn, param);
		 
	}

	@Override
	public Reservation getOwnerReservation(Reservation param) {
		 System.out.println("MypageService getOwnerReservation()");

		 //DB연결 객체
		 Connection conn = JDBCTemplate.getConnection();
		 
		 //DB조회결과 반환
		 return mypageDao.getOwnerReservation(conn, param);	 
	}
	
	@Override
	public Reservation getHosReservation(Reservation param) {
		 System.out.println("MypageService getHosReservation()");

		 //DB연결 객체
		 Connection conn = JDBCTemplate.getConnection();
		 
		 //DB조회결과 반환
		 return mypageDao.getHosReservation(conn, param);	 
	}
	
	
	@Override
	public Hos getHos(Hos param) {
		System.out.println("MypageService getOwner()");
		
		//DB연결 객체
		Connection conn = JDBCTemplate.getConnection();

		//DB조회결과 반환
		return mypageDao.getHospital(conn, param);
		 
	}

	@Override
	public int updateHos(Hos param) {
		 System.out.println("MypageService updateHospital()");

		 //DB연결 객체
		 Connection conn = JDBCTemplate.getConnection();
			
		 //DB조회결과 반환
		 return mypageDao.updateHospital(conn, param);
		 
	}

	@Override
	public int deleteHos(Hos param) {
		 System.out.println("MypageService deleteHospital()");
		 
		 //DB연결 객체
		 Connection conn = JDBCTemplate.getConnection();

		 //DB조회결과 반환
		 return mypageDao.deleteHospital(conn, param);
		 
	}
	
	
	
	
	@Override
	public HosInfo getHosInfo(HosInfo param) {
		System.out.println("MypageService getHosInfo()");
		
		//DB연결 객체
		Connection conn = JDBCTemplate.getConnection();

		//DB조회결과 반환
		return mypageDao.getHosInfo(conn, param);
		 
	}

	@Override
	public int updateHosInfo(HosInfo param) {
		 System.out.println("MypageService updateHosInfo()");

		 //DB연결 객체
		 Connection conn = JDBCTemplate.getConnection();
			
		 //DB조회결과 반환
		 return mypageDao.updateHosInfo(conn, param);
		 
	}

	@Override
	public int deleteHosInfo(HosInfo param) {
		 System.out.println("MypageService deleteHosInfo()");
		 
		 //DB연결 객체
		 Connection conn = JDBCTemplate.getConnection();

		 //DB조회결과 반환
		 return mypageDao.deleteHosInfo(conn, param);
		 
	}
	

	@Override
	public Pet getPet(Pet param) {
		System.out.println("MypageService getPet()");
		
		//DB연결 객체
		Connection conn = JDBCTemplate.getConnection();

		//DB조회결과 반환
		return mypageDao.getPet(conn, param);
		 
	}
}
