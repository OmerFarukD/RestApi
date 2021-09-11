package teknosa.store.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="products")
public class Product {
@Column(name="product_id")
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int productId;
@Column(name="product_name")
private String productName;
@Column(name="unit_price")
private double unitPrice;
@Column(name="product_features")
private String productFeatures;

@ManyToOne
@JoinColumn(name="category_id")
Category category;
}
