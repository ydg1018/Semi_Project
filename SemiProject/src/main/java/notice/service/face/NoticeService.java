package notice.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import notice.dto.Notice;
import util.Paging;

public interface NoticeService {
	
	/**
	 * 공지사항 전체 조회
	 * 
	 * @return List<Notice> - 전체 조회 목록
	 */
	
	public List<Notice> getList();

	/**
	 * 공지사항 페이징 목록 조회
	 * 
	 * @param paging - 페이징 정보 객체
	 * @return List<Notice> - 게시글 전체 조회 목록
	 */
	public List<Notice> getList(Paging paging);
	
	/**
	 * 게시글 페이징 객체 생성
	 * 
	 * @param req - 요청 정보 객체
	 * @return Paging - 페이징 계산이 완료된 객체
	 */
	public Paging getPaging(HttpServletRequest req);

}
