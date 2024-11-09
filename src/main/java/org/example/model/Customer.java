

package org.example.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @NotBlank(message = "Username cannot be blank!")
    @Size(min = 4, max = 20, message = "Username must be between 4 and 20")
    @Column(nullable = false, unique = true)
    private String username;
    @NotBlank(message = "Password cannot be blank!")
    @Size(min = 6, message = "Password must be at least 6 characters long")
    @Column(nullable = false)
    private String password;
    @NotBlank(message = "Name cannot be empty!")
    @Column(nullable = false)
    private String name;
    @NotBlank(message = "Faculty must be specified!")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Faculties faculty;


    public Customer() {}


    public Customer(String username, String password, String name, Faculties faculty) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.faculty = faculty;
    }


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public @NotBlank(message = "Username cannot be blank!") @Size(min = 4, max = 20, message = "Username must be between 4 and 20") String getUsername() {
        return username;
    }

    public void setUsername(@NotBlank(message = "Username cannot be blank!") @Size(min = 4, max = 20, message = "Username must be between 4 and 20") String username) {
        this.username = username;
    }

    public @NotBlank(message = "Password cannot be blank!") @Size(min = 6, message = "Password must be at least 6 characters long") String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank(message = "Password cannot be blank!") @Size(min = 6, message = "Password must be at least 6 characters long") String password) {
        this.password = password;
    }

    public @NotBlank(message = "Name cannot be empty!") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Name cannot be empty!") String name) {
        this.name = name;
    }

    public @NotBlank(message = "Faculty must be specified!") Faculties getFaculty() {
        return faculty;
    }

    public void setFaculty(@NotBlank(message = "Faculty must be specified!") Faculties faculty) {
        this.faculty = faculty;
    }
}




