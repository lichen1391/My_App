package app.customClass;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

/**
 * 验证码
 * @author 李 晨
 * return json
 * @date 2017-03-07
 */
@Controller
@RequestMapping("custom")
public class ValidateCode {
	
	@RequestMapping("/validate_code")
	@ResponseBody
	public String validate_code(HttpServletRequest request){
		ArrayList<Object> list = new ArrayList<Object>();
		for(int i = 0;i < 4;i++){
			if((int)(Math.random()*10)%2 == 0){
				list.add((int)(Math.random()*10));
			}else{
				list.add((char)((int)(Math.random()*25+97)));
			}
			
		}
		HttpSession session = request.getSession();
		session.removeAttribute("validate");
		session.setAttribute("validate",list);
		Gson gs = new Gson();
		String json = gs.toJson(list);
		return json;
	}
	
	@RequestMapping("/validate")
	@ResponseBody
	public int validate(String code,HttpServletRequest request){
		int result = 0;
		if(code == null){
			code = "0";
		}
		HttpSession session = request.getSession();
		ArrayList list = (ArrayList) session.getAttribute("validate");
		String validate = "";
		for(int i=0;i<list.size();i++){
			validate += list.get(i).toString();
		}
		if(code.equals(validate)){
			result = 1;
		}
		return result;
	}
	
}
