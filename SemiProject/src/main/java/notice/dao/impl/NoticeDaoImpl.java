package notice.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import notice.dao.face.NoticeDao;
import notice.dto.Notice;
import util.Paging;

public class NoticeDaoImpl implements NoticeDao {
	
	private PreparedStatement ps; //SQL수행 객체
	private ResultSet rs;	//SQL조회 결과 객체
	
	@Override
	public List<Notice> selectAll(Connection conn) {
		System.out.println("NoticeDao selectAll() - 시작");
		
		//SQL작성
		String sql = "";
		sql += "SELECT";
		sql += " 	notice_idx, notice_title, notice_date, notice_hit";
		sql += " FROM notice";
		sql += " ORDER BY notice_idx DESC";
		
		//결과 저정할 List
		List<Notice> noticeList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			rs = ps.executeQuery(); //SQL수행 및 결과 집합 저장
			
			//조회 결과 처리
			while(rs.next()) {
				Notice n = new Notice(); //조회 결과 행 저장 DTO객체
				
				n.setNoticeIdx(rs.getInt("notice_idx"));
				n.setNoticeTitle(rs.getString("notice_title"));
				n.setNoticeDate(rs.getDate("notice_date"));
				n.setNoticeHit(rs.getInt("notice_hit"));
				
				//리스트에 결과값 저장하기
				noticeList.add(n);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		
		System.out.println("NoticeDao selectAll() - 끝");

		return noticeList; //최종 결과 반환
	}
	
	@Override
	public List<Notice> selectAll(Connection conn, Paging paging) {
		System.out.println("NoticeDao selectAll() - 시작");
		
		//SQL작성
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "	SELECT rownum rnum, B.* FROM("; 
        sql += "		SELECT";
        sql += "			notice_idx, notice_title, notice_date, notice_hit";
        sql += "				FROM notice";
        sql += "		ORDER BY notice_idx DESC";
		sql += "	    ) B";
		sql += "	) BOARD";
		sql += "	WHERE rnum BETWEEN ? AND ?";
		
		//결과 저정할 List
		List<Notice> noticeList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			
			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());
			
			
			rs = ps.executeQuery(); //SQL수행 및 결과 집합 저장
			
			//조회 결과 처리
			while(rs.next()) {
				Notice n = new Notice(); //조회 결과 행 저장 DTO객체
				
				n.setNoticeIdx(rs.getInt("notice_idx"));
				n.setNoticeTitle(rs.getString("notice_title"));
				n.setNoticeDate(rs.getDate("notice_date"));
				n.setNoticeHit(rs.getInt("notice_hit"));
				
				//리스트에 결과값 저장하기
				noticeList.add(n);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		
		System.out.println("NoticeDao selectAll() - 끝");
		
		return noticeList; //최종 결과 반환
	}
	
	@Override
	public int selectCntAll(Connection conn) {
		
		String sql = "";
		sql += "SELECT count(*) cnt FROM notice";
		
		//총 게시글 수 변수
		int count = 0;
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			rs = ps.executeQuery(); //SQL수행 및 결과 집합 저장
			
			while(rs.next()) {
				count = rs.getInt("cnt");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		//최종 결과 반환
		return count;
	}
	
	@Override
	public int updateHit(Connection conn, Notice noticeIdx) {
		
		String sql = "";
		sql += "UPDATE notice";
		sql += " 	SET notice_hit = notice_hit + 1";
		sql += " WHERE notice_idx = ?";
		
		int res = 0;
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, noticeIdx.getNoticeIdx());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return res;
	}
	
	@Override
	public Notice selectNoticeByNoticeIdx(Connection conn, Notice noticeIdx) {
		
		String sql="";
		sql += "SELECT";
		sql += "	notice_idx, notice_title, notice_content";
		sql += "	notice_date, notice_hit";
		sql += " FROM notice";
		sql += " WHERE notice_idx = ? ";
		
		Notice notice = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(2, noticeIdx.getNoticeIdx());
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				notice = new Notice();
				
				notice.setNoticeIdx(rs.getInt("notice_idx"));
				notice.setNoticeTitle(rs.getString("notice_title"));
				notice.setNoticeContent(rs.getString("notice_content"));
				notice.setNoticeDate(rs.getDate("notice_date"));
				notice.setNoticeHit(rs.getInt("notice_hit"));
				
			}
					
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		
		return notice;
	}
	

}
