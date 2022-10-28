package depInfo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import depInfo.dao.face.DepInfoDao;
import depInfo.dto.DepInfo;

public class DepInfoDaoImpl implements DepInfoDao {
	
	//SQL수행 객체
	private PreparedStatement ps;
	
	//SQL조회 결과 객체
	private ResultSet rs;
	
	@Override
	public List<DepInfo> selectAll(Connection conn) {
		
		//SQL 작성
		String sql = "";
		sql += "SELECT dep_item, dep_detail, det_item, det_detail, trt_item FROM AllInfo";
		sql += " ORDER BY det_code";
		
		//결과 저장할 List
		List<DepInfo> list = new ArrayList<DepInfo>();
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			
			rs = ps.executeQuery(); //SQL수행 및 결과 집합 저장
			
			//조회 결과 처리
			while(rs.next()) {

				//조회 결과 행 저장 DTO객체
				DepInfo dt = new DepInfo();
				
				dt.setDep_item(rs.getString("dep_item"));
				dt.setDep_detail(rs.getString("dep_detail"));
				dt.setDet_item(rs.getString("det_item"));
				dt.setDet_detail(rs.getString("det_detail"));
				dt.setTrt_item(rs.getString("trt_item"));
				
				//리스트에 결과값 저장하기
				list.add(dt);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		//최종 결과 반환
		return list;
	}
 
	@Override
	public DepInfo selectDetByDetitem(Connection conn, DepInfo det_item) {

		String sql = "";
		sql += "SELECT dep_item, dep_detail, det_item, det_detail, trt_item FROM AllInfo";
		sql += " WHERE det_item = ?";
		
		DepInfo dt = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, det_item.getDet_item());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				dt = new DepInfo();
				
				dt.setDep_item(rs.getString("dep_item"));
				dt.setDep_detail(rs.getString("dep_detail"));
				dt.setDet_item(rs.getString("det_item"));
				dt.setDet_detail(rs.getString("det_detail"));
				dt.setTrt_item(rs.getString("trt_item"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return dt;
	}
	
	@Override
	public ArrayList<DepInfo> searchDepInfo(String det_detail) {
		
		ArrayList<DepInfo> list = new ArrayList<DepInfo>();
		
		Connection conn = JDBCTemplate.getConnection();
		
		try {
			ps = conn.prepareStatement
				("SELECT dep_item, det_item, det_detail, trt_item FROM AllInfo WHERE det_detail like '%" + det_detail + "%'");
			
			rs = ps.executeQuery(); //SQL수행 및 결과 집합 저장
			
			//조회 결과 처리
			while(rs.next()) {
				
				//조회 결과 행 저장 DTO객체
				DepInfo dt = new DepInfo();
				
				dt.setDep_item(rs.getString("dep_item"));
				dt.setDet_item(rs.getString("det_item"));
				dt.setDet_detail(rs.getString("det_detail"));
				dt.setTrt_item(rs.getString("trt_item"));
				
				//리스트에 결과값 저장하기
				list.add(dt);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return list;
	}

}
