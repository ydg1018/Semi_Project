package faq.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import faq.dao.face.FaqDao;
import faq.dto.FaQ;

public class FaqDaoImpl implements FaqDao {
	
	private PreparedStatement ps;
	private ResultSet rs;

	@Override
	public List<FaQ> selectAll(Connection conn) {
		System.out.println("FaqDaoImpl selectAll() - 시작");
		
		String sql = "";
		sql += "SELECT";
		sql += "	faqIdx, faqQuestion, faqAnswer";
		sql += " FROM faq";
		sql += " ORDER BY faqIdx ASC";
		
		List<FaQ> faqList = new ArrayList<>();
		
		return null;
	}
}
