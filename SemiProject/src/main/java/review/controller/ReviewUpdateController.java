package review.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import review.dto.Review;
import review.service.face.ReviewService;
import review.service.impl.ReviewServiceImpl;

@WebServlet("/review/update")
public class ReviewUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//서비스 객체
	private ReviewService reviewService = new ReviewServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/review/update [GET]");
		
		req.getRequestDispatcher("/WEB-INF/views/review/update.jsp").forward(req, resp);
}


	@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	System.out.println("/review/update [POST]");

	//전달 파라미터 한글 인코딩 처리
	req.setCharacterEncoding("UTF-8");
	
	int boardno = Integer.parseInt(req.getParameter("boardno"));
	
	Review review = new Review();
	
	//세션정보 객체
	HttpSession session = req.getSession();
	
	String owner_no = (String) session.getAttribute("owner_no");
	
	review.setBoardNo(boardno);
	review.setBoardTitle(req.getParameter("title"));
	review.setBoardContent(req.getParameter("content"));
	review.setOwnerNo(Integer.parseInt(owner_no)); //체크
	
	reviewService.update(review);
	
	resp.sendRedirect("/review/list");
	
	}
}
