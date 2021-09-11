package teknosa.store.dataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import teknosa.store.entity.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {
List<Product> getByProductName(String productName);
List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);
List<Product> getByProductNameAndCategory_CategoryId(String productName, int categoryId);
List<Product> getByProductId(int productId);
}
