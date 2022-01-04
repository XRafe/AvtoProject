package AvtoProject.controller;

import AvtoProject.dto.User.UserDto;
import AvtoProject.entity.UserAvto;
import AvtoProject.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
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
    public void Registration(UserAvto userAvto) {
        userService.registrationUser(userAvto);
    }

    @GetMapping
    public List<UserDto> getList() {

        return userService.getList();
    }



}
