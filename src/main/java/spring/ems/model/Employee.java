package spring.ems.model;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
    // Fields
    @Id
    @Column
    private long id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String title;
    @Column
    private String department;
    @Column
    private String email;

    // Default constructor
    public Employee() {

    }

    // Parameterized constructor
    public Employee(long id, String firstName, String lastName, String title,
                    String department, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.department = department;
        this.email = email;
    }

    // Getter and Setter Methods
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    @Column(name = "first_name", nullable = false)
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    @Column(name = "last_name", nullable = false)
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    @Column(name = "title", nullable = false)
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    @Column(name = "department", nullable = false)
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    @Column(name = "email", nullable = false)
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    // toString() Method
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", title='" + title + '\'' +
                ", department='" + department + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
