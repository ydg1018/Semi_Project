package depInfo.service.impl;

import java.util.List;

import common.JDBCTemplate;
import depInfo.dao.face.DepInfoDao;
import depInfo.dao.impl.DepInfoDaoImpl;
import depInfo.dto.DepInfo;
import depInfo.service.face.DepInfoService;

public class DepInfoServiceImpl implements DepInfoService {

	//DAO객체
	private DepInfoDao depInfoDao = new DepInfoDaoImpl();
	
	@Override
	public List<DepInfo> getList() {
		
		return depInfoDao.selectAll(JDBCTemplate.getConnection());
	}
}
