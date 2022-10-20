package review.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import review.dao.face.ReviewDao;
import review.dto.Review;
import util.Paging;

public class ReviewDaoImpl implements ReviewDao {

	private PreparedStatement ps; //SQL수행 객체
	private ResultSet rs; //조회 결과 객체
	
	//-----------------ReviewListController--------------------------
	
	@Override
	public List<Review> selectAll(Connection conn) {
		System.out.println("List<Review> selectAll() - 호출");
		
		//SQL 작성 
		String sql = "";
		sql += "SELECT";
		sql += " board_no, board_title, board.owner_no, owner_nick, board_content, board_hit, insert_dat";
		sql += " FROM board, owner";
		sql += " WHERE board.owner_no = owner.owner_no";
		sql += " ORDER BY board_no DESC";
		
		//조회 결과 저장할 List 객체
		List<Review> reviewList = new ArrayList<>();
		
		try {
			//SQL 수행 객체
			ps = conn.prepareStatement(sql);
			
			//SQL 수행 및 결과 저장
			rs = ps.executeQuery();
			
			//조회 결과 처리
			while( rs.next() ) {
				Review r = new Review();
				
				r.setBoardNo( rs.getInt("board_no") );
				r.setBoardTitle( rs.getString("board_title") );
				r.setBoardContent( rs.getString("board_content") );
				r.setOwnerNo(rs.getInt("owner_no"));
				r.setOwnerNick( rs.getString("owner_nick") );
				r.setBoardHit( rs.getInt("board_hit") );
				r.setInsertDat( rs.getDate("insert_dat") );
				
				//리스트에 결과값 저장
				reviewList.add(r);
				
			}
			
 		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//자원 해제
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		//최종 결과 반환
		return reviewList;
	}
	

	@Override
	public List<Review> selectAll(Connection conn, Paging paging) {
		System.out.println("List<Review> selectAll() - 시작");
		
		//SQL 작성 
		String sql = "";	
		sql += "SELECT * FROM (";
		sql += "    SELECT rownum rnum, B.* FROM (";
		sql += "	    SELECT";
		sql += "	        board_no, board_title, owner.owner_no, owner_nick, board_content, board_hit, insert_dat";
		sql += "	     FROM board, owner";
		sql += "		 WHERE board.owner_no = owner.owner_no";
		sql += "		 ORDER BY board_no DESC";
		sql += "		) B";
		sql += "	) BOARD";
		sql += "	WHERE rnum BETWEEN ? AND ?";
		
		//조회 결과 저장할 List 객체
		List<Review> reviewList = new ArrayList<>();
		
		try {
			
			ps = conn.prepareStatement(sql); //SQL수행 객체
			
			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());
			
			rs = ps.executeQuery(); //SQL수행 및 결과 집합 저장
			
			//조회 결과 처리
			while( rs.next() ) {
				Review r = new Review();
				
				r.setBoardNo( rs.getInt("board_no") );
				r.setBoardTitle( rs.getString("board_title") );
				r.setBoardContent( rs.getString("board_content") );
				r.setOwnerNo(rs.getInt("owner_no"));
				r.setOwnerNick( rs.getString("owner_nick") );
				r.setBoardHit( rs.getInt("board_hit") );
				r.setInsertDat( rs.getDate("insert_dat") );
				
				//리스트에 결과값 저장
				reviewList.add(r);
				
			}
			
 		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//자원 해제
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		//최종 결과 반환
		return reviewList;
	}
	

	@Override
	public int selectCntAll(Connection conn) {
		String sql = "";
		sql += "SELECT count(*) cnt FROM board";
		
		//총 게시글 수 변수
		int count = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				count = rs.getInt("cnt");
			}
			
 		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return count;
	}

	//-----------------ReviewViewController--------------------------

	@Override
	public int updateHit(Connection conn, Review boardno) {
		
		String sql = "";
		sql += "UPDATE board";
		sql += "	SET board_hit = board_hit + 1";
		sql += " WHERE board_no = ?";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, boardno.getBoardNo());
			
			res = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return res;
	}


	@Override
	public Review selectBoardByBoardno(Connection conn, Review boardno) {
		String sql = "";
		sql += "SELECT";
		sql += " board_no, board_title, board.owner_no, owner_nick, board_content, board_hit, insert_dat";
		sql += " FROM board, owner";
		sql += " WHERE board.owner_no = owner.owner_no";
		sql += " AND board_no = ?";
		
		Review review = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, boardno.getBoardNo());
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				review = new Review();
				
				review.setBoardNo( rs.getInt("board_no") );
				review.setBoardTitle( rs.getString("board_title") );
				review.setBoardContent( rs.getString("board_content") );
				review.setOwnerNo(rs.getInt("owner_no"));
				review.setOwnerNick( rs.getString("owner_nick") );
				review.setBoardHit( rs.getInt("board_hit") );
				review.setInsertDat( rs.getDate("insert_dat") );				
			}
			
 		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return review;
	}


	@Override
	public int insert(Connection conn, Review review) {
		
		String sql = "";
		sql += "INSERT INTO board ( board_no, board_title, board_content, owner_no, cate_no )";
		sql += "	VALUES ( board_seq.nextval, ?, ?, ?, 1 )";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, review.getBoardTitle());
			ps.setString(2, review.getBoardContent());
			ps.setInt(3, review.getOwnerNo());
			
			res = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return res;
	}


	@Override
	public int update(Connection conn, Review review) {
		
		String sql = "";
		sql += "INSERT INTO board ( board_title, board_content, owner_nick )";
		sql += "	VALUES ( ?, ?, ? )";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, review.getBoardTitle());
			ps.setString(2, review.getBoardContent());
			ps.setString(3, review.getOwnerNick());
			
			res = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return res;
	}

}
