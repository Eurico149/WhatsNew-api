package info.euricopersonal.whatsnew.models;

import info.euricopersonal.whatsnew.enums.StatusMessage;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;


@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "chat_id")
    private Chat chat;

    private Timestamp date;

    @OneToOne
    private Content content;

    @Enumerated(EnumType.STRING)
    private StatusMessage status;
}
