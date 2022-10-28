package review.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login.dto.Owner;
import login.service.face.LoginService;
import review.dto.Review;
import review.service.face.ReviewService;
import review.service.impl.ReviewServiceImpl;
import util.Paging;

@WebServlet("/review/list")
public class ReviewListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ReviewService reviewService = new ReviewServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/review/list [GET]");
		
		String field = req.getParameter("f");
		String query = req.getParameter("q");
		
		Owner owner = new Owner();
		
		// 세션정보 객체
		HttpSession session = req.getSession();
		
		String ownerNick = (String) session.getAttribute("owner_nick");
			
		//페이징객체 생성
//		Paging paging = reviewService.getPaging(req);
		Paging paging = reviewService.getPaging(req, field, query);
		System.out.println(paging);
		
		//페이징 객체를 MODEL값 전달
		req.setAttribute("paging", paging);
		
		//게시글 페이징, 검색 목록 조회
		List<Review> reviewList = reviewService.getList( paging, field, query );
		
		//test
		for(Review r : reviewList)	System.out.println(r);
		
		//MODEL값 전달
		req.setAttribute("reviewList", reviewList);
		
		//View 지정 및 응답
		req.getRequestDispatcher("/WEB-INF/views/review/reviewList.jsp").forward(req, resp);
	}
}
