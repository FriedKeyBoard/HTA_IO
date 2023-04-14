package sample09;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

	private List<Product> products = new ArrayList<>();
	
	public ProductRepository() {
		try {
			String path = "src/sample09/products.txt";
			BufferedReader br = new BufferedReader(new FileReader(path));
			String text = null;
			while((text = br.readLine()) != null) {
				if(text.isBlank()) {
					break;
				}
				Product product = Product.createProduct(text);
				products.add(product);
			}
			br.close();
		}catch(IOException ex) {
			throw new RuntimeException("products.txt 읽기 오류", ex);
		}
	}
	/*
	 * 모든 상품정보를 반환한다.
	 * 	반환타입 : List<Product>
	 * 	메소드이름 : getProducts
	 * 	매개변수 : 없음
	 */
	public List<Product> getProducts(){
		return products;
	}
	
	/*
	 * 상품번호를 전달받아서 상품번호와 일치하는 상품정보를 반환한다.
	 * 	반환타입 : Product
	 * 	메소드이름 : getProductByNo
	 * 	매개변수 : int no
	 */
	
	public Product getProductByNo(int no) {
		for (Product product : products) {
			if(product.getNo() == no) {
				return product;
			}
		}
		return null;
	}
}
