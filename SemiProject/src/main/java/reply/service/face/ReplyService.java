package reply.service.face;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import reply.dto.Reply;

public interface ReplyService {

	/**
	 * 
	 * @param reply - 작성할 reply 객체
	 * @return - 작성한 reply 객체
	 */
	public int insertReply(Reply reply);

	/**
	 * 
	 * @param boardNo - 답글 조회할 게시글 번호
	 * @return - 조회된 답글 목록
	 */
	public ArrayList<Reply> selectReplyList(int boardno);

	
}
