package app.service.system.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import app.entity.system.PageData;
import app.dao.system.UserDao;
import app.entity.system.User;
import app.service.system.UserService;


/**
 * UserService实现类
 * @author 李晨
 * @date 2017-02-26
 *
 */

@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Resource
	private UserDao userDao;
	
	
	@Override
	public User login(User user) {
		return userDao.login(user);
	}
	
	
	@Override
	public List<User> find(Map<String, Object> map) {
		return userDao.find(map);
	}
	
	
	@Override
	public Long getTotal(Map<String, Object> map) {
		return userDao.getTotal(map);
	}
	
	
	@Override
	public int update(User user) {
		return userDao.update(user);
	}
	
	
	@Override
	public int add(User user) {
		return userDao.add(user);
	}
	
	
	@Override
	public int delete(int id) {
		return userDao.delete(id);
	}


	@Override
	public List<Map<String, Object>> getAll(PageData pd) {
		// TODO Auto-generated method stub
		return userDao.getAll(pd);
	}


	@Override
	public int getAll_count(PageData pd) {
		// TODO Auto-generated method stub
		return userDao.getAll_count(pd);
	}


	@Override
	public List<Map<String, Object>> getSelect(PageData pd) {
		// TODO Auto-generated method stub
		return (List<Map<String, Object>>) userDao.getSelect(pd);
	}


	@Override
	public List<Map<String, Object>> getRole(PageData pd) {
		// TODO Auto-generated method stub
		return userDao.getRole(pd);
	}


	
	
}