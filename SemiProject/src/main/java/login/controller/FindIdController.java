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

@WebServlet("/login/findid")
public class FindIdController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private LoginService loginService = new LoginServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/login/findid [GET]");
		
		req.getRequestDispatcher("/WEB-INF/views/login/findid.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/login/findid [POST]");
		
		// 전달 파라미터에 대한 한글 인코딩 설정
		req.setCharacterEncoding("UTF-8");
		
		Owner owner = loginService.getFindOwnerId(req);
		
		System.out.println(owner);
		
		Owner owner_id = loginService.findId(owner);
		
		System.out.println(owner_id);
		
		req.setAttribute("owner_id", owner_id);
		
		req.getRequestDispatcher("/WEB-INF/views/login/findidOk.jsp").forward(req, resp);
	}
}