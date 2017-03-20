package app.service.system;

import app.entity.system.PageData;
import app.entity.system.User;

import java.util.List;
import java.util.Map;

/**
 * UserService接口
 * @author 李晨
 *
 */
public interface UserService {
	    
	/**
	* 用户登录
	* @param user
	* @return
	*/
	public User login(User user);
	    
	    
	/**
	* 用户查询
	* @param map
	* @return
	*/
	public List<User> find(Map<String, Object> map);
	    
	    
	/**
	* 获取总记录数
	* @param map
	* @return
	*/
	public Long getTotal(Map<String, Object> map);
	    
	    
	/**
	* 修改用户
	* @param user
	* @return影响的记录数
	*/
	public int update(User user);
	    
	    
	/**
	* 添加用户
	* @param user
	* @return影响的记录数
	*/
	public int add(User user);
	    
	    
	/**
	* 删除用户
	* @param id
	* @return
	*/
	public int delete(int id);

	
	/**
	 * 获取所有用户信息
	 * @author 李 晨
	 * @param pd 
	 * @date 2017-03-04
	 * @return
	 */
	public List<Map<String, Object>> getAll(PageData pd);


	/**
	 * 获取相应用户数量
	 * @author 李 晨
	 * @param pd 
	 * @date 2017-03-04
	 * @return
	 */
	public int getAll_count(PageData pd);
	
	/**
	 * 查询特定的字段
	 * @author 李 晨
	 * @param pd 
	 * @date 2017-03-09
	 * @return 结果的map
	 */
	public List<Map<String, Object>> getSelect(PageData pd);


	public List<Map<String, Object>> getRole(PageData pd);

}
