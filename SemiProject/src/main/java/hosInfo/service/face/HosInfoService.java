package hosInfo.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import hosInfo.dto.HosInfo;

public interface HosInfoService {

	/**
	 * 테이블 전체 조회
	 * 
	 * @return - 테이블 전체 조회 목록
	 */
	List<HosInfo> getList();

	/**
	 * 전달파라미터 Hos_name을 HosInfo DTO로 저장하여 반환한다
	 * 
	 * @param req - 요청 정보 객체
	 * @return HosInfo - 전달파라미터 Hos_name을 저장한 DTO객체
	 */
	public HosInfo getHos_name(HttpServletRequest req);
	
	/**
	 * 전달된 Hos_name을 이용하여 병원 정보를 조회한다
	 * 
	 * @param Hos_name - 조회할 Hos_name을 가진 DTO객체
	 * @return HosInfo - 조회된 게시글 정보
	 */
	public HosInfo view(HosInfo hos_name);
}
