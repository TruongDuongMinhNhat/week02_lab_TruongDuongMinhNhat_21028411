package dev.minhnhat.week02_lab_truongduongminhnhat_21028411.models;

import jakarta.persistence.*;

@Entity
@Table(name = "product_image")
public class ProductImage {
    @Id
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product productID;
    @Id
    @Column(name = "image_id")
    private long imageID;
    @Column(length = 100, nullable = false)
    private String path;
    @Column(length = 200, nullable = true)
    private String alternative;

    public ProductImage() {
    }

    public ProductImage(Product productID, String path, String alternative) {
        this.productID = productID;
        this.path = path;
        this.alternative = alternative;
    }

    public Product getProductID() {
        return productID;
    }

    public void setProductID(Product productID) {
        this.productID = productID;
    }

    public long getImageID() {
        return imageID;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getAlternative() {
        return alternative;
    }

    public void setAlternative(String alternative) {
        this.alternative = alternative;
    }

    @Override
    public String toString() {
        return "ProductImage{" +
                "productID=" + productID +
                ", imageID=" + imageID +
                ", path='" + path + '\'' +
                ", alternative='" + alternative + '\'' +
                '}';
    }
}
