package depInfo.service.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import depInfo.dao.face.DepInfoDao;
import depInfo.dao.impl.DepInfoDaoImpl;
import depInfo.dto.DepInfo;
import depInfo.service.face.DepInfoService;

public class DepInfoServiceImpl implements DepInfoService {

	//DAO객체
	private DepInfoDao dtDao = new DepInfoDaoImpl();
	
	@Override
	public List<DepInfo> getList() {
		return dtDao.selectAll(JDBCTemplate.getConnection());
	}
	
	@Override
	public DepInfo getDet_item(HttpServletRequest req) {

		//전달 파라미터를 저장할 객체 생성
		DepInfo dt = new DepInfo();
		
		//전달 파라미터 dep_item 추출
		String param = req.getParameter("det_item");
		
		if(null != param && !"".equals(param)) {
			dt.setDet_item(param);
		}
		
		return dt;
	}
	
	@Override
	public DepInfo view(DepInfo det_item) {
		
		//DB연결 객체
		Connection conn = JDBCTemplate.getConnection();
		
		//진료과 정보 조회
		DepInfo dt = dtDao.selectDetByDetitem(conn, det_item);
		
		//조회된 병원 정보 리턴
		return dt;
	}
	
	@Override
	public ArrayList<DepInfo> searchDepInfo(String det_detail) {
		
		ArrayList<DepInfo> list = new ArrayList<DepInfo>();
		
		try {
			list = dtDao.searchDepInfo(det_detail);
		} catch (Exception e) {
			list = null;
		}
		
		return list;
	}
}
