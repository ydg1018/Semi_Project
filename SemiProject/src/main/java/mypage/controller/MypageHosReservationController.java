package mypage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hosInfo.dto.HosInfo;
import login.dto.Hos;
import login.dto.Owner;
import mypage.service.face.MypageService;
import mypage.service.impl.MypageServiceImpl;
import reservation.dto.Pet;
import reservation.dto.Reservation;


@WebServlet("/mypage/hosReservation")
public class MypageHosReservationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
private MypageService mypageService = new MypageServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/mypage/hosReservation [GET]");

		//세션정보 객체
		HttpSession session = req.getSession();
		int hosNo = (int) session.getAttribute("hos_no");

		/**-----------로그인한 병원회원정보 조회 HOS -----------**/
		//서비스로 보낼 파라메터 데이터 셋팅
		Hos param = new Hos();
		param.setHosNo(hosNo);

		//로그인한 병원회원 정보 조회
		Hos data = mypageService.getHos(param);
		System.out.println("Hospital 정보 조회 data : " + data);
		/**--------------------------------------------**/
		
		/**-----------병원예약정보 조회 RESERVATION -----------**/
		//서비스로 보낼 파라메터 데이터 셋팅
		Reservation resparam = new Reservation();
		resparam.setHosCode(data.getHosCode());

		//로그인한 병원회원의 hosReservation 정보 조회
		Reservation resData = mypageService.getHosReservation(resparam);
		System.out.println("로그인한 병원회원의 HosReservation 정보 조회 data : " + resData);
		/**--------------------------------------------**/
		
		/**-----------병원상세정보 조회 HOSINFO -----------**/
		//서비스로 보낼 파라메터 데이터 셋팅
		HosInfo infoparam = new HosInfo();
		infoparam.setHos_code(data.getHosCode());

		//로그인한 병원회원의 hosInfo 정보 조회
		HosInfo infoData = mypageService.getHosInfo(infoparam);
		System.out.println("로그인한 병원회원의 HosInfo 정보 조회 data : " + infoData);
		/**--------------------------------------------**/
		
		/**-----------일반회원정보 조회 OWNER -----------**/
		//서비스로 보낼 파라메터 데이터 셋팅
		Owner ownerparam = new Owner();
		ownerparam.setOwnerNo(resData.getOwnerNo());
		
		//Owner 정보 조회
		Owner ownerData = mypageService.getOwner(ownerparam);
		System.out.println("Owner 정보 조회 data : " + ownerData);
		/**--------------------------------------------**/
		
		/**-----------펫정보 조회 OWNER -----------**/
		//서비스로 보낼 파라메터 데이터 셋팅
		Pet petparam = new Pet();
		petparam.setPetNo(resData.getPetNo());
		
		//Pet 정보 조회
		Pet petData = mypageService.getPet(petparam);
		System.out.println("Pet 정보 조회 data : " + petData);
		/**--------------------------------------------**/
				
		//조회결과를 MODEL값 전달
		req.setAttribute("data", data);				//로그인 병원회원 데이터
		req.setAttribute("resData", resData);		//예약 데이터
		req.setAttribute("infoData", infoData);		//예약병원 데이터
		req.setAttribute("ownerData", ownerData); 	//예약자 데이터
		req.setAttribute("petData", petData); 		//예약펫 데이터
		req.setAttribute("path", req.getServletPath());
		

		//View지정 및 응답
		req.getRequestDispatcher("/WEB-INF/views/mypage/hosReservation.jsp").forward(req, resp);
	}
}
