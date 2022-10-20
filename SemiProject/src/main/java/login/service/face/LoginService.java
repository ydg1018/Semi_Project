package login.service.face;

import javax.servlet.http.HttpServletRequest;

import login.dto.Hospital;
import login.dto.Owner;

public interface LoginService {

	/**
	 * 펫병원 로그인 정보 추출하기
	 * 
	 * @param req - 요청 정보 객체
	 * @return Member - 로그인 정보(hos_id, hos_pw)
	 */
	public Hospital getLoginHospital(HttpServletRequest req);

	/**
	 * 펫병원 로그인 인증 처리
	 * 
	 * @param member - 로그인 정보 (hos_id, hos_pw)
	 * @return boolean - true : 인증성공, false : 인증실패
	 */
	public boolean hoslogin(Hospital hos);

	/**
	 * 펫병원 정보 가져오기
	 * 
	 * @param member - 조회할 병원 아이디를 가진 객체
	 * @return Member - 조회된 병원 정보(hos_id, hos_pw, hos_pw)
	 */	
	public Hospital hosinfo(Hospital hos);

	/**
	 * 병원 회원가입 정보 추출하기
	 * 
	 * @param req - 요청 정보 객체
	 * @return Member - 병원 회원가입 정보 객체 (hos_id, hos_pw, hos_name)
	 */	
	public Hospital getJoinHospital(HttpServletRequest req);

	/**
	 * 펫병원 회원가입 처리
	 * 
	 * @param member - 펫병원 회원가입 정보 객체
	 */
	public void hosJoin(Hospital hos);

	//--------------------

	/**
	 * 로그인 정보 추출하기
	 * 
	 * @param req - 요청 정보 객체
	 * @return Member - 로그인 정보(owner_id, owner_pw)
	 */
	public Owner getLoginOwner(HttpServletRequest req);

	/**
	 * 펫오너 로그인 인증 처리
	 * 
	 * @param member - 펫오너 로그인 정보 (owner_id, owner_pw)
	 * @return boolean - true : 인증성공, false : 인증실패
	 */
	public boolean ownerlogin(Owner owner);

	/**
	 * 펫오너 유저 정보 가져오기
	 * 
	 * @param member - 조회할 오너 회원 아이디를 가진 객체
	 * @return Member - 조회된 오너 회원 정보(owner_id, owner_pw, onwer_nick)
	 */	
	public Owner ownerinfo(Owner owner);
	
	/**
	 * 펫오너 로그인 정보 추출하기
	 * 
	 * @param req - 요청 정보 객체
	 * @return Member - 펫오너 로그인 정보(owner_id, owner_pw)
	 */
	public Owner getJoinOwner(HttpServletRequest req);
	
	/**
	 * 펫오너 회원가입 처리
	 * 
	 * @param member - 펫오너 회원가입 정보 객체
	 */
	public void ownerJoin(Owner owner);
}