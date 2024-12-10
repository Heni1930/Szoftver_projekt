

package org.example;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import javax.persistence.*;

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
    @NotBlank(message = "Username cannot be empty!")
    private String username;
    @NotBlank(message = "Password cannot be empty!")
    private String password;
    @NotBlank(message = "Name cannot be empty!")
    private String name;
    @NotBlank(message = "Email cannot be empty!")
    @Pattern(regexp = "^[\\w.%+-]+@[\\w.-]+\\.[A-Za-z]{2,6}$", message = "Invalid email format!")
    private String email;
    @NotNull(message = "Faculty cannot be empty!")
    private Faculties faculty;

    public Customer(String username, String password, String name, String email, Faculties faculty) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.faculty = faculty;    }


}




