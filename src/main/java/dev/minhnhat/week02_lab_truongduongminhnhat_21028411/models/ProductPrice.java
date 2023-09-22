package dev.minhnhat.week02_lab_truongduongminhnhat_21028411.models;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "product_price")
public class ProductPrice {
    @Id
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product productID;
    @Id
    @Column(name = "product_date_time")
    private Date productDateTime;
    private double price;
    @Column(length = 200)
    private String note;

    public ProductPrice() {
    }

    public ProductPrice(Product productID, Date productDateTime, double price, String note) {
        this.productID = productID;
        this.productDateTime = productDateTime;
        this.price = price;
        this.note = note;
    }

    public Product getProductID() {
        return productID;
    }

    public void setProductID(Product productID) {
        this.productID = productID;
    }

    public Date getProductDateTime() {
        return productDateTime;
    }

    public void setProductDateTime(Date productDateTime) {
        this.productDateTime = productDateTime;
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
                ", productDateTime=" + productDateTime +
                ", price=" + price +
                ", note='" + note + '\'' +
                '}';
    }
}
