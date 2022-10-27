package mypage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login.dto.Hos;
import login.dto.Owner;
import mypage.service.face.MypageService;
import mypage.service.impl.MypageServiceImpl;


@WebServlet("/mypage/hospitalUpdate")
public class MypageHospitalUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

private MypageService mypageService = new MypageServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/mypage/hospitalUpdate [GET]");
		
		//세션정보 객체
		HttpSession session = req.getSession();
		String hos_no = (String) session.getAttribute("hos_no");
		//숫자형으로 변환 (임시로 1번 씀)
		int hospitalNo = 1; //Integer.parseInt(owner_no);
		
		//서비스로 보낼 파라메터 데이터 셋팅
		Hos param = new Hos();
		param.setHosNo(hospitalNo);
		
		//로그인한 Owner 정보 조회
		Hos data = mypageService.getHos(param);
		System.out.println("Hospital회원 정보 조회 data : " + data);

		//조회결과를 MODEL값 전달
		req.setAttribute("data", data);
		req.setAttribute("path", req.getServletPath());
		
		//View지정 및 응답
		req.getRequestDispatcher("/WEB-INF/views/mypage/hospitalUpdate.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/mypage/hospitalUpdate [POST]");
		
		//전달 파라미터의 한글 인코딩 설정
		req.setCharacterEncoding("UTF-8");
		
		//세션정보 객체
		HttpSession session = req.getSession();
		String hospital_no = (String) session.getAttribute("hospital_no");
		//숫자형으로 변환 (임시로 1번 씀)
		int hospitalNo = 1; //Integer.parseInt(owner_no);
		
		//서비스로 보낼 파라메터 데이터 셋팅
		Hos param = new Hos();
		
		param.setHosNo(hospitalNo);
//		param.setHosId(req.getParameter("hospitalId"));
		param.setHosPw(req.getParameter("hosPw"));
		param.setHosLic(Integer.parseInt(req.getParameter("hosLic").toString()));
		param.setHosCode(Integer.parseInt(req.getParameter("hosCode").toString()));
		
		//로그인한 hospital 정보 수정
		System.out.println("Hospital 정보 수정 param : " + param);
		int updateResult = mypageService.updateHos(param);
		System.out.println("Hospital 정보 수정 data : " + updateResult);

		resp.sendRedirect("/mypage/hospital");
	}
}