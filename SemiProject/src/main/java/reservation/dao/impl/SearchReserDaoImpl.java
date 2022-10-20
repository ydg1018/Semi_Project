package reservation.dao.impl;

import java.sql.Connection;
import java.util.List;

import hosInfo.dto.HosInfo;
import reservation.dao.face.SearchReserDao;
import util.Paging;

public class SearchReserDaoImpl implements SearchReserDao {

	@Override
	public List<HosInfo> selectAll(Connection connection, Paging paging) {
		System.out.println("SearchReserDao selectAll() 시작");
		
		String sql = "";
		//쿼리작성하면됌.
		
		
		return null;
	}
	
	
	@Override
	public int selectCntAll(Connection connection) {
		return 0;
	}
	
}
