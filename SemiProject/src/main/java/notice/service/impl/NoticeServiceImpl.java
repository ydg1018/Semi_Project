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
		 
		 @Override
		public Notice getNoticeIdx(HttpServletRequest req) {
			
			//전달파라미터를 저장할 객체 생성
			Notice notice = new Notice();
			
			//전달파라미터 noticeIdx 추출(파싱)
			String param = req.getParameter("noticeIdx");
			if ( null != param && !"".equals(param) ) {	//전달파라미터가 null 또는 "" 빈문자열이 아닐 때 처리
				notice.setNoticeIdx(Integer.parseInt(param));
			}
			return notice;
		}
	
		@Override
		public Notice view(Notice noticeIdx) {
			
			//DB연결 객체
			Connection conn = JDBCTemplate.getConnection();
			
			//조회수 증가
			if( noticeDao.updateHit(conn, noticeIdx) > 0) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}
			
			//게시글 조회
			Notice notice = noticeDao.selectNoticeByNoticeIdx(conn, noticeIdx);
			
			//조회된 게시글 리턴
			return notice;
		} 
		 
}
