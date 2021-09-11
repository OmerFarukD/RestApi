package teknosa.store.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="categories")
public class Category {
@Id
@Column(name="category_id")
private int categoryId;
@Column(name="category_name")
private String categoryName;

@OneToMany(mappedBy = "category")
List<Product> products;
}