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
	public boolean OwnerLogin(Owner owner) {
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
		System.out.println("LoginServiceImpl() : OwnerInfo");
		return loginDao.selectOwnerByUserid(JDBCTemplate.getConnection(), owner);
	}
	
	@Override
	public Owner getJoinOwner(HttpServletRequest req) {

		System.out.println("LoginServiceImpl() : getJoinOwner - 시작");

		Owner owner = new Owner();

		owner.setOwnerId( req.getParameter("owner_id") );
		owner.setOwnerPw( req.getParameter("owner_pw") );
		owner.setOwnerName( req.getParameter("owner_name") );
		owner.setOwnerEmail( req.getParameter("owner_email") );
		owner.setOwnerCall( req.getParameter("owner_call" ) );
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

		hos.setHosId( req.getParameter("hos_id") );
		hos.setHosPw( req.getParameter("hos_pw") );
		
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
		System.out.println("LoginServiceImpl() : HosInfo");
		return loginDao.selectHosByUserid(conn, hos);
	}
	
	@Override
	public Hos getJoinHos(HttpServletRequest req) {

		System.out.println("LoginServiceImpl() : getJoinHos - 시작");
		
		Hos hos = new Hos();

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
		
		System.out.println("LoginDaoImpl() : OwnerHos - 시작");
		
		if( loginDao.HosInsert(conn, hos) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		System.out.println("LoginDaoImpl() : OwnerHos - 끝");
	}
}