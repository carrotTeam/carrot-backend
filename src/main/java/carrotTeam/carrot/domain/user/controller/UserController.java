package carrotTeam.carrot.domain.user.controller;

import carrotTeam.carrot.domain.user.dto.UserCreateRequest;
import carrotTeam.carrot.domain.user.dto.UserInfo;
import carrotTeam.carrot.domain.user.dto.UserUpdateRequest;
import carrotTeam.carrot.domain.user.service.UserService;
import carrotTeam.carrot.global.result.ResultCode;
import carrotTeam.carrot.global.result.ResultResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping("/api/Users")
    private ResponseEntity<ResultResponse> createUser(@Valid @RequestBody UserCreateRequest request) {

        UserInfo userInfo = userService.createUser(request);
        return ResponseEntity.ok(ResultResponse.of(ResultCode.CREATE_USER_SUCCESS,userInfo));
    }

    @GetMapping("/api/Users/{id}")
    public ResponseEntity<ResultResponse> getUser(@PathVariable("id") Long id){
        UserInfo userInfo = userService.findUserId(id);
        return ResponseEntity.ok(ResultResponse.of(ResultCode.GET_ONE_POST_USER_SUCCESS, userInfo));
    }

    @PutMapping("/api/Users")
    public ResponseEntity<ResultResponse> updateUser(@Valid @RequestBody UserUpdateRequest request){
        UserInfo userInfo = userService.updateUser(request);
        return ResponseEntity.ok(ResultResponse.of(ResultCode.PUT_USER_SUCCESS, userInfo));
    }

    @DeleteMapping("/api/Users/{id}")
    public ResponseEntity<ResultResponse> deleteUser(@PathVariable("id") Long id){
        UserInfo userInfo = userService.DeleteUser(id);
        return ResponseEntity.ok(ResultResponse.of(ResultCode.DELETE_USER_SUCCESS, userInfo));
    }






}
