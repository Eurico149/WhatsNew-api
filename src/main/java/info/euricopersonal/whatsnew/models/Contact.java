package info.euricopersonal.whatsnew.models;

import info.euricopersonal.whatsnew.enums.StatusContact;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Contact {

    @EmbeddedId
    private ContactId id;

    @MapsId("userId")
    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @MapsId("userContactId")
    @JoinColumn(name = "user_contact_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User userContact;

    @Enumerated(EnumType.STRING)
    private StatusContact status;

    private boolean blocked;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private PrivateChat privateChat;
}
