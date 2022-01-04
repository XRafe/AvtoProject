package AvtoProject.service.impl;

import AvtoProject.dto.User.UserDto;
import AvtoProject.dto.authorization.UserAuthorizationInfoDto;
import AvtoProject.entity.Role;
import AvtoProject.entity.UserAvto;
import AvtoProject.repository.RoleRepository;
import AvtoProject.repository.UserRepository;
import AvtoProject.service.UserService;
import AvtoProject.service.mapper.UserMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
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

    BCryptPasswordEncoder bCryptPasswordEncoder;

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




    public boolean registrationUser(UserAvto userAvto){
        if (userAvto.getRoles() == null) {
            userAvto.setRoles(Collections.singleton(new Role(2, "user")));
        }
        userAvto.setPassword(bCryptPasswordEncoder.encode(userAvto.getPassword()));
        userRepository.save(userAvto);
        return true;
    }



    @Override
    public  Optional<UserAuthorizationInfoDto> findAuthorizatoinInfo(String login) {
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
