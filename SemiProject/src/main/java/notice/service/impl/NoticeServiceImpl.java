package notice.service.impl;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import notice.dao.face.NoticeDao;
import notice.dao.impl.NoticeDaoImpl;
import notice.dto.Notice;
import notice.service.face.NoticeService;
import util.Paging;

public class NoticeServiceImpl implements NoticeService {

		//DAO객체
		private NoticeDao noticeDao = new NoticeDaoImpl();

		 @Override
		public List<Notice> getList() {
			 System.out.println("BoardService getList( ) - 시작");
			 

			 System.out.println("BoardService getList( ) - 끝");

			 //DB조회결과 반환
			 return noticeDao.selectAll(JDBCTemplate.getConnection());
			 
		}
		 
		 @Override
		public List<Notice> getList(Paging paging) {
			 
			return noticeDao.selectAll(JDBCTemplate.getConnection(), paging);
		}
		 
		 @Override
		public Paging getPaging(HttpServletRequest req) {
			 
			 //총 게시글 수 조회하기
			 int totalCount = noticeDao.selectCntAll(JDBCTemplate.getConnection());
			 
			 //전달파라미터 curPage 추출하기
			 String param = req.getParameter("curPage");
			 int curPage = 0;
			 if( param != null && !"".equals(param)) {
				 curPage = Integer.parseInt(param);
			 }
			 
			 //Paging객체 생성
			 Paging paging = new Paging(totalCount, curPage);
			 
			 return paging;
		}
		 
		
}
