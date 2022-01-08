package avtoProject.service.mapper;

import avtoProject.dto.user.UserDto;
import avtoProject.entity.Role;
import avtoProject.entity.UserAvto;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public UserDto mapUserDto(UserAvto model) {
        return new UserDto(
                model.getId(),
                model.getLogin(),
                model.getPassword(),
                model.getRoles().stream().map(Role::getCode).collect(Collectors.toList())
        );
    }

    public List<UserDto> mapUserDto(Collection<UserAvto> model) {
        return model.stream()
                .map(this::mapUserDto)
                .collect(Collectors.toList());
    }

}
