package info.euricopersonal.whatsnew.repositorys;

import info.euricopersonal.whatsnew.models.User;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, String> {

    boolean existsUserByUsername(String username);

    boolean existsUserByEmail(String email);

    User findByUsername(String username);
}

