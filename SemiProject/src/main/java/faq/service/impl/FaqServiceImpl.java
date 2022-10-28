package faq.service.impl;

import java.util.List;

import common.JDBCTemplate;
import faq.dao.face.FaqDao;
import faq.dao.impl.FaqDaoImpl;
import faq.dto.FAQ;
import faq.service.face.FaqService;

public class FaqServiceImpl implements FaqService {
	
	private FaqDao faqDao = new FaqDaoImpl();
	
	@Override
	public List<FAQ> getList() {
		System.out.println("FaqServiceList getList() - 시작");

		System.out.println("FaqServiceList getList() - 끝");
		
		return faqDao.selectAll(JDBCTemplate.getConnection());
	}

}
