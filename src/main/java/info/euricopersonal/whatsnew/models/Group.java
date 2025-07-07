package info.euricopersonal.whatsnew.models;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;


@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Group extends Chat{

    private String name;

    private String description;

    private String urlPic;

    @ManyToOne
    private User adm;

    @ManyToMany
    private Set<User> users = new HashSet<>();
}
