package depInfo.service.impl;

import java.util.List;

import common.JDBCTemplate;
import depInfo.dao.face.DetInfoDao;
import depInfo.dao.impl.DetInfoDaoImpl;
import depInfo.dto.DetInfo;
import depInfo.service.face.DetInfoService;

public class DetInfoServiceImpl implements DetInfoService {

	//DAO객체
	private DetInfoDao detInfoDao = new DetInfoDaoImpl();
	
	@Override
	public List<DetInfo> getList() {
		
		return detInfoDao.selectAll(JDBCTemplate.getConnection());
	}
}
