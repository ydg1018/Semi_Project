package review.service.impl;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import review.dao.face.ReviewDao;
import review.dao.impl.ReviewDaoImpl;
import review.dto.Review;
import review.service.face.ReviewService;
import util.Paging;

public class ReviewServiceImpl implements ReviewService {

	private ReviewDao reviewDao = new ReviewDaoImpl();
	
	//-----------ReviewListController--------------------------------
	@Override
	public List<Review> getList() {
		System.out.println("ReviewService getList() - 호출");
		
		//DB조회결과 반환
		return reviewDao.selectAll(JDBCTemplate.getConnection());
	}

	@Override
	public List<Review> getList(Paging paging) {
		return reviewDao.selectAll(JDBCTemplate.getConnection(), paging);
	}

	@Override
	public Paging getPaging(HttpServletRequest req) {
		
		//총 게시글 수 조회하기
		int totalCount = reviewDao.selectCntAll(JDBCTemplate.getConnection());
		
		//전달파라미터 curPage 추출하기
		String param = req.getParameter("curPage");
		int curPage = 0;
		if ( param != null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
		
		//Paging객체 생성
		Paging paging = new Paging(totalCount, curPage);
		
		return paging;
	}
	
	//-----------ReviewViewController--------------------------------
	@Override
	public Review getBoardno(HttpServletRequest req) {
		
		Review review = new Review();
		
		//전달파라미터 boardno 추출(파싱)
		String param = req.getParameter("boardno");
		if( param != null && !"".equals(param)) {
			review.setBoardNo( Integer.parseInt(param) );
		}
		
		return review;
	}

	@Override
	public Review view(Review boardno) {
		
		//DB연결 객체
		Connection conn = JDBCTemplate.getConnection();
		
		//조회수 증가
		if( reviewDao.updateHit(conn, boardno) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn); 
		}
		
		//게시글 조회
		Review review = reviewDao.selectBoardByBoardno(conn, boardno);
		
		//조회된 게시글 리턴
		return review;
	}

	@Override
	public void write(Review review) {
		
		//DB연결 객체
		Connection conn = JDBCTemplate.getConnection();
		
		//작성내용 존재여부
		if( reviewDao.insert(conn, review) > 0 ) {
			JDBCTemplate.commit(conn);
		}
		
	}

	@Override
	public void update(Review review) {

		//DB연결 객체
		Connection conn = JDBCTemplate.getConnection();
		
		//작성내용 존재여부
		if( reviewDao.update(conn, review) > 0 ) {
			JDBCTemplate.commit(conn);
		}
		
	}

}
