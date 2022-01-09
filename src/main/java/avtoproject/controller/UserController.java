package avtoproject.controller;

import avtoproject.dto.user.UserRegistrationDto;
import avtoproject.dto.user.UserDto;
import avtoproject.service.UserService;
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
    public void registration(@RequestBody UserRegistrationDto userRegistrationDto) {
        userService.registrationUser(userRegistrationDto);
    }

    @GetMapping
    public List<UserDto> getList() {

        return userService.getList();
    }


}
