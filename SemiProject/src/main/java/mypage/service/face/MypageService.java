package mypage.service.face;

import hosInfo.dto.HosInfo;
import login.dto.Hospital;
import login.dto.Owner;
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
	
	public Reservation getReservationOnwner(Reservation param);
	
	
	/**
	 * 마이페이지 병원 예약 조회
	 * 
	 * @return Owner - 병원 예약 조회
	 */
	
	public Reservation getReservationHospital(Reservation param);
	
	
	
	
	/**
	 * 마이페이지 병원회원 조회
	 * 
	 * @return Owner - 회원 단건 조회
	 */
	
	public Hospital getHospital(Hospital param);

	
	/**
	 * 마이페이지 병원회원 수정
	 * 
	 * @return Owner - 회원 수정
	 */
	
	public int updateHospital(Hospital param);
	
	
	/**
	 * 마이페이지 병원회원 삭제
	 * 
	 * @return Owner - 회원 삭제
	 */
	
	public int deleteHospital(Hospital param);
	
	
	
	
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
}
