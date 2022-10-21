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
	
	/**
	 * 전달파라미터 noticeIdx를 Notice DTO로 저장하여 반환한다.
	 * 
	 * @param req - 요청 정보 객체
	 * @return Notice - 전달파라미터 noticeIdx를 저장한 DTO객체
	 */
	public Notice getNoticeIdx(HttpServletRequest req);
	
	/**
	 * 전달된 noticeIdx를 이용하여 게시글을 조회한다.
	 * 조회된 게시글의 조회수를 1 증가시킨다.
	 * 
	 * @param noticeIdx - 조회할 noticeIdx를 가진 DTO객체
	 * @return notice - 조회된 게시글 정보
	 */
	public Notice view(Notice noticeIdx);

}
