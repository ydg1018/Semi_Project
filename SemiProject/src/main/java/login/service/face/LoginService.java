package login.service.face;

import javax.servlet.http.HttpServletRequest;

import login.dto.Hos;
import login.dto.Owner;

public interface LoginService {

	/**
	 * 로그인 정보 추출하기
	 * 
	 * @param req - 요청 정보 객체
	 * @return Owner - 로그인 정보(owner_id, owner_pw)
	 */
	public Owner getLoginOwner(HttpServletRequest req);

	/**
	 * 로그인 인증 처리
	 * 
	 * @param owner - 로그인 정보 (owenr_id, owner_pw)
	 * @return boolean - true : 인증성공, false : 인증실패
	 */
	public boolean OwnerLogin(Owner owner);

	/**
	 * 유저 정보 가져오기
	 * 
	 * @param owner - 조회할 회원 아이디를 가진 객체
	 * @return Owner - 조회된 회원 정보(owner_id, owner_pw, owner_nick)
	 */
	public Owner OwnerInfo(Owner owner);

	/**
	 * 회원가입 정보 추출하기
	 * 
	 * @param req - 요청 정보 객체
	 * @return Owner - 회원가입 정보 객체 (owner_id, owner_pw, owner_nick)
	 */
	public Owner getJoinOwner(HttpServletRequest req);

	/**
	 * 회원가입 처리
	 * 
	 * @param owner - 회원가입 정보 객체
	 */
	public void OwnerJoin(Owner owner);
	
	// 펫오너
	//--------------------------------------------------
	// 펫병원
	
	/**
	 * 로그인 정보 추출하기
	 * 
	 * @param req - 요청 정보 객체
	 * @return Hospital - 로그인 정보(hos_id, hos_pw)
	 */
	public Hos getLoginHos(HttpServletRequest req);
	
	/**
	 * 로그인 인증 처리
	 * 
	 * @param hos - 로그인 정보 (hos_id, hos_pw)
	 * @return boolean - true : 인증성공, false : 인증실패
	 */
	public boolean Hoslogin(Hos hos);
	
	/**
	 * 유저 정보 가져오기
	 * 
	 * @param hos - 조회할 회원 아이디를 가진 객체
	 * @return Hospital - 조회된 회원 정보(hos_id, hos_pw, hos_lic)
	 */
	public Hos HosInfo(Hos hos);
	/**
	 * 회원가입 정보 추출하기
	 * 
	 * @param req - 요청 정보 객체
	 * @return Hospital - 회원가입 정보 객체 (hos_id, hos_pw, hos_lic)
	 */
	public Hos getJoinHos(HttpServletRequest req);

	/**
	 * 회원가입 처리
	 * 
	 * @param hos - 회원가입 정보 객체
	 */
	public void HosJoin(Hos hos);
}