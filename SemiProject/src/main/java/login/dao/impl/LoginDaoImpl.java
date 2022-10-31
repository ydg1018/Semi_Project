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
		sql += "SELECT owner_id, owner_pw, owner_nick FROM owner";
		sql += " WHERE owner_id = ?";
		
		Owner oresult = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, owner.getOwnerId());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				oresult = new Owner();
				
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
		return hcnt;
	}

	@Override
	public Hos selectHosByUserid(Connection conn, Hos hos) {

		String sql = "";
		sql += "SELECT hos_id, hos_pw, hos_lic FROM hos";
		sql += " WHERE hos_id = ?";
		
		Hos hresult = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, hos.getHosId());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				hresult = new Hos();
				
				hresult.setHosId( rs.getString("hos_id") );
				hresult.setHosPw( rs.getString("hos_pw") );
				hresult.setHosName( rs.getString("hos_name") );
				hresult.setHosNo( rs.getInt("hos_lic") );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return hresult;
	}

	@Override
	public int HosInsert(Connection conn, Hos hos) {
		
		String sql = "";
		sql += "INSERT INTO hos ( hos_no, hos_id, hos_pw, hos_lic, hos_code )";
		sql += " VALUES ( hos_seq.nextval, ?, ?, ?, ? )";
		
		int hres = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, hos.getHosId());
			ps.setString(2, hos.getHosPw());
			ps.setInt(3, hos.getHosLic());
			ps.setInt(4, hos.getHosCode());
			
			hres = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		return hres;
	}
}