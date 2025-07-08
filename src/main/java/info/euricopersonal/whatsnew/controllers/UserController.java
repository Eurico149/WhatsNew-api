package info.euricopersonal.whatsnew.controllers;


import info.euricopersonal.whatsnew.dtos.UserResponseDTO;
import info.euricopersonal.whatsnew.dtos.UserSignInRequestDTO;
import info.euricopersonal.whatsnew.dtos.UserSignUpRequestDTO;
import info.euricopersonal.whatsnew.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/sign-up")
    public ResponseEntity<UserResponseDTO> singUp(
            @RequestBody @Valid UserSignUpRequestDTO userDTO
    ){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userService.create(userDTO));
    }

    @PostMapping("/sign-in")
    public ResponseEntity<UserResponseDTO> signIn(
            @RequestBody @Valid UserSignInRequestDTO userDTO
    ){
        UserResponseDTO response = userService.login(userDTO);

        if (response == null)
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .build();

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userService.login(userDTO));
    }
}
