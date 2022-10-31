package mypage.dao.face;

import java.sql.Connection;

import hosInfo.dto.HosInfo;
import login.dto.Hos;
import login.dto.Owner;
import reservation.dto.Pet;
import reservation.dto.Reservation;

public interface MypageDao {
	
	/**
	 * 마이페이지 회원 조회
	 * 
	 * @param conn - DB 연결 객체
	 * @return Owner - 회원 단건 조회
	 */
	public Owner getOwner(Connection conn, Owner param);
	
	/**
	 * 마이페이지 회원 수정
	 * 
	 * @param conn - DB 연결 객체
	 * @return Owner - 회원 단건 수정
	 */
	public int updateOwner(Connection conn, Owner param);
	
	/**
	 * 마이페이지 회원 삭제
	 * 
	 * @param conn - DB 연결 객체
	 * @return Owner - 회원 단건 삭제
	 */
	public int deleteOwner(Connection conn, Owner param);
	
	/**
	 * 마이페이지 회원 예약 조회
	 * 
	 * @param conn - DB 연결 객체
	 * @return Owner - 회원 예약 조회
	 */
	public Reservation getOwnerReservation(Connection conn, Reservation param);
	
	/**
	 * 마이페이지 병원 예약 조회
	 * 
	 * @param conn - DB 연결 객체
	 * @return Owner - 병원 예약 조회
	 */
	public Reservation getHosReservation(Connection conn, Reservation param);
	
	/**
	 * 마이페이지 병원회원 조회
	 * 
	 * @param conn - DB 연결 객체
	 * @return Owner - 회원 단건 조회
	 */
	public Hos getHospital(Connection conn, Hos param);
	
	/**
	 * 마이페이지 병원회원 수정
	 * 
	 * @param conn - DB 연결 객체
	 * @return Owner - 회원 단건 수정
	 */
	public int updateHospital(Connection conn, Hos param);
	
	/**
	 * 마이페이지 병원회원 삭제
	 * 
	 * @param conn - DB 연결 객체
	 * @return Owner - 회원 단건 삭제
	 */
	public int deleteHospital(Connection conn, Hos param);
	
	
	
	
	
	/**
	 * 마이페이지 병원회원-정보 조회
	 * 
	 * @param conn - DB 연결 객체
	 * @return Owner - 회원 단건 조회
	 */
	public HosInfo getHosInfo(Connection conn, HosInfo param);
	
	/**
	 * 마이페이지 병원회원 수정
	 * 
	 * @param conn - DB 연결 객체
	 * @return Owner - 회원 단건 수정
	 */
	public int updateHosInfo(Connection conn, HosInfo param);
	
	/**
	 * 마이페이지 병원회원 삭제
	 * 
	 * @param conn - DB 연결 객체
	 * @return Owner - 회원 단건 삭제
	 */
	public int deleteHosInfo(Connection conn, HosInfo param);
	
	/**
	 * 마이페이지 펫 조회
	 * 
	 * @param conn - DB 연결 객체
	 * @return Pet - 펫 단건 조회
	 */
	public Pet getPet(Connection conn, Pet param);
}
