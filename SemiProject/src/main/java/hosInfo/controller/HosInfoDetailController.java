package hosInfo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hosInfo.dto.HosInfo;
import hosInfo.service.face.HosInfoService;
import hosInfo.service.impl.HosInfoServiceImpl;

@WebServlet("/hos/detail")
public class HosInfoDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//서비스 객체
	private HosInfoService hosInfoService = new HosInfoServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/hos/view [GET]");
		
		//전달 파라미터 객체 얻어오기
		HosInfo hos_name = hosInfoService.getHos_name(req);
		
		//병원 정보 상세보기 조회 결과 얻어오기
		HosInfo detailHosInfo = hosInfoService.view(hos_name);
		
		//조회 결과를 MODEL값으로 전달
		req.setAttribute("detailHosInfo", detailHosInfo);
		
		//View 지정 및 응답
		req.getRequestDispatcher("/WEB-INF/views/hosInfo/detailHos.jsp").forward(req, resp);

	}
	
	
}
