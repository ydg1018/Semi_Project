package review.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import review.dto.Review;
import util.BoardFile;
import util.Paging;

public interface ReviewService {

	/**
	 * 게시글 전체 조회
	 * @param query 
	 * @param field 
	 * @param paging 
	 * @return List<Review> - 게시글 전체 조회 목록
	 */
	List<Review> getList();

	/**
	 * 게시글 페이징 목록 조회 
	 * 
	 * @param paging - 페이징 정보 객체
	 * @return List<Review> - 게시글 전체 조회 목록
	 */
/*	List<Review> getList(Paging paging); */

	/**
	 * 게시글 페이징 목록 & 검색 결과 조회
	 * @param paging
	 * @param field
	 * @param query
	 * @return
	 */
	List<Review> getList(Paging paging, String field, String query);
	
	/**
	 * 게시글 페이징 객체 생성
	 * 
	 * @param req - 요청 정보 객체
	 * @return Paging - 페이징 계산이 완료된 객체
	 */
	Paging getPaging(HttpServletRequest req);


	/**
	 * 전달 파라미터 boardno를 Review DTO로 저장하여 반환한다
	 * @param req - 요청 정보 객체
	 * @return Review - 전달파라미터 boardno를 저장한 DTO 객체
	 */
	public Review getBoardno(HttpServletRequest req);

	/**
	 * 전달된 boardno를 이용하여 게시글을 조회한다
	 * 조회된 게시글의 조회수를 1 증가시킨다
	 * 
	 * @param boardno - 조회할 boardno를 가진 DTO객체
	 * @return Board - 조회된 게시글 정보
	 */
	Review view(Review boardno);

	public void write(HttpServletRequest req);
	
	/**
	 * 첨부파일 정보 조회하기
	 * 
	 * @param viewBoard - 첨부파일과 연결된 게시글의 번호
	 * @return BoardFile - 첨부파일 정보 DTO객체
	 */
	public BoardFile viewFile(Review viewBoard);
	
	/**
	 * 게시글 수정
	 * 
	 * @param req - 요청 정보 객체
	 */
	public void update(HttpServletRequest req);
	
	/**
	 * 게시글 삭제
	 * 
	 * @param board - 삭제할 게시글 번호 객체
	 */
	public void delete(Review board);
	
	
}
