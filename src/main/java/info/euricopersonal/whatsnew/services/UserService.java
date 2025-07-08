package info.euricopersonal.whatsnew.services;

import info.euricopersonal.whatsnew.dtos.UserResponseDTO;
import info.euricopersonal.whatsnew.dtos.UserSignInRequestDTO;
import info.euricopersonal.whatsnew.dtos.UserSignUpRequestDTO;
import info.euricopersonal.whatsnew.exceptions.WhatsNewException;
import info.euricopersonal.whatsnew.models.User;
import info.euricopersonal.whatsnew.repositorys.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    public UserResponseDTO create(UserSignUpRequestDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);

        try {
            User userSaved = userRepository.save(user);
            return modelMapper.map(userSaved, UserResponseDTO.class);
        } catch (DataIntegrityViolationException e) {
            if (userRepository.existsUserByUsername(userDTO.getUsername()))
                throw new ResponseStatusException(HttpStatus.CONFLICT, "Username Already Exists");

            if (userRepository.existsUserByEmail(userDTO.getEmail()))
                throw new ResponseStatusException(HttpStatus.CONFLICT, "Email Already Exists");

            throw new WhatsNewException("Error While Creating User");
        }
    }

    public UserResponseDTO login(UserSignInRequestDTO userDTO) {
        User user = userRepository.findByUsername(userDTO.getUsername());
        if (user != null && user.getPassword().equals(userDTO.getPassword())) {
            return modelMapper.map(user, UserResponseDTO.class);
        }
        return null;
    }
}
