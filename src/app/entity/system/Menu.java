package app.entity.system;

public class Menu {
	private int id;
	private String name;
	private int parentId;
	private String url;
	private String icon;
	private int order;
	private int isHeader;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public int getIsHeader() {
		return isHeader;
	}
	public void setIsHeader(int isHeader) {
		this.isHeader = isHeader;
	}
	
	
}
