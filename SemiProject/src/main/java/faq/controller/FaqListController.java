package faq.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import faq.dto.FAQ;
import faq.service.face.FaqService;
import faq.service.impl.FaqServiceImpl;

@WebServlet("/faq/list")
public class FaqListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private FaqService faqService = new FaqServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/faq/list [GET]");
		
		List<FAQ> faqList = faqService.getList();
		
		//조회결과 MODEL값 전달
		req.setAttribute("faqList", faqList);
		
		//View지정
		req.getRequestDispatcher("/WEB-INF/views/faq/list.jsp").forward(req, resp);
	}

}
