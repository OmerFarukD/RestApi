package teknosa.store.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import teknosa.store.business.abstracts.ProductService;
import teknosa.store.core.utilities.results.DataResult;

import teknosa.store.entity.Product;

@RestController
@RequestMapping("/api/product")
public class ProductController {
@Autowired
public ProductController(ProductService productService) {
this.productService = productService;
}
	private ProductService productService;
	
	@GetMapping("/getByProductName")
	public DataResult<List<Product>> getByProductName(String productName){
		return this.productService.getByProductName(productName);
	}
	@GetMapping("/getByProductNameOrCategory_CategoryId")
	public DataResult<List<Product>> getByProductNameOrCategory_CategoryId(String productName, int categoryId){
		return this.productService.getByProductNameOrCategory_CategoryId(productName, categoryId);
	}
	
}
