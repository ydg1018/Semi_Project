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
	 * @return Hos - 로그인 정보(hos_id, hos_pw)
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
	 * @return Hos - 조회된 회원 정보(hos_id, hos_pw, hos_lic)
	 */
	public Hos HosInfo(Hos hos);
	/**
	 * 회원가입 정보 추출하기
	 * 
	 * @param req - 요청 정보 객체
	 * @return Hos - 회원가입 정보 객체 (hos_id, hos_pw, hos_lic)
	 */
	public Hos getJoinHos(HttpServletRequest req);

	/**
	 * 회원가입 처리
	 * 
	 * @param hos - 회원가입 정보 객체
	 */
	public void HosJoin(Hos hos);

	/**
	 * 오너 아이디 찾기
	 * 
	 * @param req
	 * @return
	 */
	public Owner getFindOwnerId(HttpServletRequest req);

	/**
	 * 오너 아이디 찾기
	 * 
	 * @param owner
	 * @return
	 */
	public Owner findId(Owner owner);

	/**
	 * 오너 비밀번호 찾기
	 * 
	 * @param req
	 * @return
	 */
	public Owner getFindOwnerPw(HttpServletRequest req);

	/**
	 * 오너 비밀번호 찾기
	 * 
	 * @param owner
	 * @return
	 */
	public Owner findPw(Owner owner);

	/**
	 * 아이디 중복 체크
	 * 
	 * @param owner_id
	 * @return
	 */
	public Owner selectOne(String owner_id);

	/**
	 * 추가
	 * 
	 * @param owner_id
	 * @param owner_pw
	 * @return
	 */
	public Owner ownerLogin(String owner_id, String owner_pw);
}