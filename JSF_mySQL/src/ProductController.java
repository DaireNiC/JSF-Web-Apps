import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class ProductController {

	private DAO dao;
	private ArrayList<Product> productList;

	
	public ProductController() throws Exception {
		super();
		this.dao = new DAO();
	}

	public ArrayList<Product> getProductList() {
		return productList;
	}

	public void setProductList(ArrayList<Product> productList) {
		this.productList = productList;
	}
	
	public void addItem(Product p){
		this.productList.add(p);	
	}
	
	public void loadProducts() throws SQLException{
		productList = dao.getProducts();
	}
}
