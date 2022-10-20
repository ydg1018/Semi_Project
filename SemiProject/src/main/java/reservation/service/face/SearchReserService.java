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

	
}
