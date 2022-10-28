package reply.dao.face;

import java.sql.Connection;
import java.util.ArrayList;

import reply.dto.Reply;

public interface ReplyDao {

	/**
	 * 
	 * @param conn
	 * @param reply - 답글 객체
	 * @return
	 */
	public int insertReply(Connection conn, Reply reply);

	/**
	 * 
	 * @param conn - DB연결 객체
	 * @param boardNo - 답글 목록 조회할 게시글 번호
	 * @return reply - 답글 목록
	 */
	public ArrayList<Reply> selectReplyList(Connection conn, int boardno);

}
