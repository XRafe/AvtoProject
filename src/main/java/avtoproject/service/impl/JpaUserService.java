package avtoproject.service.impl;

import avtoproject.dto.authorization.UserAuthorizationInfoDto;
import avtoproject.dto.user.UserDto;
import avtoproject.dto.user.UserRegistrationDto;
import avtoproject.entity.Role;
import avtoproject.entity.UserAvto;
import avtoproject.repository.RoleRepository;
import avtoproject.repository.UserRepository;
import avtoproject.service.UserService;
import avtoproject.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JpaUserService implements UserService  {

    private final PasswordEncoder encoder;

    private final RoleRepository roleRepository;

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public JpaUserService(PasswordEncoder encoder, RoleRepository roleRepository, UserRepository userRepository, UserMapper userMapper) {
        this.encoder = encoder;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public Integer getId(String login) {

        return userRepository.findOneByLogin(login).getId();
    }


    @Override
    public List<UserDto> getList() {
        List<UserAvto> users = userRepository.findAll();
        return userMapper.mapUserDto(users);
    }


    @Transactional
    @Override
    public boolean registrationUser(UserRegistrationDto userRegistrationDto) {

      UserAvto userAvto = new UserAvto(
              userRegistrationDto.getLogin(),
              encoder.encode(userRegistrationDto.getPassword()),
              Collections.singleton(new Role(2, "user"))
        );
      userRepository.save(userAvto);
      return true;
    }


    @Override
    public Optional<UserAuthorizationInfoDto> findAuthorizatoinInfo(String login) {
        Optional<UserAvto> userOpt = userRepository.findOneWithRolesByLogin(login);

        if (userOpt.isPresent()) {
            UserAvto user = userOpt.get();
            return Optional.of(new UserAuthorizationInfoDto(
                    user.getId(),
                    user.getLogin(),
                    user.getPassword(),
                    user.getRoles().stream().map(Role::getCode).collect(Collectors.toSet())
            ));
        } else {
            return Optional.empty();
        }
    }

}
