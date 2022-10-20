package review.dao.face;

import java.sql.Connection;
import java.util.List;

import review.dto.Review;
import util.Paging;

public interface ReviewDao {

	/**
	 * 게시글 테이블 전체 조회
	 * 
	 * @param conn - DB 연결 객체
	 * @return List<Review> - 테이블 전체 조회 목록
	 */
	List<Review> selectAll(Connection conn);

	/**
	 * 게시글 테이블 페이징 목록 조회
	 * @param conn - DB연결 객체
	 * @param paging - 페이징 정보 객체
	 * @return List<Review> - 테이블 페이징 목록 조회 결과
	 */
	List<Review> selectAll(Connection conne, Paging paging);

	/**
	 * 총 게시글 수 조회
	 * @param conn - DB 연결 객체
	 * @return - 테이블의 전체 행 수
	 */
	int selectCntAll(Connection conn);

	/**
	 * 조회된 게시글의 조회수 증가시키기
	 * @param conn - DB 연결 객체
	 * @param boardno - 조회할 게시글의 boardno를 가진 DTO객체
	 * @return int - UPDATE쿼리 수행 결과
	 */
	int updateHit(Connection conn, Review boardno);

	/**
	 * 지정된 boardno의 게시글 조회하기
	 * @param conn - DB 연결 객체
	 * @param boardno - 조회할 게시글의 boardno를 가진 DTO객체
	 * @return Review - 조회된 게시글의 상세정보 DTO객체
	 */
	Review selectBoardByBoardno(Connection conn, Review boardno);


	/** 게시글 삽입하기
	 * 
	 * @param conn - DB 연결 객체
	 * @param review - 작성된 게시글 DTO 객체
	 * @return
	 */
	public int insert(Connection conn, Review review);

	/**
	 * 
	 * @param conn - DB 연결 객체
	 * @param review - 수정된 게시글 DTO 객체
	 * @return
	 */
	public int update(Connection conn, Review review);

}
