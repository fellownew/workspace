package stockmarket.vo;

import java.io.Serializable;
import java.util.ArrayList;

public class Investor implements Serializable{
	String id,password,name;
	ArrayList<HaveStock> haveStock;
	public Investor(String id, String password, String name,ArrayList<HaveStock> haveStock) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.haveStock = haveStock;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((haveStock == null) ? 0 : haveStock.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Investor other = (Investor) obj;
		if (haveStock == null) {
			if (other.haveStock != null)
				return false;
		} else if (!haveStock.equals(other.haveStock))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Investor [id=" + id + ", password=" + password + ", name="
				+ name + ", haveStock=" + haveStock + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<HaveStock> getHaveStock() {
		return haveStock;
	}
	public void setHaveStock(ArrayList<HaveStock> haveStock) {
		this.haveStock = haveStock;
	}
}
