package reply.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import reply.dto.Reply;
import reply.service.face.ReplyService;
import reply.service.impl.ReplyServiceImpl;

@WebServlet("/reply/list")
public class ReplyListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ReplyService rs = new ReplyServiceImpl();
	
	Gson gson = new Gson();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int boardno = Integer.parseInt(req.getParameter("boardno"));
		
		//답글목록 조회
		ArrayList<Reply> list = rs.selectReplyList(boardno);
		
		resp.setContentType("application/json;charset=utf-8");
		
		//답글조회 결과 Json데이터로 응답
		new Gson().toJson(list, resp.getWriter());
	}
}
