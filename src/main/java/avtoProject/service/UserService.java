package avtoProject.service;

import avtoProject.dto.authorization.UserAuthorizationInfoDto;
import avtoProject.dto.user.UserRegistrationDto;
import avtoProject.dto.user.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserDto> getList();

    Optional<UserAuthorizationInfoDto> findAuthorizatoinInfo(String login);

    Integer getId(String login);

    boolean registrationUser(UserRegistrationDto userRegistrationDto);


}
