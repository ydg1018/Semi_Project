package notice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.dto.Notice;
import notice.service.face.NoticeService;
import notice.service.impl.NoticeServiceImpl;
import util.Paging;


@WebServlet("/notice/list")
public class NoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

private NoticeService noticeService = new NoticeServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/notice/list [GET]");
		
		//전달파라미터에서 현재 페이징 객체 계산하기
		Paging paging = noticeService.getPaging(req);
		System.out.println("[TEST]" + paging);
		
		//페이징 객체를 MODEL값 전달
		req.setAttribute("paging", paging);
		
		//게시글 페이징 목록 조회
		List<Notice> noticeList = noticeService.getList(paging);
		
		//[TEST]조회결과 확인
//		for(Notice n : noticeList) System.out.println(n);
		
		//조회결과를 MODEL값 전달
		req.setAttribute("noticeList", noticeList);
		
		//View지정 및 응답
		req.getRequestDispatcher("/WEB-INF/views/notice/list.jsp").forward(req, resp);
	}
	
}
