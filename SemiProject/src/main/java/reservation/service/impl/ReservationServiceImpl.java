package reservation.service.impl;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import hosInfo.dto.HosInfo;
import reservation.dao.face.ReservationDao;
import reservation.dao.impl.ReservationDaoImpl;
import reservation.dto.Pet;
import reservation.service.face.ReservationService;

public class ReservationServiceImpl implements ReservationService {

	ReservationDao reservationDao = new ReservationDaoImpl();
	
	@Override
	public HosInfo getHosCode(HttpServletRequest req) {
		
		HosInfo hosInfo = new HosInfo();
		
		String param = req.getParameter("hosCode");
		if( null !=param && !"".equals(param) ) {
			hosInfo.setHosCode( Integer.parseInt(param));
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
		
		petparam.setPetName( req.getParameter("petName") );
		petparam.setPetAge( Integer.parseInt( req.getParameter("petAge")) );
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
	
}
