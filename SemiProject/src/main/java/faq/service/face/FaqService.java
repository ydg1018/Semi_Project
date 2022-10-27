package faq.service.face;

import java.util.List;

import faq.dto.FAQ;

public interface FaqService {
	
	/**
	 * FAQ 전체 조회
	 * @return List<FAQ> 전체 조회 목록
	 */
	public List<FAQ> getList();

}
