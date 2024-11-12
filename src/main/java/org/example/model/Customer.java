

package org.example.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"rentals"})
@EqualsAndHashCode
@Entity
@Table
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @NotBlank(message = "Username cannot be blank!")
    @Size(min = 4, max = 20, message = "Username must be between 4 and 20")
    @Column(name = "username",nullable = false, unique = true)
    private String username;
    @NotBlank(message = "Password cannot be blank!")
    @Size(min = 6, message = "Password must be at least 6 characters long")
    @Column(name = "password", nullable = false)
    private String password;
    @NotBlank(message = "Name cannot be empty!")
    @Column(name = "name",nullable = false)
    private String name;
    @NotBlank(message = "Email cannot be empty!")
    @Pattern(regexp = "^[\\w.%+-]+@[\\w.-]+\\.[A-Za-z]{2,6}$", message = "Invalid email format!")
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @NotBlank(message = "Faculty must be specified!")
    @Enumerated(EnumType.STRING)
    @Column(name = "faculty", nullable = false)
    private Faculties faculty;

    @OneToMany(mappedBy = "customers", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Rental> rentals;


    public Customer(String username, String password, String name, String email, Faculties faculty) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.faculty = faculty;
    }
}




