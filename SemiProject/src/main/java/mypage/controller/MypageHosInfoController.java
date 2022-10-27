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
import mypage.service.face.MypageService;
import mypage.service.impl.MypageServiceImpl;


@WebServlet("/mypage/hosInfo")
public class MypageHosInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
private MypageService mypageService = new MypageServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/mypage/hosInfo [GET]");

		//세션정보 객체
		HttpSession session = req.getSession();
		String hos_no = (String) session.getAttribute("hos_no");
		//숫자형으로 변환 (임시로 1번 씀)
		int hosNo = 1; //Integer.parseInt(hos_no);

		//서비스로 보낼 파라메터 데이터 셋팅
		Hospital param = new Hospital();
		param.setHosNo(hosNo);

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
		req.getRequestDispatcher("/WEB-INF/views/mypage/hosInfo.jsp").forward(req, resp);
	}
}
