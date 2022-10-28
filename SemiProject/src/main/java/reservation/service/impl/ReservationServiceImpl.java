package reservation.service.impl;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import hosInfo.dto.HosInfo;
import login.dto.Owner;
import reservation.dao.face.ReservationDao;
import reservation.dao.impl.ReservationDaoImpl;
import reservation.dto.Payment;
import reservation.dto.Pet;
import reservation.dto.Reservation;
import reservation.service.face.ReservationService;

public class ReservationServiceImpl implements ReservationService {

	ReservationDao reservationDao = new ReservationDaoImpl();
	
	@Override
	public HosInfo getHosCode(HttpServletRequest req) {
		
		HosInfo hosInfo = new HosInfo();
		
		String param = req.getParameter("hosCode");
		if( null !=param && !"".equals(param) ) {
			hosInfo.setHos_code( Integer.parseInt(param));
		}
		
		return hosInfo;
	}
	
	@Override
	public HosInfo getInfo(HttpServletRequest req, HosInfo hosCode) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		HosInfo hosInfo = reservationDao.selectHosByHosCode(conn, hosCode);
		
		
		return hosInfo;
	}
	
	//-----------------------------------------doPost--------------------------------------------
	
	@Override
	public Pet petparam(HttpServletRequest req) {
		
		Pet petparam = new Pet();
		
		String Age = req.getParameter("petAge");
		int petAge = 0;
		if( null!=Age && !"".equals(Age)) {
			petAge = Integer.parseInt(Age);
		}

		petparam.setPetName( req.getParameter("petName") );
		petparam.setPetAge(petAge);
		petparam.setPetSex(req.getParameter("petSex"));
		petparam.setPetType(req.getParameter("petType"));
		
		return petparam;
	}
	
	@Override
	public Pet insertPet(Pet pet) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		//pet_seq의 nextval을 조회한다
		int next = reservationDao.selectNextPetNo(conn);
		
		//조회된 nextval을 member객체에 저장한다
		pet.setPetNo(next);
		
		//완성된 member객체를 DB에 삽입
		int result = reservationDao.insert(conn, pet);
		
		if( result > 0) {
			JDBCTemplate.commit(conn);
			return pet;
		} else {
			JDBCTemplate.commit(conn);
			return null;
		}
		
	}
	
	@Override
	public Owner getOwnerName(HttpServletRequest req, String ownerid) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		System.out.println("Service ownerid : " + ownerid);
		
		Owner ownerID = new Owner();
		
		ownerID.setOwnerId(ownerid);
		System.out.println("SERVICE ownerN : " + ownerID);
		
		
		Owner owner = reservationDao.selectOnwerByOnwerid(conn, ownerID);
		
		System.out.println("Service owner" + owner);
		
		return owner;
	}
	
	@Override
	public Reservation reserParam(HttpServletRequest req) {
		
		Reservation reservation = new Reservation();
		
		String date = req.getParameter("visitDate");
		String time = req.getParameter("visitTime");
		String dateTime = date + " " + time;

		String tail = req.getParameter("reserDetail");
		reservation.setResDate(dateTime);
		reservation.setResDetail(tail);
		
		return reservation;
	}
	
	@Override
	public Reservation insertReser(Reservation reser, Owner owner, Pet pet, HosInfo hosInfo) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		//reservation nextval 조회하기
		int next = reservationDao.selectNextresNo(conn);
		
		reser.setResNo(next);
		
		int result = reservationDao.insertreser(conn, reser, owner, pet, hosInfo);
		
		if( result > 0) {
			JDBCTemplate.commit(conn);
			return reser;
		} else {
			JDBCTemplate.commit(conn);
			return null;
		}
		
	}
	
	@Override
	public Payment getMerchat(HttpServletRequest req) {
		
		Payment pay = new Payment();
		
		String merchat = req.getParameter("merchant_uid");
		pay.setPayNo(merchat);
		String money = req.getParameter("payMoney");
		if( null !=money && !"".equals(money) ) {
			pay.setPayMoney( Integer.parseInt(money));
		}
		
		return pay;
	}
	
	@Override
	public Payment insertpay(Payment pay, Reservation reserResult, Owner owner, HosInfo hosInfo) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		
		int result = reservationDao.insertpay(conn, pay, reserResult, owner, hosInfo);
		
		if( result > 0) {
			JDBCTemplate.commit(conn);
			return pay;
		} else {
			JDBCTemplate.commit(conn);
			return null;
		}
	}
	
}
