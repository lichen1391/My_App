package app.controller.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;

import app.entity.system.PageData;
import app.service.system.BusService;

@Controller
@RequestMapping("/bus")
public class BusinessController {
	@Resource
	private BusService busService;
	
	
	/**
	 * 转向本页面
	 * @param null
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/bus_list")
	public String bus_list() throws Exception {
		return "admin/bus_list";
	}
	
	/**
	 * 用户列表
	 * @param 
	 * @param map
	 * @return
	 * @throws Exception
	 * @author 李 晨
	 * @date 2017-03-12
	 */
	@RequestMapping("/list")
	@ResponseBody
	public Map<String,Object> list(PageData pd) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		pd.setStart(pd.getPage(), pd.getRows(), 0);
		List<Map<String,Object>> list = busService.getAll(pd);
		int count = busService.getAll_count(pd);
		map.put("total", count);
		map.put("rows", list);
		return map;
	}
	
}
