package reservation.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hosInfo.dto.HosInfo;
import reservation.service.face.SearchReserService;
import reservation.service.impl.SearchReserServiceImpl;
import util.Paging;

@WebServlet("/search/reser")
public class SearchReserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	SearchReserService searchReserService = new SearchReserServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/search/reser [GET]");
		
		//전달파라미터에서 현재 페이징 객체 계산하기
		Paging paging = searchReserService.getPaging(req);
		System.out.println("[TEST] " + paging);
		
		//v페이징 객체를 MODEL값 전달
		req.setAttribute("paging", paging);
		
		//게시글 페이징 전체 조회
		List<HosInfo> list = searchReserService.getList( paging );
		
		//[TEST] 조회결과 확인
		for(HosInfo h : list ) System.out.println(h);
		
		req.setAttribute("hosList", list);
		
		req.getRequestDispatcher("/WEB-INF/views/reservation/hosList.jsp").forward(req, resp);
		
	}
	
}
