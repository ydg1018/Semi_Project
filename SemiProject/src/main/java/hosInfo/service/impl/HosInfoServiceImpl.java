package hosInfo.service.impl;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import hosInfo.dao.face.HosInfoDao;
import hosInfo.dao.impl.HosInfoDaoImpl;
import hosInfo.dto.HosInfo;
import hosInfo.service.face.HosInfoService;

public class HosInfoServiceImpl implements HosInfoService {

	//DAO 객체
	private HosInfoDao hosInfoDao = new HosInfoDaoImpl();
	
	@Override
	public List<HosInfo> getList() {
		
		return hosInfoDao.selectAll(JDBCTemplate.getConnection());
	}
	
	@Override
	public HosInfo getHos_name(HttpServletRequest req) {

		//전달 파라미터를 저장할 객체 생성
		HosInfo hosInfo = new HosInfo();
		
		//전달 파라미터 hos_name 추출
		String param = req.getParameter("hos_name");
		if(null != param && !"".equals(param)) {
			hosInfo.setHos_name(param);
		}
		
		return hosInfo;
	}
	
	@Override
	public HosInfo view(HosInfo hos_name) {
		
		//DB연결 객체
		Connection conn = JDBCTemplate.getConnection();
		
		//게시글 조회
		HosInfo hosInfo = hosInfoDao.selectHosByHosname(conn, hos_name);
		
		
		//조회된 게시글 리턴
		return hosInfo;
	}
}
