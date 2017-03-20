package app.entity.system;

/**
 * 分页数据
 * @param 
 * @param map
 * @return
 * @throws Exception
 */

public class PageData {
	private int page;
	private int rows;
	private String sort;
	private String order;
	private int start;
	private String search;
	private String search_value;
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public int getStart(){
		return start;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public String getSearch_value() {
		return search_value;
	}
	public void setSearch_value(String search_value) {
		this.search_value = search_value;
	}
	
	
	/**
	 * 获取json分页的数据条数
	 * @param start 
	 * @param int page 页数
	 * @param int rows 每页数据个数
	 * @return start 开始
	 * @throws Exception
	 */
	public void setStart(int page,int rows, int start){
		if(page >= 1 && rows >= 1){
			start = (page-1)*rows;
		}		
		this.start =  start;
	}
	
	
}
