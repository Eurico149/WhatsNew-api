package info.euricopersonal.whatsnew.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSignInRequestDTO {

    @NotBlank(message = "Username Is Required")
    private String username;

    @NotBlank(message = "Password Is Required")
    private String password;

}
