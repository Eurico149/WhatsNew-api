package info.euricopersonal.whatsnew.dtos;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSignUpRequestDTO {

    @NotBlank(message = "Username Is Required")
    private String username;

    @NotBlank(message = "Password Is Required")
    private String password;

    @NotBlank(message = "Email Is Required")
    @Email(message = "Invalid Email")
    private String email;

    @Nullable
    private LocalDate birthday;

    @Nullable
    private String urlProfilePic;

}
