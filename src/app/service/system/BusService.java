package app.service.system;

import java.util.List;
import java.util.Map;

import app.entity.system.PageData;

public interface BusService {
	
	/**
	 * 获取列表
	 * @param 
	 * @return json列表
	 * @author 李 晨
	 * @date 2017-03-12
	 */

	public List<Map<String, Object>> getAll(PageData pd);

	public int getAll_count(PageData pd);
}
