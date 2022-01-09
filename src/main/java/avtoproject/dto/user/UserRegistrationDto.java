package avtoproject.dto.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


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
