package reply.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import reply.dao.face.ReplyDao;
import reply.dto.Reply;

public class ReplyDaoImpl implements ReplyDao {

	private PreparedStatement ps; //SQL수행 객체
	private ResultSet rs; //조회 결과 객체
	
	@Override
	public int insertReply(Connection conn, Reply reply) {

		String sql = "";
		sql += "INSERT INTO reply ( reply_no, board_no, owner_no, reply_content, owner_nick )";
		sql += " VALUES ( reply_seq.nextval, ?, ?, ?, ? )";
		sql += " WHERE board.board_no = reply.board_no";
		sql += " AND board_no = ?";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, reply.getBoardNo());
			ps.setInt(2, reply.getOwnerNo());
			ps.setString(3, reply.getReplyContent());
			ps.setString(4, reply.getOwnerNick());
			ps.setInt(5, reply.getBoardNo());
			
			res = ps.executeUpdate();

 		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return res;
	}

	@Override
	public ArrayList<Reply> selectReplyList(Connection conn, int boardno) {

		//--- SQL 작성 ---
		String sql = "";
		sql += "SELECT";
		sql += " 	reply_no, reply_content, board_no, insert_dat, owner_no, owner_nick";
		sql += " FROM reply, owner, board";
		sql += " WHERE reply.board_no = board.board_no";
		sql += 		" AND reply.owner_no = owner.owner_no";
		sql += " ORDER BY reply_no DESC";
		
		ArrayList<Reply> replyList = new ArrayList<>();
		
		try {
			//--- SQL 수행 객체 생성 ---
			ps = conn.prepareStatement(sql);
			
			//--- SQL 수행 및 결과 저장 ---
			rs = ps.executeQuery();
			
			//--- 조회 결과 처리 ---
			while( rs.next() ) {
				Reply r = new Reply();
				
				r.setReplyNo(rs.getInt("reply_no"));
				r.setReplyContent(rs.getString("reply_content"));
				r.setBoardNo(rs.getInt("board_no"));
				r.setInsertDat(rs.getDate("insert_dat"));
				r.setOwnerNo(rs.getInt("owner_no"));
				r.setOwnerNick(rs.getString("owner_nick"));
				
						
				//리스트에 결과값 저장
				replyList.add(r);
				
			}
			
 		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//--- 자원 해제 ---
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		//--- 최종 결과 반환 ---
		return replyList;
	}


}
