package app.service.system.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import app.dao.system.BusDao;
import app.entity.system.PageData;
import app.service.system.BusService;

@Service("BusService")
public class BusServiceImpl implements BusService{
	
	@Resource
	public BusDao busDao;
	
	@Override
	public List<Map<String, Object>> getAll(PageData pd) {
		// TODO Auto-generated method stub
		return busDao.getAll(pd);
	}

	@Override
	public int getAll_count(PageData pd) {
		// TODO Auto-generated method stub
		return busDao.getAll_count(pd);
	}
	
}
