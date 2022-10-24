package reservation.service.face;

import javax.servlet.http.HttpServletRequest;

import hosInfo.dto.HosInfo;
import reservation.dto.Pet;

public interface ReservationService {

	public HosInfo getHosCode(HttpServletRequest req);

	/**
	 * hosCode를 이용하여 병원 정보 가져오기
	 * 
	 * @param req - 요청 정보 객체
	 * @param info - 조회할 병원 코드
	 * @return hosInfo
	 */
	public HosInfo getInfo(HttpServletRequest req, HosInfo info);

	/**
	 * pet 파라미터 가져오기
	 * 
	 * @param req  - 요청 정보 객체
	 * @return petparam
	 */
	public Pet petparam(HttpServletRequest req);

	/**
	 * 펫 정보 DB 삽입하기
	 * 
	 * @param petparam - 펫 DTO
	 * @return
	 */
	public Pet insertPet(Pet pet);


}
