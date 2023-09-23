package dev.minhnhat.week02_lab_truongduongminhnhat_21028411.backend.models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "orders")
@NamedQueries({
        @NamedQuery(name = "Orders.findAll", query = "SELECT O FROM Orders O"),
        @NamedQuery(name = "Orders.findByID", query = "SELECT O FROM Orders O WHERE O.orderID =:orderID"),
        @NamedQuery(name = "Orders.findByEmployeeID", query = "SELECT O FROM Orders O WHERE O.employeeID =:employeeID"),
        @NamedQuery(name = "Orders.findByCustomerID", query = "SELECT O FROM Orders O WHERE O.customerID =:customerID"),
        @NamedQuery(name = "Orders.findByEmployeeIDAndCustomerID", query = "SELECT O FROM Orders O WHERE O.customerID =:customerID AND O.employeeID =:employeeID"),
})
public class Orders {
    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderID;
    @Column(name = "order_LocalDate")
    private LocalDate orderLocalDate;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employeeID;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customerID;

    public Orders() {
    }

    public Orders(LocalDate orderLocalDate, Employee employeeID, Customer customerID) {
        this.orderLocalDate = orderLocalDate;
        this.employeeID = employeeID;
        this.customerID = customerID;
    }

    public long getOrderID() {
        return orderID;
    }

    public LocalDate getOrderLocalDate() {
        return orderLocalDate;
    }

    public void setOrderLocalDate(LocalDate orderLocalDate) {
        this.orderLocalDate = orderLocalDate;
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
                ", orderLocalDate=" + orderLocalDate +
                ", employeeID=" + employeeID +
                ", customerID=" + customerID +
                '}';
    }
}
