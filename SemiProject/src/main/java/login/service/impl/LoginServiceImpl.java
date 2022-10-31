package login.service.impl;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import login.dao.face.LoginDao;
import login.dao.impl.LoginDaoImpl;
import login.dto.Hos;
import login.dto.Owner;
import login.service.face.LoginService;

public class LoginServiceImpl implements LoginService {

	//DAO 객체
	private LoginDao loginDao = new LoginDaoImpl();
	
	Connection conn = JDBCTemplate.getConnection();
	
	@Override
	public Owner getLoginOwner(HttpServletRequest req) {
		
		System.out.println("LoginServiceImpl() : getLoginOwner - 시작");

		Owner owner = new Owner();

		owner.setOwnerNo( Integer.parseInt( req.getParameter("owner_no") ) );
		owner.setOwnerId( req.getParameter("owner_id") );
		owner.setOwnerPw( req.getParameter("owner_pw") );
		owner.setOwnerName( req.getParameter("owner_name") );
		owner.setOwnerEmail( req.getParameter("owner_email") );
		owner.setOwnerCall( req.getParameter("owner_call") );
		owner.setOwnerNick( req.getParameter("owner_nick") );
		
		System.out.println("LoginServiceImpl() : getLoginOwner - 끝");
		return owner;
	}

	@Override
	public boolean Ownerlogin(Owner owner) {

		//로그인 인증 성공
		if( loginDao.selectCntOwnerByUseridUserpw(conn, owner) > 0 ) {
			System.out.println("LoginServiceImpl() : OwnerLogin - 로그인 성공");
			return true;
		}
		
		//로그인 인증 실패
		System.out.println("LoginServiceImpl() : OwnerLogin - 로그인 실패");
		return false;
	}

	@Override
	public Owner OwnerInfo(Owner owner) {
		System.out.println("LoginServiceImpl() : OwnerInfo - 시작");
		return loginDao.selectOwnerByUserid(conn, owner);
	}
	
	@Override
	public Owner getJoinOwner(HttpServletRequest req) {

		System.out.println("LoginServiceImpl() : getJoinOwner - 시작");

		Owner owner = new Owner();

		owner.setOwnerNo( Integer.parseInt( req.getParameter("owner_no") ) );
		owner.setOwnerId( req.getParameter("owner_id") );
		owner.setOwnerPw( req.getParameter("owner_pw") );
		owner.setOwnerName( req.getParameter("owner_name") );
		owner.setOwnerEmail( req.getParameter("owner_email") );
		owner.setOwnerCall( req.getParameter("owner_call") );
		owner.setOwnerNick( req.getParameter("owner_nick") );

		System.out.println("LoginServiceImpl() : getJoinOwner - 끝");
		return owner;
	}

	@Override
	public void OwnerJoin(Owner owner) {
		
		System.out.println("LoginDaoImpl() : OwnerJoin - 시작");

		if( loginDao.OwnerInsert(conn, owner) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		System.out.println("LoginDaoImpl() : OwnerJoin - 끝");
	}
	
	// 펫오너
	//--------------------------------------------------
	// 펫병원

	@Override
	public Hos getLoginHos(HttpServletRequest req) {
		
		System.out.println("LoginServiceImpl() : getLoginHos - 시작");
		
		Hos hos = new Hos();

//		hos.setHosNo( Integer.parseInt( req.getParameter("hos_no") ) );
		hos.setHosId( req.getParameter("hos_id") );
		hos.setHosPw( req.getParameter("hos_pw") );
//		hos.setHosLic( Integer.parseInt( req.getParameter("hos_lic") ) );
//		hos.setHosName( req.getParameter("hos_pw") );
//		hos.setHosCode( Integer.parseInt( req.getParameter("hos_code") ) );
		
		System.out.println("LoginServiceImpl() : getLoginHos - 끝");
		return hos;
	}
	
	@Override
	public boolean Hoslogin(Hos hos) {
		
		//로그인 인증 성공
		if( loginDao.selectCntHosByUseridUserpw(conn, hos) > 0 ) {
			System.out.println("LoginServiceImpl() : HosLogin - 로그인 성공");
			return true;
		}
		
		//로그인 인증 실패
		System.out.println("LoginServiceImpl() : HosLogin - 로그인 실패");
		return false;
	}
	
	@Override
	public Hos HosInfo(Hos hos) {
		return loginDao.selectHosByUserid(conn, hos);
	}
	
	@Override
	public Hos getJoinHos(HttpServletRequest req) {

		System.out.println("LoginServiceImpl() : getJoinHos - 시작");

		Hos hos = new Hos();

//		hos.setHosNo( Integer.parseInt( req.getParameter("hos_no") ) );
		hos.setHosId( req.getParameter("hos_id") );
		hos.setHosPw( req.getParameter("hos_pw") );
		hos.setHosLic( Integer.parseInt( req.getParameter("hos_lic") ) );
		hos.setHosName( req.getParameter("hos_name") );
		hos.setHosCode( Integer.parseInt( req.getParameter("hos_code") ) );

		System.out.println("LoginServiceImpl() : getJoinHos - 끝");
		return hos;
	}

	@Override
	public void HosJoin(Hos hos) {

		System.out.println("LoginServiceImpl() : HosJoin - 시작");

		if( loginDao.HosInsert(conn, hos) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		System.out.println("LoginServiceImpl() : HosJoin - 끝");
	}

	//--------------------------------------------------
	
	@Override
	public Owner getFindOwnerId(HttpServletRequest req) {
		
		Owner owner = new Owner();
		
		owner.setOwnerName( req.getParameter("owenr_name") );
		owner.setOwnerNick( req.getParameter("owenr_nick") );
		
		return owner;
	}

	@Override
	public Owner findId(Owner owner) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		return loginDao.selectOwnerIdByOwnerNameOwnerEmail(conn, owner);
	}

	@Override
	public Owner getFindOwnerPw(HttpServletRequest req) {
		
		Owner owner = new Owner();
		
		owner.setOwnerId( req.getParameter("owner_id") );
		owner.setOwnerName( req.getParameter("owner_name") );
		owner.setOwnerNick( req.getParameter("owner_nick") );
		
		return owner;
	}

	@Override
	public Owner findPw(Owner owner) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		return loginDao.selectOwnerPwByOwnerIdOwnerNameOwnerEmail(conn, owner);
	}

	@Override
	public Owner selectOne(String owner_id) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		return loginDao.selectOne(conn, owner_id);
	}

	@Override
	public Owner ownerLogin(String owner_id, String owner_pw) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		Owner owner = loginDao.ownerLogin(conn, owner_id, owner_pw);
		
		return owner;
	}
}