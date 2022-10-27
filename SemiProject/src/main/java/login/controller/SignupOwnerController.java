package login.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.dto.Owner;
import login.service.face.LoginService;
import login.service.impl.LoginServiceImpl;

@WebServlet("/login/signupowner")
public class SignupOwnerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private LoginService loginService = new LoginServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/login/signupowner [GET]");
	
		req.getRequestDispatcher("/WEB-INF/views/login/signupowner.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/login/signupowner [POST]");

		// 전달 파라미터에 대한 한글 인코딩 설정
		req.setCharacterEncoding("UTF-8");
		
		// 회원가입 전달파라미터 추출하기
		Owner owner = loginService.getJoinOwner(req);
				
		// 회원가입 처리
		loginService.OwnerJoin(owner);
		
		System.out.println("owner : " + owner);
		
		// 로그인 화면으로 리다이렉트
		resp.sendRedirect("/login/login");
	}
}