package depInfo.service.face;

import java.util.List;

import depInfo.dto.DepInfo;

public interface DepInfoService {
	
	/**
	 * 테이블 전체 조회
	 * 
	 * @return - 테이블 전체 조회 목록
	 */
	public List<DepInfo> getList();

}