package app.dao.system;

import java.util.Map;

import app.entity.system.Admin;


/**
 * 管理员DAO接口
 * @author 李晨
 * @date 2017-02-26
 * 
 */
public interface AdminDao {
	
    /**
     * 管理员登录
     * @param admin
     * @return
     */
    public Map<String, Object> login(Admin admin);

	public Map<String, Object> logout(Admin admin);
    
    
}
