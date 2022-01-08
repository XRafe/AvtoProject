package avtoProject.service.impl;

import avtoProject.dto.authorization.UserAuthorizationInfoDto;
import avtoProject.dto.user.UserCreateDto;
import avtoProject.dto.user.UserDto;
import avtoProject.entity.Role;
import avtoProject.entity.UserAvto;
import avtoProject.repository.RoleRepository;
import avtoProject.repository.UserRepository;
import avtoProject.service.UserService;
import avtoProject.service.mapper.UserMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JpaUserService implements UserService {
    public JpaUserService(UserRepository userRepository,
                          UserMapper userMapper,
                          RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.roleRepository = roleRepository;
    }

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private final RoleRepository roleRepository;

    private final UserRepository userRepository;

    private final UserMapper userMapper;

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
    public boolean registrationUser(UserCreateDto userCreateDto) {
        if (userCreateDto.getRoles() == null) {
            userCreateDto.setRoles(Collections.singleton(new Role(2, "user")));
        }
        userCreateDto.setPassword(bCryptPasswordEncoder.encode(userCreateDto.getPassword()));
        UserAvto userAvto = new UserAvto(
                userCreateDto.getLogin(),
                userCreateDto.getPassword(),
                userCreateDto.getRoles()
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
