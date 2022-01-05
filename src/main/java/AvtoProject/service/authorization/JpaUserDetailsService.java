package AvtoProject.service.authorization;

import AvtoProject.dto.authorization.UserAuthorizationInfoDto;
import AvtoProject.entity.UserAvto;
import AvtoProject.repository.UserRepository;
import AvtoProject.service.UserService;
import lombok.var;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class JpaUserDetailsService implements UserDetailsService{
    private static final String EX_MSG_TMPL_USER_NOT_FOUND = "[login = %s] Пользователь не найден";

    private final UserService userService;

    private final UserRepository userRepository;

    public JpaUserDetailsService(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var userInfo = userService.findAuthorizatoinInfo(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format(EX_MSG_TMPL_USER_NOT_FOUND, username)));

        return User.builder()
                .username(userInfo.getLogin())
                .password(userInfo.getPassword())
                .roles(userInfo.getRoleCodes().toArray(new String[0]))
                .build();
    }





}
