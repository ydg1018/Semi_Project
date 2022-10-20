package depInfo.service.impl;

import java.util.List;

import common.JDBCTemplate;
import depInfo.dao.face.TrtInfoDao;
import depInfo.dao.impl.TrtInfoDaoImpl;
import depInfo.dto.TrtInfo;
import depInfo.service.face.TrtInfoService;

public class TrtInfoServiceImpl implements TrtInfoService {

	//DAO객체
	private TrtInfoDao trtInfoDao = new TrtInfoDaoImpl();
	
	@Override
	public List<TrtInfo> getList() {
		
		return trtInfoDao.selectAll(JDBCTemplate.getConnection());
	}
}
