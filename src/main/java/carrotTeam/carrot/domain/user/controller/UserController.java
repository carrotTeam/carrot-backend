package carrotTeam.carrot.domain.user.controller;

import carrotTeam.carrot.domain.user.dto.UserCreateRequest;
import carrotTeam.carrot.domain.user.dto.UserInfo;
import carrotTeam.carrot.domain.user.dto.UserUpdateRequest;
import carrotTeam.carrot.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/api/UserId/{id}")
    public ResponseEntity getUser(@PathVariable("id") Long id){
        UserInfo userInfo = userService.findUserId(id);
        return ResponseEntity.ok(userInfo);
    }

    @PutMapping("/api/User/Change")
    public ResponseEntity updateUser(@Valid @RequestBody UserUpdateRequest request){
        UserInfo userInfo = userService.updateUser(request);
        return ResponseEntity.ok(userInfo);
    }

    @DeleteMapping("/api/User/Delete/{id}")
    public ResponseEntity deleteUser(@PathVariable("id") Long id){
        UserInfo userInfo = userService.DeleteUser(id);
        return  ResponseEntity.ok(userInfo);
    }


}
