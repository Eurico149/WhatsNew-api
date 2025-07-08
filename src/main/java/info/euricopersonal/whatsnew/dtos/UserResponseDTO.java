package info.euricopersonal.whatsnew.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {

    private String id;

    private String username;

    private String email;

    private LocalDate birthday;

    private String urlProfilePic;

}
