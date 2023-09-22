package dev.minhnhat.week02_lab_truongduongminhnhat_21028411.models;

import dev.minhnhat.week02_lab_truongduongminhnhat_21028411.enums.ProductStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long produceID;
    @Column(length = 100, nullable = false)
    private String name;
    @Column(length = 200)
    private String description;
    private int unit;
    @Column(name = "manufaturer_name", length = 100, nullable = false)
    private String manufaturerName;
    @Enumerated(EnumType.ORDINAL)
    private ProductStatus status;

    public Product() {
    }

    public Product(String name, String description, int unit, String manufaturerName, ProductStatus status) {
        this.name = name;
        this.description = description;
        this.unit = unit;
        this.manufaturerName = manufaturerName;
        this.status = status;
    }

    public long getId() {
        return produceID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public String getManufaturerName() {
        return manufaturerName;
    }

    public void setManufaturerName(String manufaturerName) {
        this.manufaturerName = manufaturerName;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + produceID +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", unit=" + unit +
                ", manufaturerName='" + manufaturerName + '\'' +
                ", status=" + status +
                '}';
    }
}
