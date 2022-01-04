package AvtoProject.dto.User;
import lombok.Getter;

import lombok.EqualsAndHashCode;

import java.util.List;

@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class UserDto {


    @EqualsAndHashCode.Include
    private final Integer id;

    private final String login;

    private final String password;

    private final List<String> codes;

    public UserDto(Integer id, String login, String password, List<String> codes) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.codes = codes;
    }
}
