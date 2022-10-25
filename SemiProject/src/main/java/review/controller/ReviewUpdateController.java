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
import util.BoardFile;

@WebServlet("/review/update")
public class ReviewUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//서비스 객체
	private ReviewService reviewService = new ReviewServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/review/update [GET]");
		
		System.out.println("ReviewUpdateController doGet() - 전달파라미터 boardno : " + req.getParameter("boardno"));
		
		//전달파라미터 저장 객체 얻기
		Review boardno = reviewService.getBoardno(req);
		System.out.println("ReviewUpdateController doGet() - 전달파라미터 객체 : " + boardno);
		
		
		//상세보기 결과 조회
		Review updateBoard = reviewService.view(boardno);
		System.out.println("ReviewUpdateController doGet() - 상세보기 객체 : " + updateBoard);
		
		//조회결과 MODEL값 전달
		req.setAttribute("updateBoard", updateBoard);

		
		//첨부파일 정보 조회
		BoardFile boardFile = reviewService.viewFile(updateBoard);
		
		//첨부파일 정보를 MODEL값 전달
		req.setAttribute("boardFile", boardFile);
		req.getRequestDispatcher("/WEB-INF/views/review/update.jsp").forward(req, resp);
}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	System.out.println("/review/update [POST]");

	reviewService.update(req);
	
	resp.sendRedirect("/review/list");
	
	}
}
