package login.dao.face;

import java.sql.Connection;

import login.dto.Hospital;
import login.dto.Owner;

public interface LoginDao {
	/**
	 * hos_id와 hos_pw를 동시에 만족하는 회원의 수를 조회함
	 * -> 로그인 인증값으로 사용함
	 * 
	 * @param conn - DB연결 객체
	 * @param member - 조회할 회원의 정보
	 * @return int - 0 : 존재하지 않는 회원, 1 : 존재하는 회원
	 */
	public int selectCntHospitalByUseridUserpw(Connection connection, Hospital hos);

	/**
	 * hos_id를 이용해 회원정보 조회하기
	 * 
	 * @param conn - DB연결 객체
	 * @param member - 조회할 hos_id를 가진 객체
	 * @return Member - 조회된 회원 정보
	 */
	public Hospital selectHospitalByUserid(Connection connection, Hospital hos);

	/**
	 * 회원정보 삽입
	 * 
	 * @param conn - DB연결 객체
	 * @param member - 회원가입 정보 객체
	 * @return int - INSERT 수행 결과
	 */
	public int hosinsert(Connection conn, Hospital hos);

	/**
	 * owner_id와 owner_pw를 동시에 만족하는 회원의 수를 조회함
	 * -> 로그인 인증값으로 사용함
	 * 
	 * @param conn - DB연결 객체
	 * @param member - 조회할 회원의 정보
	 * @return int - 0 : 존재하지 않는 회원, 1 : 존재하는 회원
	 */
	public int selectCntOwnerByUseridUserpw(Connection connection, Owner owner);

	/**
	 * owner_id를 이용해 회원정보 조회하기
	 * 
	 * @param conn - DB연결 객체
	 * @param member - 조회할 owner_id를 가진 객체
	 * @return Member - 조회된 회원 정보
	 */
	public Owner selectOwnerByUserid(Connection connection, Owner owner);

	/**
	 * 회원정보 삽입
	 * 
	 * @param conn - DB연결 객체
	 * @param member - 회원가입 정보 객체
	 * @return int - INSERT 수행 결과
	 */
	public int ownerinsert(Connection conn, Owner owner);
}