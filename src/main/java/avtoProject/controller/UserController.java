package avtoProject.controller;

import avtoProject.dto.user.UserCreateDto;
import avtoProject.dto.user.UserDto;
import avtoProject.entity.UserAvto;
import avtoProject.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {

        this.userService = userService;
    }

    @PostMapping
    public void Registration(@RequestBody UserCreateDto userCreateDto) {
        userService.registrationUser(userCreateDto);
    }

    @GetMapping
    public List<UserDto> getList() {

        return userService.getList();
    }


}
