

package org.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;


@Entity
public class Customer {
    @Id
    @GeneratedValue
    private int Id;
    private String username;
    private String password;
    private String name;
    private Faculties faculty;

    public Customer(String username, String password, int id, String name, Faculties faculty) {
        this.username = username;
        this.password = password;
        this.Id = id;
        this.name = name;
        this.faculty = faculty;
    }

    public Customer() {

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

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Faculties getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculties faculty) {
        this.faculty = faculty;
    }
}

