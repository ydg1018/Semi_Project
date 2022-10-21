package reservation.service.impl;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import hosInfo.dto.HosInfo;
import reservation.dao.face.ReservationDao;
import reservation.dao.impl.ReservationDaoImpl;
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
	
}
