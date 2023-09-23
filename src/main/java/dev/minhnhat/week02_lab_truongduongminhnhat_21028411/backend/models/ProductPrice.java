package dev.minhnhat.week02_lab_truongduongminhnhat_21028411.backend.models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "product_price")
@NamedQueries({
        @NamedQuery(name = "ProductPrice.findByProductID", query = "SELECT PP FROM ProductPrice PP WHERE PP.productID =:productID"),
        @NamedQuery(name = "ProductPrice.findByLocalDateTime", query = "SELECT PP FROM ProductPrice PP WHERE PP.productLocalDateTime =:productLocalDateTime"),
        @NamedQuery(name = "ProductPrice.findAll", query = "SELECT PP FROM ProductPrice PP")
})
public class ProductPrice {
    @Id
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product productID;
    @Id
    @Column(name = "product_LocalDate_time")
    private LocalDate productLocalDateTime;
    private double price;
    @Column(length = 200)
    private String note;

    public ProductPrice() {
    }

    public ProductPrice(Product productID, LocalDate productLocalDateTime, double price, String note) {
        this.productID = productID;
        this.productLocalDateTime = productLocalDateTime;
        this.price = price;
        this.note = note;
    }

    public Product getProductID() {
        return productID;
    }

    public void setProductID(Product productID) {
        this.productID = productID;
    }

    public LocalDate getProductLocalDateTime() {
        return productLocalDateTime;
    }

    public void setProductLocalDateTime(LocalDate productLocalDateTime) {
        this.productLocalDateTime = productLocalDateTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "ProductPrice{" +
                "productID=" + productID +
                ", productLocalDateTime=" + productLocalDateTime +
                ", price=" + price +
                ", note='" + note + '\'' +
                '}';
    }
}
