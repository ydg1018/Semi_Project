package reservation.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import hosInfo.dto.HosInfo;
import util.Paging;

public interface SearchReserService {

	/**
	 * 게시글 페이징 객체 생성
	 * 
	 * @param req - 요청 정보 객체
	 * @return Paging - 페이징 계산이 완료된 객체
	 */
	public Paging getPaging(HttpServletRequest req);

	/**
	 * 게시글 페이징 목록 조회
	 * 
	 * @param paging - 페이징 정보 객체
	 * @return List<Board> - 게시글 전체 조회 목록
	 */
	public List<HosInfo> getList(Paging paging);

	/**
	 * 전달파라미터 hosname를 HosInfo DTO로 저장하여 반환한다
	 * 
	 * @param req - 요청 정보 객체
	 * @return HosInfo - 전달파라미터 hosname을 저장한 DTO 객체
	 */
	public HosInfo getHosName(HttpServletRequest req);

	/**
	 * 전달된 hosName을 이용하여 게시글을 조회한다
	 * 
	 * @param hosName - 조회할 hosName을 가진 DTO 객체
	 * @return HosInfo
	 */
	public HosInfo detail(HosInfo hosName);

	
}
