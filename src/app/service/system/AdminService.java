package app.service.system;

import java.util.Map;

import app.entity.system.Admin;

public interface AdminService {
	
	/**
	* 管理员登录
	* @param admin
	* @return
	*/
	public Map<String, Object> login(Admin admin);

	public Map<String, Object> logout(Admin admin);
	
	
}
