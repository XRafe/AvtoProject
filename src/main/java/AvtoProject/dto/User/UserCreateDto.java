package AvtoProject.dto.User;

import lombok.Getter;

import java.util.List;


@Getter
public class UserCreateDto {
    private final String login;

    private final String password;

    private final List<String> codes;

    public UserCreateDto(String login, String password, List<String> codes) {
        this.login = login;
        this.password = password;
        this.codes = codes;
    }
}
