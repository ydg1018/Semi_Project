package depInfo.service.face;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import depInfo.dto.DepInfo;

public interface DepInfoService {
	
	/**
	 * 테이블 전체 조회
	 * 
	 * @return - 테이블 전체 조회 목록
	 */
	public List<DepInfo> getList();
	
	/**
	 * 전달파라미터 det_item을 DepInfo DTO로 저장하여 반환한다
	 * 
	 * @param req - 요청 정보 객체
	 * @return DepInfo - 전달파라미터 det_item을 저장한 DTO객체
	 */
	public DepInfo getDet_item(HttpServletRequest req);
	
	/**
	 * 전달된 det_item을 이용하여 세부과 정보를 조회한다
	 * 
	 * @param DepInfo - 조회할 det_item을 가진 DTO객체
	 * @return DepInfo - 조회된 세부과 정보
	 */
	public DepInfo view(DepInfo det_item);
	
	/**
	 * 전달된 dep_detail을 이용하여 관련 진료과를 검색한다
	 * 
	 * @param dep_detail - 검색어
	 * @return ArrayList<DepInfo> - 검색어가 포함된 진료과 정보 목록
	 */
	public ArrayList<DepInfo> searchDepInfo(String det_detail);
}