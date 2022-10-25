package depInfo.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import depInfo.dto.DepInfo;
import depInfo.service.face.DepInfoService;
import depInfo.service.impl.DepInfoServiceImpl;

@WebServlet("/dep/result")
public class DepInfoResultController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//서비스 객체
	private DepInfoService depInfoService = new DepInfoServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/dep/result [GET]");
		
		String det_detail = req.getParameter("det_detail");
		
		ArrayList<DepInfo> list = depInfoService.searchDepInfo(det_detail);
		
		req.setAttribute("list", list);
		
		req.getRequestDispatcher("/WEB-INF/views/depInfo/resultDepInfo.jsp").forward(req, resp);
	
	}
       
}