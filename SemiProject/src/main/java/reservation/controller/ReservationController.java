package reservation.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hosInfo.dto.HosInfo;
import login.dto.Owner;
import reservation.dto.Pet;
import reservation.dto.Reservation;
import reservation.service.face.ReservationService;
import reservation.service.impl.ReservationServiceImpl;

@WebServlet("/reservation")
public class ReservationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ReservationService reservationService = new ReservationServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/reservation [GET]");
		
		//회원정보에서 예약시 미리 정보를 사용할 수 있게 처리
		
		
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
		
		req.setCharacterEncoding("UTF-8");
		
		//doGet()에서 넘어온 정보로 결제창 넘어가기
		String name = req.getParameter("ownerName");
		String phone = req.getParameter("ownerPhone");
		String add = req.getParameter("ownerAddress");
		String pet1 = req.getParameter("petName");
		String age = req.getParameter("petAge");
		String sex = req.getParameter("petSex");
		String type = req.getParameter("petType");
		String date = req.getParameter("visitDate");
		String time = req.getParameter("visitTime");
		String detail = req.getParameter("reserDetail");
		String hosCode = req.getParameter("hosCode");
		System.out.println(name + phone + add + pet1 + age + sex + type + date + time + detail + "hoscode : " + hosCode);
		System.out.println("date : " + date);
		System.out.println("Time : " + time);
		
		//세션통해서 유저 정보 가져오기 
		
		//세션 객체
		HttpSession session = req.getSession();
		
		String ownerid = session.getId();
		
		//세션id를 이용해서 owner 정보 받아오기
		Owner owner = reservationService.getOwnerName(req, ownerid);
		System.out.println("owner : " + owner);
		
		req.setAttribute("owner", owner);
		
		//펫 정보 DTO 저장 -> DB 저장
		//펫 파라미터 가져오기
		Pet pet = reservationService.petparam(req);
		System.out.println("/reservation [POST] pet : " + pet);
		
		//파라미터로 DB Insert
		Pet result = reservationService.insertPet(pet);
		System.out.println("/reservation [POST] result " + result);
		
		req.setAttribute("pet", result);
		
		//파라미터 확인
		String code = req.getParameter("hosCode");
		System.out.println(code);
		
		//병원코드 가져오기
		HosInfo info = reservationService.getHosCode(req);
		System.out.println("/reservation [POST] info : " + info);
		
		//hoscode통해 hos정보 가져오기
		HosInfo hosInfo = reservationService.getInfo(req, info);
		System.out.println("/reservation [POST] hosinfo : " + hosInfo);
		
		req.setAttribute("hosInfo", hosInfo);
		
		//reservation에 insert하기 -  resNo, resDate, resDetail, ownerNo, petNo, hosNo;
		//reservation table resNo(nextval) 예약날짜 (date + time), 디테일 detail, 오너번호(owner.getOwnerNo), 펫번호(pet.getPetNo) 병원번호(hos_code) 
		
		//Reservation DTO에 resDate redetail 저장
		Reservation reser = reservationService.reserParam(req);
		
		Reservation reserResult = reservationService.insertReser(reser, owner, pet, hosInfo);
		
		req.setAttribute("reserResult", reserResult);
		
		
		//결제창에서 필요한 컬럼
		//보호자명, 전화번호, 이메일, 예약 일시
		
		//결제창 이후 결제 및 예약 내역 확인하기
		req.getRequestDispatcher("/WEB-INF/views/reservation/reserResult.jsp").forward(req, resp);
		
	}

}
