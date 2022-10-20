package login.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;
import login.dto.Hospital;
import login.dto.Owner;
import login.dao.face.LoginDao;

public class LoginDaoImpl implements LoginDao {
	private PreparedStatement ps;
	private ResultSet rs;
	
	@Override
	public int selectCntHospitalByUseridUserpw(Connection conn, Hospital hos) {
		
		String sql = "";
		sql += "SELECT count(*) cnt FROM hospital";
		sql += " WHERE hos_id = ?";
		sql += "	AND hos_pw = ?";
		
		int cnt = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, hos.getHosId());
			ps.setString(2, hos.getHosPw());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				cnt = rs.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return cnt;
	}

	@Override
	public Hospital selectHospitalByUserid(Connection conn, Hospital hos) {

		String sql = "";
		sql += "SELECT hos_no, hos_id, hos_pw, hos_lic, hos_code FROM hospital";
		sql += " WHERE hos_id = ?";
		
		Hospital hosres = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, hos.getHosId());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				hosres = new Hospital();
				
				hosres.setHosId( rs.getString("hos_id") );
				hosres.setHosPw( rs.getString("hos_pw") );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return hosres;
	}
	
	@Override
	public int hosinsert(Connection conn, Hospital hos) {
		
		String sql = "";
		sql += "INSERT INTO hospital ( hos_no, hos_id, hos_pw, hos_lic, hos_code )";
		sql += " VALUES ( hos_seq.nextval, ?, ?, ?, ? )";
		
		int hosresult = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, hos.getHosNo());
			ps.setString(2, hos.getHosId());
			ps.setString(3, hos.getHosPw());
			ps.setInt(4, hos.getHosLic());
			ps.setInt(5, hos.getHosCode());
			
			hosresult = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		return hosresult;
	}

	@Override
	public int selectCntOwnerByUseridUserpw(Connection conn, Owner owner) {
		
		String sql = "";
		sql += "SELECT count(*) cnt FROM owner";
		sql += " WHERE ownerid = ?";
		sql += "	AND ownerpw = ?";
		
		int cnt = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, owner.getOwnerId());
			ps.setString(2, owner.getOwnerPw());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				cnt = rs.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return cnt;
	}
	
	@Override
	public Owner selectOwnerByUserid(Connection conn, Owner owner) {

		String sql = "";
		sql += "SELECT owner_no, owner_id, owner_pw, owner_name, owner_email, owner_call, owner_nick FROM owner";
		sql += " WHERE ownerid = ?";
		
		Owner ownerres = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, owner.getOwnerId());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				ownerres = new Owner();
				
				ownerres.setOwnerId( rs.getString("owner_id") );
				ownerres.setOwnerPw( rs.getString("owner_pw") );
				ownerres.setOwnerNick( rs.getString("onwer_nick") );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return ownerres;
	}
	
	@Override
	public int ownerinsert(Connection conn, Owner owner) {
		
		String sql = "";
		sql += "INSERT INTO owner ( owner_no, owner_id, owner_pw, owner_name, owner_email, owner_call, owner_nick )";
		sql += " VALUES ( owner_seq.nextval, ?, ?, ?, ?, ?, ? )";
		
		int ownerresult = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, owner.getOwnerNo());
			ps.setString(2, owner.getOwnerId());
			ps.setString(3, owner.getOwnerPw());
			ps.setString(4, owner.getOwnerName());
			ps.setString(5, owner.getOwnerEmail());
			ps.setInt(6, owner.getOwnerCall());
			ps.setString(7, owner.getOwnerNick());
			
			ownerresult = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		return ownerresult;
	}
}