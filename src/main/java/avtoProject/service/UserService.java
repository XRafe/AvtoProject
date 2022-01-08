package avtoProject.service;

import avtoProject.dto.authorization.UserAuthorizationInfoDto;
import avtoProject.dto.user.UserCreateDto;
import avtoProject.dto.user.UserDto;
import avtoProject.entity.UserAvto;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserDto> getList();

    Optional<UserAuthorizationInfoDto> findAuthorizatoinInfo(String login);

    Integer getId(String login);

    boolean registrationUser(UserCreateDto userCreateDto);


}
