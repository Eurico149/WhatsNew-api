package info.euricopersonal.whatsnew.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;


@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(unique = true, nullable = false)
    private String email;

    private Date birthday;

    private String urlProfilePic;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Contact> contacts = new HashSet<>();

}