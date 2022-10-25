package hosInfo.service.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import hosInfo.dao.face.HosInfoDao;
import hosInfo.dao.impl.HosInfoDaoImpl;
import hosInfo.dto.HosInfo;
import hosInfo.service.face.HosInfoService;
import util.Paging;

public class HosInfoServiceImpl implements HosInfoService {

	//DAO 객체
	private HosInfoDao hosInfoDao = new HosInfoDaoImpl();
	
	@Override
	public List<HosInfo> getList() {
		
		return hosInfoDao.selectAll(JDBCTemplate.getConnection());
	}
	
	@Override
	public List<HosInfo> getList(Paging paging) {
		
		return hosInfoDao.selectAll(JDBCTemplate.getConnection(), paging);
	}
	
	@Override
	public Paging getPaging(HttpServletRequest req) {
	
		//총 게시글 수 조회하기
		int totalCount = hosInfoDao.selectCntAll(JDBCTemplate.getConnection());
		
		
		//전달파라미터 curPage 추출하기
		String param = req.getParameter("curPage");
		int curPage = 0;
		if( param != null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
		
		//Paging객체 생성
		Paging paging = new Paging(totalCount, curPage);
		
		return paging;
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
		
		//병원 정보 조회
		HosInfo hosInfo = hosInfoDao.selectHosByHosname(conn, hos_name);
		
		//조회된 병원 정보 리턴
		return hosInfo;
	}
	
	@Override
	public ArrayList<HosInfo> searchHosInfo(String hos_name) {

		ArrayList<HosInfo> list = new ArrayList<HosInfo>();
		
		try {
			list = hosInfoDao.searchHosInfo(hos_name);
		} catch (Exception e) {
			list = null;
		}
		
		return list;
	}
}
