package mypage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login.dto.Owner;
import mypage.service.face.MypageService;
import mypage.service.impl.MypageServiceImpl;
import util.Paging;

@WebServlet("/mypage/owner")
public class MypageOwnerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

private MypageService mypageService = new MypageServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/mypage/owner [GET]");
		
		//세션정보 객체
		HttpSession session = req.getSession();
		String owner_no = (String) session.getAttribute("owner_no");
		//숫자형으로 변환 (임시로 1번 씀)
		int ownerNo = 1; //Integer.parseInt(owner_no);
		
		//서비스로 보낼 파라메터 데이터 셋팅
		Owner param = new Owner();
		param.setOwnerNo(ownerNo);
		
		//로그인한 Owner 정보 조회
		Owner data = mypageService.getOwner(param);
		System.out.println("Owner 정보 조회 data : " + data);

		//조회결과를 MODEL값 전달
		req.setAttribute("data", data);
		req.setAttribute("path", req.getServletPath());
		
		//View지정 및 응답
		req.getRequestDispatcher("/WEB-INF/views/mypage/owner.jsp").forward(req, resp);
	}
	
}
