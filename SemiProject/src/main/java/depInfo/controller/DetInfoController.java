package depInfo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import depInfo.dto.DetInfo;
import depInfo.service.face.DetInfoService;
import depInfo.service.impl.DetInfoServiceImpl;

@WebServlet("/det/list")
public class DetInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	//서비스 객체
	private DetInfoService detInfoService = new DetInfoServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/det/list [GET]");
		
		//테이블 전체 조회
		List<DetInfo> detInfo = detInfoService.getList();
		
		//조회결과를 MODEL값에 전달
		req.setAttribute("detInfo", detInfo);
		
		//VIEW 지정 및 응답
		req.getRequestDispatcher("/WEB-INF/views/depInfo/searchDet.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/det/list [POST]");
		
	}
}
