package app.customClass;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


/**
 * 登录拦截器
 * @author 李 晨
 * @date 2017-03-05
 * 
 */
public class LoginInterceptor implements HandlerInterceptor {
	
	protected Logger log = Logger.getLogger(getClass());

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
//		Admin admin = (Admin) session.getAttribute("admin_user");
		
		//设置不登录允许访问的地址
		String[] urls = new String[]{"system/login_page","system/login","custom/validate"};
		
		//获取请求的url地址
		String url = request.getRequestURL().toString();
		
		//判断请求地址是否在允许访问的地址之中
		for(String u : urls){
			if(url.contains(u)){
				return true;
			}
		}
		
		//System.out.println(session.getAttribute("admin_user"));
		//判断是否存在session
		if(session.getAttribute("admin_user") != null){
			return true;
		}
		
		response.sendRedirect(request.getContextPath()+"/system/login_page");
		//session.setAttribute("unLoginMsg", "请先登录");
		return false;
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object obj, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object obj, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
