package login.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login.dto.Owner;
import login.service.face.LoginService;
import login.service.impl.LoginServiceImpl;

@WebServlet("/login/loginowner")
public class LoginOwnerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private LoginService loginService = new LoginServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/login/loginowner [GET]");
		
		req.getRequestDispatcher("/WEB-INF/views/login/loginowner.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/login/loginowner [POST]");
		
		// 전달 파라미터에 대한 한글 인코딩 설정
		req.setCharacterEncoding("UTF-8");
		
		// 전달파라미터 로그인 정보 얻어오기
		Owner owner = loginService.getLoginOwner(req);

		System.out.println("LoginController doPost() - owner : " + owner);

		// 로그인 인증
		boolean ownerLogin = loginService.OwnerLogin(owner);
		
		// 로그인 인증 성공
		if( ownerLogin ) {
			System.out.println("LoginController - 로그인 성공");
			
			// 로그인 사용자 정보 조회
			owner = loginService.OwnerInfo(owner);
			
			// 세션정보 객체
			HttpSession session = req.getSession();
			
			session.setAttribute("login", ownerLogin);
			session.setAttribute("owner_id", owner.getOwnerId());
			session.setAttribute("owner_pw", owner.getOwnerPw());
			session.setAttribute("owner_nick", owner.getOwnerNick());
			
			resp.sendRedirect("/hos/list");
		}
	}
}