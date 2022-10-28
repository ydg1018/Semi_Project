package review.dao.face;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import review.dto.Review;
import util.BoardFile;
import util.Paging;

public interface ReviewDao {

	/**
	 * 게시글 테이블 전체 조회
	 * 
	 * @param conn - DB 연결 객체
	 * @param query 
	 * @param field 
	 * @param paging 
	 * @return List<Review> - 테이블 전체 조회 목록
	 */
	List<Review> selectAll(Connection conn);

	/**
	 * 게시글 테이블 페이징 목록 조회
	 * @param conn - DB연결 객체
	 * @param paging - 페이징 정보 객체
	 * @return List<Review> - 테이블 페이징 목록 조회 결과
	 */
//	List<Review> selectAll(Connection conn, Paging paging);

	
	/** 
	 * 게시글 페이징 목록 및 검색결과 조회
	 * @param conn - DB연결 객체
	 * @param paging - 페이징 정보 객체
	 * @param field - 검색 필드
	 * @param query - 검색 내용
	 * @return List<Review> - 게시글 검색결과 목록
	 */
	List<Review> selectAll(Connection conn, Paging paging, String field, String query);
	
	/**
	 * 총 게시글 수 조회
	 * @param conn - DB 연결 객체
	 * @return - 테이블의 전체 행 수
	 */
	int selectCntAll(Connection conn);
	int selectCntAll(Connection conn, String field, String query);

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


	/**
	 * 게시글 입력
	 * 
	 * @param conn - DB 연결 객체
	 * @param board - 삽입될 게시글 내용
	 * @return int - INSERT 쿼리 수행 결과
	 */
	public int insert(Connection conn, Review review);

	/**
	 * 시퀀스를 이용하여 다음 게시글 번호 조회하기
	 * 
	 * @param conn - DB연결 객체
	 * @return int - 다음 게시글 번호
	 */
	public int selectNextBoardno(Connection conn);

	/**
	 * 첨부파일 삽입
	 * 
	 * @param conn - DB연결 객체
	 * @param boardFile - 첨부파일 정보
	 * @return int - INSERT 수행 결과
	 */
	public int insertFile(Connection conn, BoardFile boardFile);

	/**
	 * 첨부파일 정보 조회
	 * 
	 * @param conn - DB연결 객체
	 * @param viewBoard - 조회할 게시글 번호
	 * @return BoardFile - 첨부파일 정보
	 */
	public BoardFile selectFile(Connection conn, Review viewBoard);
	
	/**
	 * 게시글 수정
	 * 
	 * @param conn - DB연결 객체
	 * @param review - 수정할 내용을 담은 객체
	 * @return UPDATE 수행 결과
	 */
	public int update(Connection conn, Review review);
	
	/**
	 * 게시글에 첨부된 파일 정보 삭제
	 * 
	 * @param conn - DB연결 객체
	 * @param review - 삭제할 게시글 번호
	 * @return UPDATE 수행 결과
	 */
	public int deleteFile(Connection conn, Review review);
	
	/**
	 * 게시글 삭제
	 * 
	 * @param conn - DB연결 객체
	 * @param review - 삭제할 게시글 번호
	 * @return UPDATE 수행 결과
	 */
	public int delete(Connection conn, Review review);


}

