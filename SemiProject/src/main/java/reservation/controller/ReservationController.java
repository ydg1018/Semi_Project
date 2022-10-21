package reservation.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hosInfo.dto.HosInfo;
import reservation.service.face.ReservationService;
import reservation.service.impl.ReservationServiceImpl;

@WebServlet("/reservation")
public class ReservationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ReservationService reservationService = new ReservationServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/reservation [GET]");
		
		//선택된 병원 이름,(hos_no)를 이용해서 정보 조회한 후 병원 정보 보여주기
		String hosCode = req.getParameter("hosCode");
		System.out.println("/reservation [GET] hosCode : " + hosCode);
		
		HosInfo info = reservationService.getHosCode(req);
		System.out.println("/reservation [GET] info : " + info);
		
		//hosCode를 이용해서 Hosinfo 객체 가져오기
		HosInfo hosInfo = reservationService.getInfo(req, info);
		System.out.println("/reservation [GET] hosInfo : " + hosInfo);
		
		req.setAttribute("hosInfo", hosInfo);
		
		req.getRequestDispatcher("/WEB-INF/views/reservation/reservation.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/reservation [POST]");
		//doGet()에서 넘어온 정보로 결제창 넘어가기
		String name = req.getParameter("ownerName");
		String phone = req.getParameter("ownerPhone");
		String add = req.getParameter("ownerAddress");
		String pet = req.getParameter("petName");
		String age = req.getParameter("petAge");
		String sex = req.getParameter("petSex");
		String type = req.getParameter("petType");
		String date = req.getParameter("visitDate");
		String time = req.getParameter("visitTime");
		String detail = req.getParameter("reserDetail");
		
		//reservation에 insert하기 - 
//		Reservation input = reservationService.inputReservation();
		
		
		
		//결제창 이후 결제 및 예약 내역 확인하기
		req.getRequestDispatcher("/WEB-INF/views/payment/INIstdpay_pc_req.jsp").forward(req, resp);
		
	}

}
