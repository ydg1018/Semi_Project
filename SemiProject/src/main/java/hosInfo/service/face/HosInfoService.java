package hosInfo.service.face;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import hosInfo.dto.HosInfo;
import util.Paging;

public interface HosInfoService {

	/**
	 * 테이블 전체 조회
	 * 
	 * @return List<HosInfo> - 테이블 전체 조회 목록
	 */
	public List<HosInfo> getList();

	/**
	 * 게시글 페이징 목록 조회
	 * 
	 * @param paging - 페이징 정보 객체
	 * @return List<HosInfo> - 게시글 전체 조회 목록
	 */
	public List<HosInfo> getList(Paging paging);
	
	/**
	 * 게시글 페이징 객체 생성
	 * 
	 * @param req - 요청 정보 객체
	 * @return Paging - 페이징 계산이 완료된 객체
	 */
	public Paging getPaging(HttpServletRequest req);
	
	/**
	 * 전달파라미터 hos_name을 HosInfo DTO로 저장하여 반환한다
	 * 
	 * @param req - 요청 정보 객체
	 * @return HosInfo - 전달파라미터 Hos_name을 저장한 DTO객체
	 */
	public HosInfo getHos_name(HttpServletRequest req);
	
	/**
	 * 전달된 hos_name을 이용하여 병원 정보를 조회한다
	 * 
	 * @param hos_name - 조회할 hos_name을 가진 DTO객체
	 * @return HosInfo - 조회된 병원 정보
	 */
	public HosInfo view(HosInfo hos_name);

	/**
	 * 전달된 hos_name을 이용하여 관련 병원을 검색한다
	 * 
	 * @param hos_name - 검색어
	 * @return ArrayList<HosInfo> - 검색어가 포함된 병원 정보 목록
	 */
	public ArrayList<HosInfo> searchHosInfo(String hos_name);
	
}
