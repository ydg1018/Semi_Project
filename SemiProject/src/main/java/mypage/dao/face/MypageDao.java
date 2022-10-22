package mypage.dao.face;

import java.sql.Connection;

import login.dto.Owner;
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
	public Reservation getReservationOnwner(Connection conn, Reservation param);
	
	/**
	 * 마이페이지 병원 예약 조회
	 * 
	 * @param conn - DB 연결 객체
	 * @return Owner - 병원 예약 조회
	 */
	public Reservation getReservationHospital(Connection conn, Reservation param);
}
