package com.oshancc.springbootfirstapp.model;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "employees")
public class Employee implements Serializable {

    private long id;
    private String firstName;


    public Employee() {

    }

    public Employee(String firstName, String lastName, String emailId) {
        this.firstName = firstName;

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "first_name", nullable = false)
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }



    @Override
    public String toString() {
        return "Employee [id=" + id + ", firstName=" + firstName +
                 "]";
    }

}
