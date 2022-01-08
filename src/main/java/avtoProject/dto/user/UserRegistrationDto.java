package avtoProject.dto.user;

import avtoProject.entity.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
public class UserRegistrationDto {
    private final String login;

    private String password;

    public UserRegistrationDto(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
