package app.dao.system;

import java.util.List;
import java.util.Map;

import app.entity.system.PageData;
import app.entity.system.User;

/**
 * 用户DAO接口
 * @author 李晨
 * @date 2017-02-26
 * 
 */
public interface UserDao {
    
    /**
     * 用户登录
     * @param user
     * @return
     */
    public User login(User user);
    
    /**
     * 用户查询
     * @param map
     * @return 用户集合
     */
    public List<User> find(Map<String, Object> map);
    
    /**
     * 获取总记录数
     * @param map
     * @return 获取的total数
     */
    public Long getTotal(Map<String, Object> map);
    
    /**
     * 修改用户
     * @param user
     * @return 影响的记录数
     */
    public int update(User user);
    
    /**
     * 添加用户
     * @param user
     * @return 影响的记录数
     */
    public int add(User user);
    
    /**
     * 删除用户
     * @param id
     * @return
     */
    public int delete(int id);
    
    /**
     * 获取所有用户
     * @author 李 晨
     * @param pd 
     * @date 2017-03-03
     */
    public List<Map<String, Object>> getAll(PageData pd);

    /**
     * 获取所有用户数量
     * @author 李 晨
     * @param 
     * @date 2017-03-03
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
