package depInfo.dao.face;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import depInfo.dto.DepInfo;

public interface DepInfoDao {
	
	/**
	 * 진료과 정보 테이블 전체 조회
	 * 
	 * @param conn - DB 연결 객체
	 * @return List<DepInfo> - 테이블 전체 조회 목록
	 */
	public List<DepInfo> selectAll(Connection conn);
	
	/**
	 * 지정된 det_item의 세부과 정보 조회하기
	 * 
	 * @param conn - DB 연결 객체
	 * @param det_item - 조회할 세부과 정보의 det_item을 가진 DTO객체
	 * @return DepInfo - 조회된 세부과의 상세정보 DTO객체
	 */
	public DepInfo selectDetByDetitem(Connection conn, DepInfo det_item);
	
	/**
	 * 
	 * @param dep_detail
	 * @return
	 */
	public ArrayList<DepInfo> searchDepInfo(String dep_detail);
	
}
