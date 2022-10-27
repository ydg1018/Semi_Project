package mypage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hosInfo.dto.HosInfo;
import login.dto.Hospital;
import login.dto.Owner;
import mypage.service.face.MypageService;
import mypage.service.impl.MypageServiceImpl;


@WebServlet("/mypage/hosInfoUpdate")
public class MypageHosInfoUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

private MypageService mypageService = new MypageServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/mypage/hosInfoUpdate [GET]");
		
		//세션정보 객체
		HttpSession session = req.getSession();
		String hos_no = (String) session.getAttribute("hos_no");
		//숫자형으로 변환 (임시로 1번 씀)
		int hospitalNo = 1; //Integer.parseInt(owner_no);
		
		//서비스로 보낼 파라메터 데이터 셋팅
		Hospital param = new Hospital();
		param.setHosNo(hospitalNo);

		//로그인한 병원회원 정보 조회
		Hospital data = mypageService.getHospital(param);
		System.out.println("Hospital 정보 조회 data : " + data);
			
		//서비스로 보낼 파라메터 데이터 셋팅
		HosInfo infoparam = new HosInfo();
		infoparam.setHos_code(data.getHosCode());

		//로그인한 병원회원의 hosInfo 정보 조회
		HosInfo infoData = mypageService.getHosInfo(infoparam);
		System.out.println("로그인한 병원회원의 HosInfo 정보 조회 data : " + infoData);
		
		//조회결과를 MODEL값 전달
		req.setAttribute("data", data);
		req.setAttribute("infoData", infoData);
		req.setAttribute("path", req.getServletPath());
		
		//View지정 및 응답
		req.getRequestDispatcher("/WEB-INF/views/mypage/hosInfoUpdate.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/mypage/hosInfoUpdate [POST]");
		
		//전달 파라미터의 한글 인코딩 설정
		req.setCharacterEncoding("UTF-8");
		
		//세션정보 객체
		HttpSession session = req.getSession();
		String hospital_no = (String) session.getAttribute("hospital_no");
		//숫자형으로 변환 (임시로 1번 씀)
		int hospitalNo = 1; //Integer.parseInt(owner_no);
		
		//서비스로 보낼 파라메터 데이터 셋팅
		Hospital param = new Hospital();
		HosInfo infoparam = new HosInfo();
	
		
		infoparam.setHos_name(req.getParameter("HosName"));
		infoparam.setHos_add(req.getParameter("hosAdd"));
		infoparam.setHos_zip(Integer.parseInt(req.getParameter("hosZip")));
		infoparam.setHos_call(req.getParameter("hosCall"));
		infoparam.setHos_time(req.getParameter("hosTime"));
		infoparam.setHos_trans(req.getParameter("hosTrans"));
		infoparam.setHos_park(req.getParameter("hosPark"));
		infoparam.setHos_price(Integer.parseInt(req.getParameter("hosPrice")));

		//로그인한 병원회원 병원정보 수정
		System.out.println("병원회원 병원정보 수정 param : " + param);
		int updateResult = mypageService.updateHosInfo(infoparam);
		System.out.println("병원회원 병원정보 수정 data : " + updateResult);

		resp.sendRedirect("/mypage/hosInfoUpdate");
	}
}