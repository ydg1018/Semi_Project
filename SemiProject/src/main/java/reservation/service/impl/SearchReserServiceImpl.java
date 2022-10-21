package reservation.service.impl;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import hosInfo.dto.HosInfo;
import reservation.dao.face.SearchReserDao;
import reservation.dao.impl.SearchReserDaoImpl;
import reservation.service.face.SearchReserService;
import util.Paging;

public class SearchReserServiceImpl implements SearchReserService {

	SearchReserDao searchReserDao = new SearchReserDaoImpl();
	
	@Override
	public List<HosInfo> getList(Paging paging) {
		
		
		return searchReserDao.selectAll(JDBCTemplate.getConnection(), paging);
	}
	
	@Override
	public Paging getPaging(HttpServletRequest req) {
		
		//총 게시글 수 조회하기
		int totalCount = searchReserDao.selectCntAll(JDBCTemplate.getConnection());
		
		//전달 파라미터 curPage 추출하기
		String param = req.getParameter("curPage");
		int curPage = 0;
		if( param != null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
		
		//Paging 객체 생성
		Paging paging = new Paging(totalCount, curPage);
		
		return paging;
	}
	
	@Override
	public HosInfo getHosName(HttpServletRequest req) {
		
		HosInfo hosName = new HosInfo();
		
		String param = req.getParameter("hosname");
		if( null != param && !"".equals(param) ) {
			hosName.setHosName(param);
		}
		
		return hosName;
	}
	
	@Override
	public List<HosInfo> detail(HosInfo hosName) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		List<HosInfo> hosInfo = searchReserDao.selectHosInfoByHosName(conn, hosName); 
		
		return hosInfo;
	}
	
}
