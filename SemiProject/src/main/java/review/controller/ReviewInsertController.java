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


@WebServlet("/review/insert")
public class ReviewInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/review/insert [GET]");
		
		req.getRequestDispatcher("/WEB-INF/views/review/insert.jsp").forward(req, resp);
}

	private ReviewService reviewService = new ReviewServiceImpl();

	@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	System.out.println("/review/insert [POST]");

	//전달 파라미터 한글 인코딩 처리
	req.setCharacterEncoding("UTF-8");
		
	reviewService.write(req);
	
	resp.sendRedirect("/review/list");
	
	}
}
