package gmit.ie;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
@ManagedBean
@SessionScoped 
public class ShoppingCart {
	
	private ArrayList<String> cart;
	private String newItem;
	
	public ShoppingCart() {
		super();
		cart = new ArrayList<String>();
	}
	public ArrayList<String> getCart() {
		return cart;
	}
	public void setCart(ArrayList<String> cart) {
		this.cart = cart;
	}
	public String getNewItem() {
		return newItem;
	}
	public void setNewItem(String newItem) {
		this.newItem = newItem;
	}
	public void addItem() {
		this.cart.add(this.newItem);
	}




}
