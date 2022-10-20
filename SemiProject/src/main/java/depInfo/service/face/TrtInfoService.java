package depInfo.service.face;

import java.util.List;

import depInfo.dto.TrtInfo;

public interface TrtInfoService {
	
	/**
	 * 테이블 전체 조회
	 * 
	 * @return - 테이블 전체 조회 목록
	 */
	public List<TrtInfo> getList();

}