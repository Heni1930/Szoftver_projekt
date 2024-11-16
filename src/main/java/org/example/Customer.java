

package org.example;

//import jakarta.persistence.*;
//import jakarta.validation.constraints.Pattern;
//import jakarta.validation.constraints.Size;
//import lombok.*;

import javax.persistence.*;
import java.util.List;


@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
 //   @NotBlank(message = "Username cannot be blank!")
//    @Size(min = 4, max = 20, message = "Username must be between 4 and 20")

    private String username;
//    @NotBlank(message = "Password cannot be blank!")
//    @Size(min = 6, message = "Password must be at least 6 characters long")

    private String password;
//    @NotBlank(message = "Name cannot be empty!")

    private String name;
//    @NotBlank(message = "Email cannot be empty!")
//    @Pattern(regexp = "^[\\w.%+-]+@[\\w.-]+\\.[A-Za-z]{2,6}$", message = "Invalid email format!")

    private String email;
//    @NotBlank(message = "Faculty must be specified!")
//    @Enumerated(EnumType.STRING)

    private Faculties faculty;

    //@OneToMany(mappedBy = "customers", cascade = CascadeType.ALL, orphanRemoval = true)
   // private List<Rental> rentals;


    public Customer(String username, String password, String name, String email, Faculties faculty) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.faculty = faculty;
    }

    public Customer() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Faculties getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculties faculty) {
        this.faculty = faculty;
    }

//    public List<Rental> getRentals() {
//        return rentals;
//    }
//
//    public void setRentals(List<Rental> rentals) {
//        this.rentals = rentals;
//    }
}




