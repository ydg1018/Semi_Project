package mypage.service.face;

import login.dto.Hos;
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
	
	public Hos getHospital(Hos param);

	
	/**
	 * 마이페이지 병원회원 수정
	 * 
	 * @return Owner - 회원 수정
	 */
	
	public int updateHospital(Hos param);
	
	
	/**
	 * 마이페이지 병원회원 삭제
	 * 
	 * @return Owner - 회원 삭제
	 */
	
	public int deleteHospital(Hos param);
}
