package app.dao.system;

import java.util.List;
import java.util.Map;

import app.entity.system.PageData;

public interface BusDao {

	public List<Map<String, Object>> getAll(PageData pd);

	public int getAll_count(PageData pd);
	
}
