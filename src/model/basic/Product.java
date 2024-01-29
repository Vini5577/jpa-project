package model.basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "products", schema = "curso_java")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "prod_name", length = 200, nullable = false)
    private String name;
    @Column(name = "prod_preco", nullable = false, precision = 11, scale = 2)
    private Double preco;

    public Product() {
    }
    
    public Product(Long id, String name, Double preco) {
        this.id = id;
        this.name = name;
        this.preco = preco;
    }
}
