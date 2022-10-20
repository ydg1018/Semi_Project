package depInfo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import depInfo.dao.face.DetInfoDao;
import depInfo.dto.DetInfo;

public class DetInfoDaoImpl implements DetInfoDao {
	
	//SQL수행 객체
	private PreparedStatement ps;
	
	//SQL조회 결과 객체
	private ResultSet rs;
	
	@Override
	public List<DetInfo> selectAll(Connection conn) {
		
		//SQL 작성
		String sql = "";
		sql += "SELECT det_item, det_detail FROM detInfo";
		sql += " ORDER BY det_code";
		
		//결과 저장할 List
		List<DetInfo> detInfo = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			
			rs = ps.executeQuery(); //SQL수행 및 결과 집합 저장
			
			//조회 결과 처리
			while(rs.next()) {
				
				//조회 결과 행 저장 DTO객체
				DetInfo d = new DetInfo();
				
				d.setDet_item(rs.getString("det_item"));
				d.setDet_detail(rs.getString("det_detail"));
				
				//리스트에 결과값 저장하기
				detInfo.add(d);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		//최종 결과 반환
		return detInfo;
	}

}
