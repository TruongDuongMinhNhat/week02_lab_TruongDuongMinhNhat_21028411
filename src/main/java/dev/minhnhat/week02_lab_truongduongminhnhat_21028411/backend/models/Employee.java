package dev.minhnhat.week02_lab_truongduongminhnhat_21028411.backend.models;

import dev.minhnhat.week02_lab_truongduongminhnhat_21028411.backend.enums.EmployeeStatus;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "employee")
@NamedQueries({
    @NamedQuery(name = "Employee.findByID", query = "SELECT E FROM Employee E WHERE E.id =:id"),
    @NamedQuery(name = "Employee.findAll", query = "SELECT E FROM Employee E")
})
public class Employee {
    @Id
    @Column(name = "emp_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "full_name", length = 100, nullable = false)
    private String fullName;
    private LocalDate dob;
    @Column(length = 200)
    private String email;
    @Column(length = 15, nullable = false, unique = true)
    private String phone;
    @Column(length = 200, nullable = false)
    private String address;
    @Enumerated(EnumType.ORDINAL)
    private EmployeeStatus status;

    public Employee() {
    }

    public Employee(String fullName, LocalDate dob, String email, String phone, String address, EmployeeStatus status) {
        this.fullName = fullName;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.status = status;
    }

    public long getId() {
        return id;
    }
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public EmployeeStatus getStatus() {
        return status;
    }

    public void setStatus(EmployeeStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", status=" + status +
                '}';
    }
}
