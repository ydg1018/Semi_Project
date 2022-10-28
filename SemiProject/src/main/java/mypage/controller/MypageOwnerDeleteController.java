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

/**
 * 회원정보 삭제 컨트롤러
 * 회원정보 삭제시 예약,게시글 등등 다른 테이블도 삭제해야하는지 미정
 * 추후에 결정 후 만들어야함
 * **/
@WebServlet("/mypage/ownerDelete")
public class MypageOwnerDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

private MypageService mypageService = new MypageServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/mypage/ownerDelete [GET]");
		
		//세션정보 객체
		HttpSession session = req.getSession();
		int ownerNo = (int) session.getAttribute("owner_no");
		
		//서비스로 보낼 파라메터 데이터 셋팅
		Owner param = new Owner();
		param.setOwnerNo(ownerNo);
		
		//로그인한 Owner 정보 삭제
		int data = mypageService.deleteOwner(param);
		System.out.println("Owner 정보 삭제 data : " + data);

		//조회결과를 MODEL값 전달
		req.setAttribute("data", data);
		
		//View지정 및 응답
		req.getRequestDispatcher("/WEB-INF/views/mypage/ownerUpdate.jsp").forward(req, resp);
	}
	
}
