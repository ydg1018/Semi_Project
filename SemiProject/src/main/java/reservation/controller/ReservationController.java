package reservation.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.dto.Hospital;
import reservation.service.face.ReservationService;
import reservation.service.impl.ReservationServiceImpl;

@WebServlet("/reservation")
public class ReservationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ReservationService reservationService = new ReservationServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/reservation [GET]");
		
		req.getRequestDispatcher("/WEB-INF/views/reservation/reservation.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//doGet()에서 넘어온 정보로 결제창 넘어가기
		
		//결제창 이후 결제 및 예약 내역 확인하기
		req.getRequestDispatcher("/WEB-INF/views/reservation/reserResult.jsp").forward(req, resp);
		
	}

}
