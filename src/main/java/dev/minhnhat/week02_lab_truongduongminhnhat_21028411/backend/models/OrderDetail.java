package dev.minhnhat.week02_lab_truongduongminhnhat_21028411.backend.models;

import jakarta.persistence.*;

@Entity
@Table(name = "order_detail")
@NamedQueries({
        @NamedQuery(name = "OrderDetail.findAll", query = "SELECT OD FROM OrderDetail OD"),
        @NamedQuery(name = "OrderDetail.findByID", query = "SELECT OD FROM OrderDetail OD WHERE OD.orderID =:orderID AND OD.productID =:productID"),
        @NamedQuery(name = "OrderDetail.findByOrderID", query = "SELECT OD FROM OrderDetail OD WHERE OD.orderID =:orderID"),
        @NamedQuery(name = "OrderDetail.findByProductID", query = "SELECT OD FROM OrderDetail OD WHERE OD.productID =:productID"),
})
public class OrderDetail {
    @Id
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders orderID;
    @Id
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product productID;
    private int quantity;
    private double price;
    @Column(length = 200)
    private String note;

    public OrderDetail() {
    }

    public OrderDetail(Orders orderID, Product productID, int quantity, double price, String note) {
        this.orderID = orderID;
        this.productID = productID;
        this.quantity = quantity;
        this.price = price;
        this.note = note;
    }

    public Orders getOrderID() {
        return orderID;
    }

    public void setOrderID(Orders orderID) {
        this.orderID = orderID;
    }

    public Product getProductID() {
        return productID;
    }

    public void setProductID(Product productID) {
        this.productID = productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
        return "OrderDetail{" +
                "orderID=" + orderID +
                ", productID=" + productID +
                ", quantity=" + quantity +
                ", price=" + price +
                ", note='" + note + '\'' +
                '}';
    }
}
