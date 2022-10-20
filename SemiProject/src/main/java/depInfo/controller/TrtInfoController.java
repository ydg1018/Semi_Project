package depInfo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import depInfo.dto.TrtInfo;
import depInfo.service.face.TrtInfoService;
import depInfo.service.impl.TrtInfoServiceImpl;

@WebServlet("/trt/list")
public class TrtInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	//서비스 객체
	private TrtInfoService trtInfoService = new TrtInfoServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/trt/list [GET]");
		
		//테이블 전체 조회
		List<TrtInfo> trtInfo = trtInfoService.getList();
		
		//조회결과를 MODEL값에 전달
		req.setAttribute("trtInfo", trtInfo);
		
		//VIEW 지정 및 응답
		req.getRequestDispatcher("/WEB-INF/views/depInfo/searchTrt.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/trt/list [POST]");
		
	}
}
