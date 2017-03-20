package app.controller.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import app.entity.system.Admin;
import app.entity.system.Menu;
import app.entity.system.User;
import app.service.system.AdminService;
import app.service.system.MenuService;


/**
 * 系统登录Controller层
 * @author 李晨
 * @date 2017-02-26
 *
 */
@Controller
@RequestMapping("/system")
public class SystemLoginController {
	@Resource
	private AdminService adminService;
	@Resource
	private MenuService menuService;
	
	/**
	 * 转向管理员登录页面
	 * @param null
	 * @return login.jsp
	 * @throws Exception
	 */
	@RequestMapping("/login_page")
	public ModelAndView login_page(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		ModelAndView mv = new ModelAndView();
		if(session.getAttribute("admin_user") == null){
			mv.setViewName("admin/login");
		}else{
			mv.setViewName("admin/index");
		}
		return mv;
	}
	
	/**
	 * 管理员登录
	 * @param admin
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/login")
	public ModelAndView login(Admin admin, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		ModelAndView mv = new ModelAndView();
		Map<String,Object> result = adminService.login(admin);
		if(result != null){
			mv.setViewName("admin/index");
			session.setAttribute("admin_user", result);
		}else{
			mv.setViewName("admin/login");
		}
		return mv;
	}
	
	/**
	 * 管理员退出
	 * @param admin
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/logout")
	@ResponseBody
	public String logout(HttpServletRequest request) throws Exception {
		String gson = null;
		HttpSession session = request.getSession();
		session.removeAttribute("admin_user");
		if(session.getAttribute("admin_user") == null){
			Gson gs = new Gson();
			gson = gs.toJson("success");
		}
		return gson;
	}
	
	
	/**
	 * 返回主页菜单json数据
	 * @param 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/index_menu")
	@ResponseBody
	public String index_menu(Menu menu) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		Gson json = new Gson();
		try{
			List<Map<String, Object>> result1 = menuService.getMenuChild1(menu);
			List<Map<String, Object>> result2 = menuService.getMenuChild2(menu);
			List<Map<String, Object>> result = menuService.getMenu(menu);
			for(int i = 0;i<result.size();i++){
				if(result.get(i).get("id").equals(1)){
					result.get(i).put("childMenus", result1);
				}else{
					result.get(i).put("childMenus", result2);
				}
			}
			map.put("info", result);
		}catch(Exception e){
			System.out.println(e);
		}finally{
			
		}
		return json.toJson(map);
	}
	
	
}
