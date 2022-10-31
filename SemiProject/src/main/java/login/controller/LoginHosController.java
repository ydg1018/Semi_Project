package login.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login.dto.Hos;
import login.service.face.LoginService;
import login.service.impl.LoginServiceImpl;

@WebServlet("/login/loginhos")
public class LoginHosController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private LoginService loginService = new LoginServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/login/loginhos [GET]");
		
		req.getRequestDispatcher("/WEB-INF/views/login/loginhos.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/login/loginhos [POST]");
		
		// 전달 파라미터에 대한 한글 인코딩 설정
		req.setCharacterEncoding("UTF-8");
		
		// 전달파라미터 로그인 정보 얻어오기
		Hos hos = loginService.getLoginHos(req);
	
		// 로그인 인증
		boolean hosLogin = loginService.Hoslogin(hos);
		
		// 로그인 인증 성공
		if( hosLogin ) {
			System.out.println("Controller - 로그인 성공");
			
			// 로그인 사용자 정보 조회
			hos = loginService.HosInfo(hos);
			
			// 세션정보 객체
			HttpSession session = req.getSession();
			
			session.setAttribute("login", hosLogin);
			session.setAttribute("hos_id", hos.getHosId());
			session.setAttribute("hos_pw", hos.getHosPw());
			session.setAttribute("hos_lic", hos.getHosLic());
//			session.setAttribute("hos_name", hos.getHosName());
			
			resp.sendRedirect("/hos/list");
		}
	}
}