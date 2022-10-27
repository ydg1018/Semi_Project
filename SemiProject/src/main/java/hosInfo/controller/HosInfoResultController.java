package hosInfo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hosInfo.dto.HosInfo;
import hosInfo.service.face.HosInfoService;
import hosInfo.service.impl.HosInfoServiceImpl;
import util.Paging;


@WebServlet("/hos/result")
public class HosInfoResultController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//서비스 객체
	private HosInfoService hosInfoService = new HosInfoServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/hos/result [GET]");
		
		//전달파라미터에서 현재 페이징 객체 계산하기
		Paging paging = hosInfoService.getPaging(req);
		
		//페이징 객체를 MDOEL값 전달
		req.setAttribute("paging", paging);
		
		//게시글 페이징 목록 조회
		List<HosInfo> hosInfo = hosInfoService.getList( paging );

		//조회결과를 MODEL값에 전달
		req.setAttribute("hosInfo", hosInfo);
				
		//검색
		String option = req.getParameter("option");
		String keyword = req.getParameter("keyword");
				
		ArrayList<HosInfo> list = hosInfoService.searchHosInfo(option, keyword);
				
		req.setAttribute("list", list);
		
		//View 지정 및 응답
		req.getRequestDispatcher("/WEB-INF/views/hosInfo/resultHos.jsp").forward(req, resp);
		
	}
	
}
	
