package faq.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import faq.dao.face.FaqDao;
import faq.dto.FAQ;

public class FaqDaoImpl implements FaqDao {
	
	private PreparedStatement ps;
	private ResultSet rs;

	@Override
	public List<FAQ> selectAll(Connection conn) {
		System.out.println("FaqDaoImpl selectAll() - 시작");
		
		String sql = "";
		sql += "SELECT";
		sql += "	faq_idx, faq_question, faq_answer";
		sql += " FROM faq";
		sql += " ORDER BY faq_idx ASC";
		
		//결과 저장 List
		List<FAQ> faqList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				FAQ f = new FAQ();
				
				f.setFaqIdx(rs.getInt("faq_idx"));
				f.setFaqQuestion(rs.getString("faq_question"));
				f.setFaqAnswer(rs.getString("faq_answer"));
				
				//리스트에 결과값 저장하기
				faqList.add(f);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		System.out.println("FaqDaoImpl selectAll() - 끝");
		
		return faqList;
	}
}
