package login.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;
import login.dao.face.LoginDao;
import login.dto.Hos;
import login.dto.Owner;

public class LoginDaoImpl implements LoginDao {

	private PreparedStatement ps;
	private ResultSet rs;

	@Override
	public int selectCntOwnerByUseridUserpw(Connection conn, Owner owner) {
		
		System.out.println("LoginDaoImpl() : selectCntOwnerByUseridUserpw - 시작");
		
		String sql = "";
		sql += "SELECT count(*) cnt FROM owner";
		sql += " WHERE owner_id = ? AND owner_pw = ?";
		
		int ocnt = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, owner.getOwnerId());
			ps.setString(2, owner.getOwnerPw());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				ocnt = rs.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		System.out.println( ocnt );
		
		System.out.println("LoginDaoImpl() : selectCntOwnerByUseridUserpw - 끝");
		return ocnt;
	}
	
	@Override
	public Owner selectOwnerByUserid(Connection conn, Owner owner) {

		System.out.println("LoginDaoImpl() : selectOwnerByUserid - 시작");
		
		String sql = "";
		sql += "SELECT owner_no, owner_id, owner_pw, owner_nick FROM owner";
		sql += " WHERE owner_id = ?";
		
		Owner oresult = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, owner.getOwnerNo());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				oresult = new Owner();
				
				oresult.setOwnerNo( rs.getInt("owner_no") );
				oresult.setOwnerId( rs.getString("owner_id") );
				oresult.setOwnerPw( rs.getString("owner_pw") );
				oresult.setOwnerNick( rs.getString("owner_nick") );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		System.out.println("LoginDaoImpl() : selectOwnerByUserid - 끝");
		return oresult;
	}
	
	@Override
	public int OwnerInsert(Connection conn, Owner owner) {
		
		System.out.println("LoginDaoImpl() : OwnerInsert - 시작");

		String sql = "";
		sql += "INSERT INTO owner ( owner_no, owner_id, owner_pw, owner_name, owner_email, owner_call, owner_nick )";
		sql += " VALUES ( owner_seq.nextval, ?, ?, ?, ?, ?, ? )";
		
		int ores = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, owner.getOwnerId());
			ps.setString(2, owner.getOwnerPw());
			ps.setString(3, owner.getOwnerName());
			ps.setString(4, owner.getOwnerEmail());
			ps.setString(5, owner.getOwnerCall());
			ps.setString(6, owner.getOwnerNick());
			
			ores = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		System.out.println("LoginDaoImpl() : OwnerInsert - 끝");
		return ores;
	}

	// 펫오너
	//--------------------------------------------------
	// 펫병원
	
	@Override
	public int selectCntHosByUseridUserpw(Connection conn, Hos hos) {
		
		System.out.println("LoginDaoImpl() : selectCntHosByUseridUserpw - 시작");
		
		String sql = "";
		sql += "SELECT count(*) cnt FROM hos";
		sql += " WHERE hos_id = ? AND hos_pw = ?";
		
		int hcnt = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, hos.getHosId());
			ps.setString(2, hos.getHosPw());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				hcnt = rs.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		System.out.println("LoginDaoImpl() : selectCntHosByUseridUserpw - 끝");
		return hcnt;
	}

	@Override
	public Hos selectHosByUserid(Connection conn, Hos hos) {

		System.out.println("LoginDaoImpl() : selectHosByUserid - 시작");
		
		String sql = "";
		sql += "SELECT hos_no, hos_id, hos_pw, hos_lic FROM hos";
		sql += " WHERE hos_id = ?";
		
		Hos hresult = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, hos.getHosId());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				hresult = new Hos();
				
				hresult.setHosNo( rs.getInt("hos_no") );
				hresult.setHosId( rs.getString("hos_id") );
				hresult.setHosPw( rs.getString("hos_pw") );
				hresult.setHosNo( rs.getInt("hos_lic") );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		System.out.println("LoginDaoImpl() : selectHosByUserid - 끝");
		return hresult;
	}

	@Override
	public int HosInsert(Connection conn, Hos hos) {
		
		String sql = "";
		sql += "INSERT INTO hos ( hos_no, hos_id, hos_pw, hos_lic, hos_name, hos_code )";
		sql += " VALUES ( hos_seq.nextval, ?, ?, ?, ?, ? )";
		
		int hres = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, hos.getHosId());
			ps.setString(2, hos.getHosPw());
			ps.setInt(3, hos.getHosLic());
			ps.setString(4, hos.getHosName());
			ps.setInt(5, hos.getHosCode());
			
			hres = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		return hres;
	}

	//--------------------------------------------------
	
	@Override
	public Owner selectOwnerIdByOwnerNameOwnerEmail(Connection conn, Owner owner) {
		
		String sql = "";
		sql += "SELECT owner_id FROM owner WHERE owner_name = ? AND owner_nick = ?";
		
		Owner result = null;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, owner.getOwnerName());
			ps.setString(2, owner.getOwnerNick());
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				result = new Owner();
				
				result.setOwnerId( rs.getString("owner_id") );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return result;
	}

	@Override
	public Owner selectOwnerPwByOwnerIdOwnerNameOwnerEmail(Connection conn, Owner owner) {
		
		String sql = "";
		sql += "SELECT owner_pw FROM owner WHERE owner_id = ?";
		sql += " AND owner_name = ? AND owner_nick = ?";
		
		Owner result = null;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, owner.getOwnerId());
			ps.setString(2, owner.getOwnerName());
			ps.setString(3, owner.getOwnerNick());
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				result = new Owner();
				
				result.setOwnerPw( rs.getString("owner_pw") );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return result;
	}

	@Override
	public Owner selectOne(Connection conn, String owner_id) {
		
		String sql = "";
		sql += "SELECT * FROM owner WHERE owenr_id = ?";
		
		Owner owner = null;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, owner_id);
			
			rs = ps.executeQuery();
			
			if( rs.next() ) {
				owner = new Owner();
				
				owner.setOwnerId( rs.getString("owenr_id") );
				owner.setOwnerPw( rs.getString("owenr_pw") );
				owner.setOwnerName( rs.getString("owenr_name") );
				owner.setOwnerEmail( rs.getString("owenr_email") );
				owner.setOwnerCall( rs.getString("owenr_call") );
				owner.setOwnerNick( rs.getString("owenr_nick") );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return null;
	}

	@Override
	public Owner ownerLogin(Connection conn, String owner_id, String owner_pw) {
		
		Owner owner = null;
		
		String sql = "";
		sql += "SELECT * FROM owner WHERE owner_id = ? AND owner_pw = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, owner_id);
			ps.setString(2, owner_pw);
			
			rs = ps.executeQuery();
			
			if( rs.next() ) {
				owner = new Owner();
				
				owner.setOwnerNo( rs.getInt("owner_no") );
				owner.setOwnerId( rs.getString("owner_id") );
				owner.setOwnerPw( rs.getString("owner_pw") );
				owner.setOwnerName( rs.getString("owner_name") );
				owner.setOwnerEmail( rs.getString("owner_email") );
				owner.setOwnerCall( rs.getString("owner_call") );
				owner.setOwnerNick( rs.getString("owner_nick") );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return owner;
	}

	@Override
	public int IdCheck(String owner_id) {

		Connection conn = JDBCTemplate.getConnection();
		
		String sql = "";
		sql += "SELECT * FROM owner WEHRE owner_id = ?";
		
		int idcheck = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, owner_id);
			
			rs = ps.executeQuery();
			
			if( rs.next() || owner_id.equals("") ) {
				idcheck = 0;
			} else {
				idcheck = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		return idcheck;
	}
}