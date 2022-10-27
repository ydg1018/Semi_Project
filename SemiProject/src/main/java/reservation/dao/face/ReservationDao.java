package reservation.dao.face;

import java.sql.Connection;

import hosInfo.dto.HosInfo;
import login.dto.Owner;
import reservation.dto.Payment;
import reservation.dto.Pet;
import reservation.dto.Reservation;

public interface ReservationDao {

	/**
	 * 지정된 hosCode를 이용하여 병원 조회하기
	 * 
	 * @param conn - DB 연결 객체
	 * @param hosCode - 조회할 병원의 HosCode
	 * @return HosInfo
	 */
	public HosInfo selectHosByHosCode(Connection conn, HosInfo hosCode);

	/**
	 * pet_seq의 nextval 조회
	 * 
	 * @param conn - DB연결객체
	 * @return
	 */
	public int selectNextPetNo(Connection conn);

	/**
	 * 전달된 파라미터 값을 테이블에 삽입한다
	 * 
	 * @param conn - DB 연결 객체
	 * @param pet - 테이블에 삽입할 정보 객체
	 * @return insert 수행결과 ( 0- 삽입 실패, 1-삽입성공 )
	 */
	public int insert(Connection conn, Pet pet);

	public Owner selectOnwerByOnwerid(Connection conn, Owner ownerID);

	/**
	 * reservation_seq의 nextval 조회
	 * 
	 * @param conn
	 * @return
	 */
	public int selectNextresNo(Connection conn);

	/**
	 * 
	 * 
	 * @param conn
	 * @param owner
	 * @param pet
	 * @param hosInfo
	 * @return
	 */
	public int insertreser(Connection conn, Reservation reser, Owner owner, Pet pet, HosInfo hosInfo);

	/**
	 * DB삽입
	 * 
	 * @param conn
	 * @param pay
	 * @param reserResult
	 * @param owner
	 * @param hosInfo
	 * @return
	 */
	public int insertpay(Connection conn, Payment pay, Reservation reserResult, Owner owner, HosInfo hosInfo);

}
