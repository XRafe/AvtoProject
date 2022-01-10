package avtoproject.service;

import avtoproject.dto.authorization.UserAuthorizationInfoDto;
import avtoproject.dto.user.UserDto;
import avtoproject.dto.user.UserRegistrationDto;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserDto> getList();

    Optional<UserAuthorizationInfoDto> findAuthorizatoinInfo(String login);

    Integer getId(String login);

    boolean registrationUser(UserRegistrationDto userRegistrationDto);


}
