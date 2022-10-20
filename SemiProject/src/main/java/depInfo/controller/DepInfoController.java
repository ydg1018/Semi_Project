package depInfo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import depInfo.dto.DepInfo;
import depInfo.service.face.DepInfoService;
import depInfo.service.impl.DepInfoServiceImpl;

@WebServlet("/dep/list")
public class DepInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	//서비스 객체
	private DepInfoService depInfoService = new DepInfoServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/dep/list [GET]");
		
		//테이블 전체 조회
		List<DepInfo> depInfo = depInfoService.getList();
		
		//조회결과를 MODEL값에 전달
		req.setAttribute("depInfo", depInfo);
		
		//VIEW 지정 및 응답
		req.getRequestDispatcher("/WEB-INF/views/depInfo/searchDep.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/dep/list [POST]");
		
	}
}
