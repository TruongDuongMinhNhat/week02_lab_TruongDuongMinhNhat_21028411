package dev.minhnhat.week02_lab_truongduongminhnhat_21028411.models;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderID;
    @Column(name = "order_date")
    private Date orderDate;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employeeID;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customerID;

    public Orders() {
    }

    public Orders(Date orderDate, Employee employeeID, Customer customerID) {
        this.orderDate = orderDate;
        this.employeeID = employeeID;
        this.customerID = customerID;
    }

    public long getOrderID() {
        return orderID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Employee getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Employee employeeID) {
        this.employeeID = employeeID;
    }

    public Customer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Customer customerID) {
        this.customerID = customerID;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderID=" + orderID +
                ", orderDate=" + orderDate +
                ", employeeID=" + employeeID +
                ", customerID=" + customerID +
                '}';
    }
}
