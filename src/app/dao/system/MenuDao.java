package app.dao.system;

import java.util.List;
import java.util.Map;

import app.entity.system.Menu;

public interface MenuDao {
	public List<Map<String, Object>> getMenu(Menu menu);
	public List<Map<String, Object>> getMenuChild1(Menu menu);
	public List<Map<String, Object>> getMenuChild2(Menu menu);
	
}
