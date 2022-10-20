package review.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import review.dto.Review;
import review.service.face.ReviewService;
import review.service.impl.ReviewServiceImpl;

@WebServlet("/review/view")
public class ReviewViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ReviewService reviewService = new ReviewServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("/board/view [GET]");
		
		//boardno 확인
		System.out.println("ReviewViewController doGet() - boardno : " + req.getParameter("boardno"));

		//전달파라미터 객체 얻어오기
		Review boardno = reviewService.getBoardno(req);
		System.out.println("ReviewViewController doget() - boardno 객체: " + boardno);

		//게시글 상세보기 조회 결과 얻어오기
		Review viewBoard = reviewService.view( boardno );
		
		//조회 결과를 MODEL값으로 전달
		req.setAttribute("viewBoard", viewBoard);
		
		//View 지정 및 응답
		req.getRequestDispatcher("/WEB-INF/views/review/reviewDetail.jsp").forward(req, resp);
	}
	
	
}
