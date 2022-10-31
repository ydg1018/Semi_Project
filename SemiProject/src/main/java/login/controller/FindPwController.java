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

@WebServlet("/login/findpw")
public class FindPwController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private LoginService loginService = new LoginServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/login/findpw [GET]");
		
		req.getRequestDispatcher("/WEB-INF/views/login/findpw.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/login/findpw [POST]");
	
		// 전달 파라미터에 대한 한글 인코딩 설정
		req.setCharacterEncoding("UTF-8");
		
		Owner owner = loginService.getFindOwnerPw(req);
		
		System.out.println(owner);
		
		Owner owner_pw = loginService.findPw(owner);
		
		System.out.println(owner_pw);
		
		req.setAttribute("owner_pw", owner_pw);
		
		req.getRequestDispatcher("/WEB-INF/views/login/findpwOk.jsp").forward(req, resp);
	}
}