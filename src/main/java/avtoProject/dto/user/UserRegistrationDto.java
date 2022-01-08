package avtoProject.dto.user;

import avtoProject.entity.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
public class UserRegistrationDto {
    private String login;

    private String password;

    public UserRegistrationDto(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
