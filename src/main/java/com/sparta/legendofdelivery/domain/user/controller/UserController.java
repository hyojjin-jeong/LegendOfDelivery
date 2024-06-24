package com.sparta.legendofdelivery.domain.user.controller;

import com.sparta.legendofdelivery.domain.user.dto.*;
import com.sparta.legendofdelivery.domain.user.service.UserService;
import com.sparta.legendofdelivery.global.dto.DataResponse;
import com.sparta.legendofdelivery.global.dto.MessageResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users/signup")
    public ResponseEntity<MessageResponse> signup(@Valid @RequestBody UserSignupRequestDto requestDto) {

        MessageResponse response = userService.signup(requestDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/users/logout")
    public ResponseEntity<Void> logout() {

        userService.logout();

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/users/withdrawal")
    public ResponseEntity<Void> withdrawal(@Valid @RequestBody UserWithdrawalRequestDto requestDto) {

        userService.withdrawal(requestDto);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/users/token/refresh")
    public ResponseEntity<MessageResponse> refreshToken(HttpServletRequest request) {

        HttpHeaders headers = userService.refreshToken(request);
        MessageResponse response = new MessageResponse(200, "토큰 재발급에 성공했습니다.");

        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(response);
    }

    @PutMapping("/users/role")
    public ResponseEntity<MessageResponse> updateUserRole() {

        MessageResponse response = userService.updateUserRole();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/profile")
    public ResponseEntity<DataResponse<UserProfileResponseDto>> getProfile() {

        DataResponse<UserProfileResponseDto> response = userService.getProfile();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PatchMapping("/profile")
    public ResponseEntity<DataResponse<UserProfileResponseDto>> modifyProfile(@Valid @RequestBody UserProfileModifyRequestDto requestDto) {

        DataResponse<UserProfileResponseDto> response = userService.modifyProfile(requestDto);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/profile/password")
    public ResponseEntity<MessageResponse> updatePassword(@Valid @RequestBody UserProfileUpdatePasswordRequestDto requestDto) {

        MessageResponse response = userService.updatePassword(requestDto);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
