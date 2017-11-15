package gmit.ie;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
@ManagedBean
@SessionScoped 
public class Counter {
	
	
	public int x;

	public Counter() {
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void incrementX() {
		this.x++;
	}
}
