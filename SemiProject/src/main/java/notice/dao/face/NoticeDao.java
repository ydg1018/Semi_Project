package notice.dao.face;

import java.sql.Connection;
import java.util.List;

import notice.dto.Notice;
import util.Paging;

public interface NoticeDao {
	
	/**
	 * 공지사항 테이블 전체 조회
	 * 
	 * @param conn - DB 연결 객체
	 * @return List<Notice> - 테이블 전체 조회 목록
	 */
	public List<Notice> selectAll(Connection conn);

	/**
	 * 공지사항 테이블 페이징 목록 조회
	 * 
	 * @param conn - DB 연결 객체
	 * @param paging - 페이징 정보 객체
	 * @return List<Notice> - 테이블 페이징 목록 조회 결과
	 */
	public List<Notice> selectAll(Connection conn, Paging paging);

	/**
	 * 총 게시글 수 조회
	 * 
	 * @param connection - DB 연결 객체
	 * @return int - 테이블의 전체 행 수
	 */
	public int selectCntAll(Connection conn);
	
	/**
	 * 조회된 게시글의 조회수 증가시키기
	 * 
	 * @param conn - DB 연결 객체
	 * @param noticeIdx - 조회할 게시글의 noticeIdx를 가진 DTO객체
	 * @return int - UPDATE쿼리 수행 결과
	 */
	public int updateHit(Connection conn, Notice noticeIdx);

	/**
	 * 지정된 noticeIdx의 게시글 조회하기
	 * @param conn - DB 연결 객체
	 * @param noticeIdx - 조회할 공지사항의 noticeIdx를 가진 DTO객체
	 * @return Notice - 조회된 게시글의 상세정보 DTO객체
	 */
	public Notice selectNoticeByNoticeIdx(Connection conn, Notice noticeIdx);
	
}
