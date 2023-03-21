package carrotTeam.carrot.domain.user.controller;

import carrotTeam.carrot.domain.user.dto.UserCreateRequest;
import carrotTeam.carrot.domain.user.dto.UserInfo;
import carrotTeam.carrot.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping("/api/Users")
    private ResponseEntity createUser(@Valid @RequestBody UserCreateRequest request) {

        UserInfo userInfo = userService.createUser(request);
        return ResponseEntity.ok(userInfo);
    }

}
