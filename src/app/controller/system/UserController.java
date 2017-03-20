package app.controller.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;





import org.springframework.web.bind.annotation.ResponseBody;

import app.entity.system.PageData;
import app.entity.system.User;
import app.service.system.UserService;

import com.google.gson.Gson;


/**
 * 用户Controller层
 * @author 李晨
 * @date 2017-02-26
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserService userService;
	Gson json = new Gson();
	
	/**
	 * 转向本页面
	 * @param
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/user_list")
	public String user_list() throws Exception {
		return "admin/user_list";
	}
	
	
	/**
	 * 用户列表
	 * @param pd
	 * @return map
	 * @throws Exception
	 */
	@RequestMapping("/list")
	@ResponseBody
	public Map<String, Object> list(PageData pd) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		pd.setStart(pd.getPage(), pd.getRows(), 0);
		List<Map<String,Object>> list = userService.getAll(pd);
		int count = userService.getAll_count(pd);
		map.put("total", count);
		map.put("rows", list);
		return map;
	}
	
	
	/**
	 * 删除用户
	 * @param user
	 * @return json
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(User user) throws Exception{
		int result = 0;
		int id = user.getId();
		if(id != 0){
			result = userService.delete(id);
		}
		return json.toJson(result);
	}
	
	
	/**
	 * 添加或者修改
	 * @param user
	 * @param res
	 * @return result
	 * @throws Exception
	 */
	@RequestMapping("/save")
	@ResponseBody
	public String save(User user,HttpServletResponse res) throws Exception{
		int result = 0;
		//判断是否新增还是修改
		if(user.getId() == 0){
			//如果传过来user_id，则查询是否存在
			PageData pd = new PageData();
			pd.setSearch("user_id");
			pd.setSearch_value(user.getUser_id()+"");//转换成string
			List<Map<String,Object>> map = userService.getSelect(pd);
			if(map.size() == 0){
				result = userService.add(user);
			}else{
				result = 2;
			}
		}else {
			result = userService.update(user);
		}
		return json.toJson(result);//0:操作失败，1：操作成功,2:用户已存在
	}
	
	
	/**
	 * 用户登录
	 * @param user
	 * @param request
	 * @return String
	 * @throws Exception
	 */
	@RequestMapping("/login")
	public String login(User user, HttpServletRequest request) throws Exception{
		User resultUser = userService.login(user);
		if (resultUser == null) {
			request.setAttribute("user", user);
			request.setAttribute("errorMsg", "用户名或密码错误");
			return "index";
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("currentUser", resultUser);
			return "main";
		}
	}
	
	
	/**
	 * 获取用户角色类型信息
	 * @param pd
	 * @return json
	 * @throws Exception
	 */
	@RequestMapping("/roleList")
	@ResponseBody
	public String roleList(PageData pd) throws Exception{
		Map<String,Object> map=new HashMap<String,Object>();
		List<Map<String,Object>> list = userService.getRole(pd);
		//map.put("list",list);
		return json.toJson(list);
	}
	
	
}
