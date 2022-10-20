package hosInfo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hosInfo.dto.HosInfo;
import hosInfo.service.face.HosInfoService;
import hosInfo.service.impl.HosInfoServiceImpl;

@WebServlet("/hos/list")
public class HosInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//서비스 객체
	private HosInfoService HosInfoService = new HosInfoServiceImpl();
		
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/hos/list [GET]");
		
		//테이블 전체 조회
		List<HosInfo> hosInfo = HosInfoService.getList();
		
		//조회결과를 MODEL값에 전달
		req.setAttribute("hosInfo", hosInfo);
		
		req.getRequestDispatcher("/WEB-INF/views/hosInfo/searchHos.jsp").forward(req, resp);
	}
}
