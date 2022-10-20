package login.service.impl;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import login.dao.face.LoginDao;
import login.dao.impl.LoginDaoImpl;
import login.dto.Hospital;
import login.dto.Owner;
import login.service.face.LoginService;

public class LoginServiceImpl implements LoginService {

	private LoginDao loginDao = new LoginDaoImpl();
	
	@Override
	public Hospital getLoginHospital(HttpServletRequest req) {
		
		Hospital hos = new Hospital();

		hos.setHosId( req.getParameter("hos_id") );
		hos.setHosPw( req.getParameter("hos_pw") );
		
		return hos;
	}

	@Override
	public boolean hoslogin(Hospital hos) {
		
		//로그인 인증 성공
		if( loginDao.selectCntHospitalByUseridUserpw(JDBCTemplate.getConnection(), hos) > 0 ) {
			System.out.println("로그인 성공");
			return true;
		}
		
		//로그인 인증 실패
		System.out.println("로그인 실패");
		return false;
	}

	@Override
	public Hospital hosinfo(Hospital hos) {
		return loginDao.selectHospitalByUserid(JDBCTemplate.getConnection(), hos);
	}

	@Override
	public Hospital getJoinHospital(HttpServletRequest req) {

		Hospital hos = new Hospital();

		hos.setHosId( req.getParameter("hos_id") );
		hos.setHosPw( req.getParameter("hos_pw") );
		
		return hos;
	}

	@Override
	public void hosJoin(Hospital hos) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		if( loginDao.hosinsert(conn, hos) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
	}
	
	@Override
	public Owner getLoginOwner(HttpServletRequest req) {
		
		Owner owner = new Owner();
		
		owner.setOwnerId( req.getParameter("owner_id") );
		owner.setOwnerPw( req.getParameter("owner_pw") );
		
		return owner;
	}

	@Override
	public boolean ownerlogin(Owner owner) {

		//로그인 인증 성공
		if( loginDao.selectCntOwnerByUseridUserpw(JDBCTemplate.getConnection(), owner) > 0 ) {
			System.out.println("로그인 성공");
			return true;
		}
		
		//로그인 인증 실패
		System.out.println("로그인 실패");
		return false;
	}
	
	@Override
	public Owner ownerinfo(Owner owner) {
		return loginDao.selectOwnerByUserid(JDBCTemplate.getConnection(), owner);
	}

	@Override
	public Owner getJoinOwner(HttpServletRequest req) {
		
		Owner owner = new Owner();
		
		owner.setOwnerId( req.getParameter("owner_id") );
		owner.setOwnerPw( req.getParameter("owner_pw") );
		owner.setOwnerNick( req.getParameter("owner_nick") );
		
		return owner;
	}

	@Override
	public void ownerJoin(Owner owner) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		if( loginDao.ownerinsert(conn, owner) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
	}
}