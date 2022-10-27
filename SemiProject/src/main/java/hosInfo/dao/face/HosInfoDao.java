package hosInfo.dao.face;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import hosInfo.dto.HosInfo;
import util.Paging;

public interface HosInfoDao {

	/**
	 * 병원 정보 테이블 전체 조회
	 * 
	 * @param connection - DB 연결 객체
	 * @return List<HosInfo> - 테이블 전체 조회 목록
	 */
	public List<HosInfo> selectAll(Connection conn);
	
	/**
	 * 병원 정보 테이블 페이징 목록 조회
	 * 
	 * @param conn - DB 연결 객체
	 * @param paging - 페이징 정보 객체
	 * @return List<Board> - 테이블 페이징 목록 조회 결과
	 */
	public List<HosInfo> selectAll(Connection conn, Paging paging);
	
	/**
	 * 총 게시글 수 조회
	 * 
	 * @param conn - DB 연결 객체
	 * @return int - 테이블의 전체 행 수
	 */
	public int selectCntAll(Connection conn);
	
	/**
	 * 지정된 hos_name의 병원 정보 조회하기
	 * 
	 * @param conn - DB 연결 객체
	 * @param hos_name - 조회할 병원 정보의 hos_name을 가진 DTO객체
	 * @return HosInfo - 조회된 병원의 상세정보 DTO객체
	 */
	public HosInfo selectHosByHosname(Connection conn, HosInfo hos_name);
	
	/**
	 * 병원명으로 병원 조회하기
	 * 
	 * @param hos_name
	 * @return
	 */
	public ArrayList<HosInfo> searchHosInfo(String option, String keword);
	
	//public ArrayList<HosInfo> searchHosInfo(String hos_add);
	
}
