package teknosa.store.business.abstracts;

import java.util.List;

import teknosa.store.core.utilities.results.DataResult;
import teknosa.store.core.utilities.results.Result;
import teknosa.store.entity.Product;

public interface ProductService {
	Result add(Product product);
DataResult<List<Product>> getByProductName(String productName);
DataResult<List<Product>> getByProductNameOrCategory_CategoryId(String productName, int categoryId);
DataResult<List<Product>> getByProductNameAndCategory_CategoryId(String productName, int categoryId);
DataResult<List<Product>> getByProductId(int productId);
}
