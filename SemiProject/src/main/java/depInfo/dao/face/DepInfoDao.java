package depInfo.dao.face;

import java.sql.Connection;
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
	
	
}
