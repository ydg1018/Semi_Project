package review.service.impl;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import common.JDBCTemplate;
import reply.dto.Reply;
import review.dao.face.ReviewDao;
import review.dao.impl.ReviewDaoImpl;
import review.dto.Review;
import review.service.face.ReviewService;
import util.BoardFile;
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

/*	@Override
	public List<Review> getList(Paging paging) {
		return reviewDao.selectAll(JDBCTemplate.getConnection(), paging);
	} */

	@Override
	public List<Review> getList(Paging paging, String field, String query) {
		return reviewDao.selectAll(JDBCTemplate.getConnection(), paging, field, query);
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
	
	@Override
	public Paging getPaging(HttpServletRequest req, String field, String query) {
		
		//총 게시글 수 조회하기 - 검색어가 반영된 게시글 개수 조회로 바꾼다
		int totalCount = reviewDao.selectCntAll(JDBCTemplate.getConnection(), field, query);
		
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

	//---------------ReviewInsertController---------------------------------

	@Override
	public void write(HttpServletRequest req) {
		
		//multipart/form-data 인코딩 확인
		boolean isMultipart = ServletFileUpload.isMultipartContent(req);
		
		//multipart형식이 아닐 경우 처리 중단
		if( !isMultipart ) {
			System.out.println("[ERROR] 파일 업로드 형식 데이터가 아님");
			return;
		}
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		//메모리 처리 사이즈 설정
		int maxMem = 1 * 1024 * 1024;	// 1 MB == 1048576 B
		factory.setSizeThreshold(maxMem);

		//서블릿 컨텍스트 객체
		ServletContext context = req.getServletContext();
		
		//임시 파일 저장 폴더
		String path = context.getRealPath("tmp");
		File tmpRepository = new File(path);
		tmpRepository.mkdir();
		factory.setRepository(tmpRepository);
//
		//파일 업로드 수행 객체
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		//파일 업로드 용량 제한
		int maxFile = 10 * 1024 * 1024; // 10MB
		upload.setFileSizeMax(maxFile);

		//파일 업로드된 데이터 파싱
		List<FileItem> items = null;
		try {
			items = upload.parseRequest(req);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}

		//게시글 정보 DTO객체
		Review review = new Review();
		
		//게시글 첨부파일 정보 DTO객체
		BoardFile boardFile = new BoardFile();
	
		//파일아이템의 반복자
		Iterator<FileItem> iter = items.iterator();

		while( iter.hasNext() ) {
			FileItem item = iter.next();
			
			//--- 1) 빈 파일에 대한 처리 ---
			if( item.getSize() <= 0 ) { //전달 데이터의 크기
				//빈 파일은 무시하고 다음 FileItem처리로 넘어간다
				continue;
			}
			
			//--- 2) 폼 필드에 대한 처리 ---
			if( item.isFormField() ) {
				
				//키(key) 추출하기
				String key = item.getFieldName();
				
				//값(value) 추출하기
				String value = null;
				try {
					value = item.getString("UTF-8"); //한글 인코딩 지정
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				
				//key에 맞게 value를 DTO에 삽입하기
				if( "title".equals(key) ) {
					review.setBoardTitle(value);
				}
				if( "content".equals(key) ) {
					review.setBoardContent(value);
				}
				
			} // if( item.isFormField() ) end
			
			
			
			//--- 3) 파일에 대한 처리 ---
			if( !item.isFormField() ) {
				
				//저장 파일명 처리
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssS");
				String rename = sdf.format(new Date()); //현재시간
				
				//파일 업로드 폴더
				File uploadFolder = new File( context.getRealPath("upload") );
				uploadFolder.mkdir();
				
				//업로드할 파일 객체 생성하기
				File up = new File(uploadFolder, rename);
				try {
					item.write(up);	//임시파일을 실제 업로드 파일로 출력한다
					item.delete(); //임시파일 제거
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				//업로드된 파일의 정보를 DTO객체에 저장하기
				boardFile.setOriginname(item.getName());
				boardFile.setStoredname(rename);
				boardFile.setFilesize((int)item.getSize());
				
			} // if( !item.isFormField() ) end
			
		} // while( iter.hasNext() ) end

		
		//DB연결 객체
		Connection conn = JDBCTemplate.getConnection();
		
		//게시글 번호 생성
		int boardno = reviewDao.selectNextBoardno(conn);
		
		
		//게시글 번호 삽입
		review.setBoardNo(boardno);

		//작성자 ID 처리
//		String owner_no = ( (String) req.getSession().getAttribute("owner_no") );
		
		//테스트 owner_no -> 로그인 구현되면 삭제할 것
//		review.setOwnerNo(1);
		
		if( reviewDao.insert(conn, review) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}

		
		//첨부파일 정보 삽입
		if( boardFile.getFilesize() != 0 ) { //첨부 파일이 존재할 때에만 동작
			
			//게시글 번호 삽입 (FK)
			boardFile.setBoardno(boardno);
			
			if( reviewDao.insertFile(conn, boardFile) > 0 ) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}
			
		}
		
		//----------------------------------------------
	}
	
	@Override
	public BoardFile viewFile(Review viewBoard) {
		return reviewDao.selectFile(JDBCTemplate.getConnection(), viewBoard);
	}


	@Override
	public void update(HttpServletRequest req) {

		//multipart/form-data 인코딩 확인
		boolean isMultipart = ServletFileUpload.isMultipartContent(req);
		
		//multipart형식이 아닐 경우 처리 중단
		if( !isMultipart ) {
			System.out.println("[ERROR] 파일 업로드 형식 데이터가 아님");
			return;
		}
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		//메모리 처리 사이즈 설정
		int maxMem = 1 * 1024 * 1024;	// 1 MB == 1048576 B
		factory.setSizeThreshold(maxMem);
	
		//서블릿 컨텍스트 객체
		ServletContext context = req.getServletContext();
		
		//임시 파일 저장 폴더
		String path = context.getRealPath("tmp");
		File tmpRepository = new File(path);
		tmpRepository.mkdir();
		factory.setRepository(tmpRepository);
	
		//파일 업로드 수행 객체
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		//파일 업로드 용량 제한
		int maxFile = 10 * 1024 * 1024; // 10MB
		upload.setFileSizeMax(maxFile);
	
		//파일 업로드된 데이터 파싱
		List<FileItem> items = null;
		try {
			items = upload.parseRequest(req);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
	
		//게시글 정보 DTO객체
		Review review = new Review();
		
		//게시글 첨부파일 정보 DTO객체
		BoardFile boardFile = new BoardFile();
	
		//파일아이템의 반복자
		Iterator<FileItem> iter = items.iterator();
	
		while( iter.hasNext() ) {
			FileItem item = iter.next();
			
			//--- 1) 빈 파일에 대한 처리 ---
			if( item.getSize() <= 0 ) { //전달 데이터의 크기
				//빈 파일은 무시하고 다음 FileItem처리로 넘어간다
				continue;
			}
			
			//--- 2) 폼 필드에 대한 처리 ---
			if( item.isFormField() ) {
				
				//키(key) 추출하기
				String key = item.getFieldName();
				
				//값(value) 추출하기
				String value = null;
				try {
					value = item.getString("UTF-8"); //한글 인코딩 지정
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				
				//key에 맞게 value를 DTO에 삽입하기
				if( "boardno".equals(key) ) {
					review.setBoardNo(Integer.parseInt(value));
				}
				if( "title".equals(key) ) {
					review.setBoardTitle(value);
				}
				if( "content".equals(key) ) {
					review.setBoardContent(value);
				}
				
			} // if( item.isFormField() ) end
			
			
			
			//--- 3) 파일에 대한 처리 ---
			if( !item.isFormField() ) {
				
				//저장 파일명 처리
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssS");
				String rename = sdf.format(new Date()); //현재시간
				
				//파일 업로드 폴더
				File uploadFolder = new File( context.getRealPath("upload") );
				uploadFolder.mkdir();
				
				//업로드할 파일 객체 생성하기
				File up = new File(uploadFolder, rename);
				try {
					item.write(up);	//임시파일을 실제 업로드 파일로 출력한다
					item.delete(); //임시파일 제거
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				//업로드된 파일의 정보를 DTO객체에 저장하기
				boardFile.setOriginname(item.getName());
				boardFile.setStoredname(rename);
				boardFile.setFilesize((int)item.getSize());
				
			} // if( !item.isFormField() ) end
			
		} // while( iter.hasNext() ) end
	
		
		//DB연결 객체
		Connection conn = JDBCTemplate.getConnection();
		
		
		//작성자 ID 처리
		String owner_no = ( (String) req.getSession().getAttribute("owner_no") );
		
		//테스트 owner_no -> 로그인 구현되면 삭제할 것
		review.setOwnerNo(1);
		
		
		if( reviewDao.update(conn, review) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
	
		
		//첨부파일 정보 삽입
		if( boardFile.getFilesize() != 0 ) { //첨부 파일이 존재할 때에만 동작
			
			//게시글 번호 삽입 (FK)
			boardFile.setBoardno(review.getBoardNo());
			
			if( reviewDao.insertFile(conn, boardFile) > 0 ) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}
			
		}
	}

		@Override
		public void delete(Review review) {
			Connection conn = JDBCTemplate.getConnection();
			
			//첨부 파일 전부 삭제
			if(reviewDao.deleteFile(conn, review) > 0 ) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}
			
			//게시글 삭제
			if(reviewDao.delete(conn, review) > 0 ) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}
			
		}
		
}
