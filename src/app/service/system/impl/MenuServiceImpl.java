package app.service.system.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import app.dao.system.DaoSupport;
import app.dao.system.MenuDao;
import app.entity.system.Menu;
import app.service.system.MenuService;

@Service("MenuService")
public class MenuServiceImpl implements MenuService {
	@Resource
	private MenuDao menuDao;
	
	@Override
	public List<Map<String, Object>> getMenu(Menu menu) throws Exception {
		// TODO Auto-generated method stub
		return (List<Map<String, Object>>) menuDao.getMenu(menu);
	}

	@Override
	public List<Map<String, Object>> getMenuChild1(Menu menu)
			throws Exception {
		// TODO Auto-generated method stub
		return (List<Map<String, Object>>) menuDao.getMenuChild1(menu);
	}

	@Override
	public List<Map<String, Object>> getMenuChild2(Menu menu) {
		// TODO Auto-generated method stub
		return (List<Map<String, Object>>) menuDao.getMenuChild2(menu);
	}
	
}
