package AvtoProject.dto.authorization;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class UserAuthorizationInfoDto {

    private final Integer id;

    private final String login;

    private final String password;

    private final Set<String> roleCodes;

    public UserAuthorizationInfoDto(Integer id,
                                    String login,
                                    String password,
                                    Set<String> roleCodes) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.roleCodes = roleCodes;
    }
}
