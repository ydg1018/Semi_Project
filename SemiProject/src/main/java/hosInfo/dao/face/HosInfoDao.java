package hosInfo.dao.face;

import java.sql.Connection;
import java.util.List;

import hosInfo.dto.HosInfo;

public interface HosInfoDao {

	/**
	 * 병원 정보 테이블 전체 조회
	 * 
	 * @param connection - DB 연결 객체
	 * @return List<HosInfo> - 테이블 전체 조회 목록
	 */
	public List<HosInfo> selectAll(Connection conn);

	/**
	 * 지정된 hos_name의 게시글 조회하기
	 * 
	 * @param conn - DB 연결 객체
	 * @param hos_name - 조회할 게시글의 hos_name을 가진 DTO객체
	 * @return HosInfo - 조회된 병원의 상세정보 DTO객체
	 */
	public HosInfo selectHosByHosname(Connection conn, HosInfo hos_name);
	
}
