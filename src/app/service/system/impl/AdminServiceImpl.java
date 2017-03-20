package app.service.system.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import app.dao.system.AdminDao;
import app.dao.system.UserDao;
import app.entity.system.Admin;
import app.entity.system.User;
import app.service.system.AdminService;
import app.service.system.UserService;


/**
 * UserService实现类
 * @author 李晨
 * @date 2017-02-26
 *
 */

@Service("adminService")
public class AdminServiceImpl implements AdminService{
	
	@Resource
	private AdminDao adminDao;
	
	//登录
	@Override
	public Map<String, Object> login(Admin admin) {
		return (Map<String, Object>) adminDao.login(admin);
	}
	
	//退出登录
	@Override
	public Map<String, Object> logout(Admin admin) {
		// TODO Auto-generated method stub
		return (Map<String, Object>) adminDao.logout(admin);
	}
	
	
}