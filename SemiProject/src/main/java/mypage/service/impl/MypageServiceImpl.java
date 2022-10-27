package mypage.service.impl;

import java.sql.Connection;

import common.JDBCTemplate;
import hosInfo.dto.HosInfo;
import login.dto.Hos;
import login.dto.Owner;
import mypage.dao.face.MypageDao;
import mypage.dao.impl.MypageDaoImpl;
import mypage.service.face.MypageService;
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
	public Reservation getReservationOnwner(Reservation param) {
		 System.out.println("MypageService getReservationOnwner()");

		 //DB연결 객체
		 Connection conn = JDBCTemplate.getConnection();
		 
		 //DB조회결과 반환
		 return mypageDao.getReservationOnwner(conn, param);	 
	}
	
	@Override
	public Reservation getReservationHospital(Reservation param) {
		 System.out.println("MypageService getReservationHospital()");

		 //DB연결 객체
		 Connection conn = JDBCTemplate.getConnection();
		 
		 //DB조회결과 반환
		 return mypageDao.getReservationHospital(conn, param);	 
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
}
