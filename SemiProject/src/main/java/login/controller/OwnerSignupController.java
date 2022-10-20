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

@WebServlet("/signup/ownersignup")
public class OwnerSignupController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private LoginService loginService = new LoginServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/signup/ownersignup [GET]");
	
		req.getRequestDispatcher("/WEB-INF/views/login/signup/ownersignup.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/signup/ownersignup [POST]");

		//회원가입 전달파라미터 추출하기
		Owner owner = loginService.getJoinOwner(req);
				
		//회원가입 처리
		loginService.ownerJoin(owner);
		
		//메인으로 리다이렉트
		resp.sendRedirect("/main");
	}
}