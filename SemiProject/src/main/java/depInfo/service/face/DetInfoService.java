package depInfo.service.face;

import java.util.List;

import depInfo.dto.DetInfo;

public interface DetInfoService {
	
	/**
	 * 테이블 전체 조회
	 * 
	 * @return - 테이블 전체 조회 목록
	 */
	public List<DetInfo> getList();

}