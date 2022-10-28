package faq.dao.face;

import java.sql.Connection;
import java.util.List;

import faq.dto.FAQ;

public interface FaqDao {
	
	/**
	 * FAQ 테이블 전체 조회
	 * @param conn - DB 연결 객체
	 * @return List<FAQ> - 테이블 전체 조회 목록
	 */
	List<FAQ> selectAll(Connection conn);

}
