package info.euricopersonal.whatsnew.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Content {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String text;
}
