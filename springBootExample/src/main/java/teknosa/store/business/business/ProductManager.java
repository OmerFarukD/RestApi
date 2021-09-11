package teknosa.store.business.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import teknosa.store.business.abstracts.ProductService;
import teknosa.store.core.utilities.results.DataResult;
import teknosa.store.core.utilities.results.Result;
import teknosa.store.core.utilities.results.SuccessDataResult;
import teknosa.store.core.utilities.results.SuccessResult;
import teknosa.store.dataAccess.ProductDao;
import teknosa.store.entity.Product;
@Service
public class ProductManager implements ProductService {
@Autowired
public ProductManager(ProductDao productDao) {
		this.productDao = productDao;
	}
private ProductDao productDao;
@Override
public DataResult<List<Product>> getByProductName(String productName) {
	
	return new SuccessDataResult<List<Product>>(this.productDao.getByProductName(productName));
}
@Override
public DataResult<List<Product>> getByProductNameOrCategory_CategoryId(String productName, int categoryId) {
	
	return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameOrCategory_CategoryId(productName, categoryId));
}
@Override
public DataResult<List<Product>> getByProductNameAndCategory_CategoryId(String productName, int categoryId) {

	return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameAndCategory_CategoryId(productName, categoryId));
}
@Override
public DataResult<List<Product>> getByProductId(int productId) {

	return new SuccessDataResult<List<Product>>(this.productDao.getByProductId(productId));
}
@Override
public Result add(Product product) {
	this.productDao.save(product);
	return new SuccessResult("başarıyla eklendi");
}


}
