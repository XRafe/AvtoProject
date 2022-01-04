package AvtoProject.service;

import AvtoProject.dto.User.UserDto;
import AvtoProject.dto.authorization.UserAuthorizationInfoDto;
import AvtoProject.entity.UserAvto;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

import java.util.List;

public interface UserService {

    List<UserDto> getList();

    Optional<UserAuthorizationInfoDto> findAuthorizatoinInfo(String login);

    Integer getId(String login);

    boolean registrationUser(UserAvto userAvto);


}
