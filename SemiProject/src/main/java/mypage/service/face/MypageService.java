package mypage.service.face;

import hosInfo.dto.HosInfo;
import login.dto.Hos;
import login.dto.Owner;
import reservation.dto.Pet;
import reservation.dto.Reservation;

public interface MypageService {
	
	/**
	 * 마이페이지 회원 조회
	 * 
	 * @return Owner - 회원 단건 조회
	 */
	
	public Owner getOwner(Owner param);

	
	/**
	 * 마이페이지 회원 수정
	 * 
	 * @return Owner - 회원 수정
	 */
	
	public int updateOwner(Owner param);
	
	
	/**
	 * 마이페이지 회원 삭제
	 * 
	 * @return Owner - 회원 삭제
	 */
	
	public int deleteOwner(Owner param);
	
	
	/**
	 * 마이페이지 회원 예약 조회
	 * 
	 * @return Owner - 회원 예약 조회
	 */
	
	public Reservation getOwnerReservation(Reservation param);
	
	
	/**
	 * 마이페이지 병원 예약 조회
	 * 
	 * @return Owner - 병원 예약 조회
	 */
	
	public Reservation getHosReservation(Reservation param);
	
	
	
	
	/**
	 * 마이페이지 병원회원 조회
	 * 
	 * @return Owner - 회원 단건 조회
	 */
	
	public Hos getHos(Hos param);

	
	/**
	 * 마이페이지 병원회원 수정
	 * 
	 * @return Owner - 회원 수정
	 */
	
	public int updateHos(Hos param);
	
	
	/**
	 * 마이페이지 병원회원 삭제
	 * 
	 * @return Owner - 회원 삭제
	 */
	
	public int deleteHos(Hos param);
	
	
	
	
	/**
	 * 마이페이지 병원회원-정보 조회
	 * 
	 * @return Owner - 회원 단건 조회
	 */
	
	public HosInfo getHosInfo(HosInfo param);

	
	/**
	 * 마이페이지 병원회원 수정
	 * 
	 * @return Owner - 회원 수정
	 */
	
	public int updateHosInfo(HosInfo param);
	
	
	/**
	 * 마이페이지 병원회원 삭제
	 * 
	 * @return Owner - 회원 삭제
	 */
	
	public int deleteHosInfo(HosInfo param);
	
	/**
	 * 마이페이지 펫 조회
	 * 
	 * @return Pet - 펫 단건 조회
	 */
	
	public Pet getPet(Pet param);
}
