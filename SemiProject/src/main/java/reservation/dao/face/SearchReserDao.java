package reservation.dao.face;

import java.sql.Connection;
import java.util.List;

import hosInfo.dto.HosInfo;
import util.Paging;

public interface SearchReserDao {

	/**
	 * 총 게시글 수 조회
	 * 
	 * @param connection - DB 연결 객체
	 * @return int - 테이블의 전체 행 수
	 */
	public int selectCntAll(Connection connection);

	
	/**
	 * 게시판 테이블 페이징 목록 조회
	 * 
	 * @param conn - DB 연결 객체
	 * @param paging - vpdlwld 정보 객체
	 * @return List<Board> - 테이블 전체 조회 목록
	 */
	public List<HosInfo> selectAll(Connection connection, Paging paging);


	/**
	 * 지정된 hosName으로 병원 조회하기	
	 * 
	 * @param conn - DB 연결 객체
	 * @param hosName - 조회할 병원의 hosName을 가진 DTO 객체
	 * @return hosInfo - 조회된 병원의 상세정보 DTO 객체
	 */
	public List<HosInfo> selectHosInfoByHosName(Connection conn, HosInfo hosName);

}
