package info.euricopersonal.whatsnew.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.*;


@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(unique = true, nullable = false)
    private String email;

    private LocalDate birthday;

    private String urlProfilePic;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Contact> contacts = new HashSet<>();

}