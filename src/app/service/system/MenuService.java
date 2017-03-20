package app.service.system;

import java.util.List;
import java.util.Map;

import app.entity.system.Menu;

public interface MenuService {
	public List<Map<String, Object>> getMenu(Menu menu) throws Exception;
	public List<Map<String, Object>> getMenuChild1(Menu menu) throws Exception;
	public List<Map<String, Object>> getMenuChild2(Menu menu);
}
