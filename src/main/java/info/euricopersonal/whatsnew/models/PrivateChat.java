package info.euricopersonal.whatsnew.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Data;


@Entity
@Data
public class PrivateChat extends Chat{

    @OneToOne
    private Contact contact;

}
