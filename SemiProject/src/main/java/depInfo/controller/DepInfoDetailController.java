package depInfo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import depInfo.dto.DepInfo;
import depInfo.service.face.DepInfoService;
import depInfo.service.impl.DepInfoServiceImpl;

@WebServlet("/dep/detail")
public class DepInfoDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//서비스 객체
	private DepInfoService depInfoService = new DepInfoServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/det/detail [GET]");
		
		//전달 파라미터 객체 얻어오기
		DepInfo det_item = depInfoService.getDet_item(req);
		
		//진료과 정보 상세보기 조회 결과 얻어오기
		DepInfo detail = depInfoService.view(det_item);
		
		//조회 결과를 MODEL값으로 전달
		req.setAttribute("detail", detail);
		
		//VIEW
		req.getRequestDispatcher("/WEB-INF/views/depInfo/detailDepInfo.jsp").forward(req, resp);
	}

}
