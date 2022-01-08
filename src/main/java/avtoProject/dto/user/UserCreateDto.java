package avtoProject.dto.user;

import avtoProject.entity.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Setter
@Getter
public class UserCreateDto {
    private final String login;

    private String password;

    private Set<Role> roles;

    public UserCreateDto(String login, String password, Set<Role> roles) {
        this.login = login;
        this.password = password;
        this.roles = roles;
    }
}
