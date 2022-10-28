package reply.service.impl;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import reply.dao.face.ReplyDao;
import reply.dao.impl.ReplyDaoImpl;
import reply.dto.Reply;
import reply.service.face.ReplyService;

public class ReplyServiceImpl implements ReplyService {

	private ReplyDao replyDao = new ReplyDaoImpl();
	
	@Override
	public int insertReply(Reply reply) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int res = replyDao.insertReply(conn, reply);
		
		if(res > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		return res;
	}

	@Override
	public ArrayList<Reply> selectReplyList(int boardno) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Reply> list = replyDao.selectReplyList(conn, boardno);
		
		return list;
	}

}
