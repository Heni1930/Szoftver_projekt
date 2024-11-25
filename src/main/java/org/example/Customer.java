

package org.example;

//import jakarta.persistence.*;
//import jakarta.validation.constraints.Pattern;
//import jakarta.validation.constraints.Size;
//import lombok.*;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    //@NonNull(message = "Username cannot be null")
    private String username;
    @Basic(optional = false)
    private String password;
    @Basic(optional = false)
    private String name;
    @Basic(optional = false)
    private String email;
    @Basic(optional = false)
    private Faculties faculty;

    public Customer(String username, String password, String name, String email, Faculties faculty) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.faculty = faculty;    }


}




