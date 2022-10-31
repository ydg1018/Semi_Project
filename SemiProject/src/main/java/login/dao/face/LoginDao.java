package login.dao.face;

import java.sql.Connection;

import login.dto.Hos;
import login.dto.Owner;

public interface LoginDao {

	/**
	 * owner_id와 owner_pw를 동시에 만족하는 회원의 수를 조회함
	 * -> 로그인 인증값으로 사용함
	 * 
	 * @param conn - DB연결 객체
	 * @param owner - 조회할 회원의 정보
	 * @return int - 0 : 존재하지 않는 회원, 1 : 존재하는 회원
	 */
	public int selectCntOwnerByUseridUserpw(Connection conn, Owner owner);

	/**
	 * owner_id를 이용해 회원정보 조회하기
	 * 
	 * @param conn - DB연결 객체
	 * @param owner - 조회할 owner_id를 가진 객체
	 * @return Owner - 조회된 회원 정보
	 */
	public Owner selectOwnerByUserid(Connection conn, Owner owner);

	/**
	 * 회원정보 삽입
	 * 
	 * @param conn - DB연결 객체
	 * @param owner - 회원가입 정보 객체
	 * @return int - INSERT 수행 결과
	 */
	public int OwnerInsert(Connection conn, Owner owner);

	// 펫오너
	//--------------------------------------------------
	// 펫병원

	/**
	 * hos_id와 hos_pw를 동시에 만족하는 회원의 수를 조회함
	 * -> 로그인 인증값으로 사용함
	 * 
	 * @param conn - DB연결 객체
	 * @param hos - 조회할 회원의 정보
	 * @return int - 0 : 존재하지 않는 회원, 1 : 존재하는 회원
	 */
	public int selectCntHosByUseridUserpw(Connection conn, Hos hos);

	/**
	 * hos_id를 이용해 회원정보 조회하기
	 * 
	 * @param conn - DB연결 객체
	 * @param hos - 조회할 hos_id를 가진 객체
	 * @return Hos - 조회된 회원 정보
	 */
	public Hos selectHosByUserid(Connection conn, Hos hos);

	/**
	 * 회원정보 삽입
	 * 
	 * @param conn - DB연결 객체
	 * @param hos - 회원가입 정보 객체
	 * @return int - INSERT 수행 결과
	 */
	public int HosInsert(Connection conn, Hos hos);

	/**
	 * 오너 아이디 찾기
	 * 
	 * @param conn
	 * @param owner
	 * @return
	 */
	public Owner selectOwnerIdByOwnerNameOwnerEmail(Connection conn, Owner owner);

	/**
	 * 오너 비밀번호 찾기
	 * 
	 * @param conn
	 * @param owner
	 * @return
	 */
	public Owner selectOwnerPwByOwnerIdOwnerNameOwnerEmail(Connection conn, Owner owner);

	/**
	 * 아이디 중복체크
	 * 
	 * @param conn
	 * @param owner_id
	 * @return
	 */
	public Owner selectOne(Connection conn, String owner_id);

	/**
	 * 추가
	 * 
	 * @param conn
	 * @param owner_id
	 * @param owner_pw
	 * @return
	 */
	public Owner ownerLogin(Connection conn, String owner_id, String owner_pw);

	/**
	 * 아이디 중복
	 * 
	 * @param owner_id
	 * @return
	 */
	public int IdCheck(String owner_id);
}