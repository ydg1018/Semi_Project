package notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.dto.Notice;
import notice.service.face.NoticeService;
import notice.service.impl.NoticeServiceImpl;

@WebServlet("/notice/view")
public class NoticeViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/notice/view [GET]");
	
		System.out.println("NoticeViewController doGet() - noticeIdx : " + req.getParameter("noticeidx"));
		
		//전달파라미터 객체 얻어오기
		
		//게시글 상세보기 조회 결과 얻어오기
		
		//조회결과를 MODEL값으로 전달
		
		//View 지정 및 응답
		req.getRequestDispatcher("/WEB-INF/views/notice/view.jsp").forward(req, resp);
	
	}

}
