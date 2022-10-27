package reply.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reply.dto.Reply;
import reply.service.face.ReplyService;
import reply.service.impl.ReplyServiceImpl;


@WebServlet("/reply/insert")
public class ReplyInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ReplyService rs = new ReplyServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//파라미터 추출
		int boardno = Integer.parseInt(req.getParameter("boardno"));
		String ownerNick = (String) req.getSession().getAttribute("owner_nick");
		String replyContent = req.getParameter("reply-content");
		
		//작성자 ID 처리
		String owner_no = ( (String) req.getSession().getAttribute("owner_no") );
		
		
		//답글 객체 생성
		Reply reply = new Reply();
		
		//테스트 owner_no -> 로그인 구현되면 삭제할 것
		reply.setOwnerNo(1);
	
		//게시글 번호 삽입
		reply.setBoardNo(boardno);
		reply.setOwnerNick(ownerNick);
		reply.setReplyContent(replyContent);
		
		//답글 작성
		rs.insertReply(reply);
		}
}
