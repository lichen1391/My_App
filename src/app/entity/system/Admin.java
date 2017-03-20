package app.entity.system;

import java.math.BigInteger;

public class Admin {
	private int admin_id;
	private String admin_name;
	private String password;
	private BigInteger phone;
	private int role_id;
	
	public int getadmin_id() {
		return admin_id;
	}
	public void setadmin_id(int admin_id) {
		this.admin_id = admin_id;
	}
	public String getadmin_name() {
		return admin_name;
	}
	public void setadmin_name(String admin_name) {
		this.admin_name = admin_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public BigInteger getPhone() {
		return phone;
	}
	public void setPhone(BigInteger phone) {
		this.phone = phone;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	
	
}
