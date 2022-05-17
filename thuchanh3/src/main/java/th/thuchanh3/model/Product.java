package th.thuchanh3.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @Column(name = "code")
    private String code;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private Double price;
    public Product() {
    }
    public Product(String code, String description, Double price) {
        this.code = code;
        this.description = description;
        this.price = price;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }

    
}
