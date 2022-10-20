package depInfo.dao.face;

import java.sql.Connection;
import java.util.List;

import depInfo.dto.TrtInfo;

public interface TrtInfoDao {
	
	/**
	 * 진료항목 정보 테이블 전체 조회
	 * 
	 * @param conn - DB 연결 객체
	 * @return List<TrtInfo> - 테이블 전체 조회 목록
	 */
	public List<TrtInfo> selectAll(Connection conn);
	
	
}
