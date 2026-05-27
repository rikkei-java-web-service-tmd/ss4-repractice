package com.re.repractice.controller;

import com.re.repractice.common.ApiResponse;
import com.re.repractice.dto.request.UserRequestDto;
import com.re.repractice.dto.response.UserResponseDto;
import com.re.repractice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<ApiResponse<UserResponseDto>> createUser(@RequestBody UserRequestDto userRequestDto) {
        UserResponseDto userResponseDto = userService.createUser(userRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.<UserResponseDto>builder()
                        .code(201)
                        .message("User created successfully")
                        .data(userResponseDto)
                        .build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UserResponseDto>> getUserById(@PathVariable Long id) {
        UserResponseDto userResponseDto = userService.getUserById(id);
        if (userResponseDto == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.<UserResponseDto>builder()
                            .code(404)
                            .message("User not found")
                            .build());
        }
        return ResponseEntity.ok(ApiResponse.<UserResponseDto>builder()
                .code(200)
                .message("User retrieved successfully")
                .data(userResponseDto)
                .build());
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<UserResponseDto>>> getAllUsers() {
        List<UserResponseDto> users = userService.getAllUsers();
        return ResponseEntity.ok(ApiResponse.<List<UserResponseDto>>builder()
                .code(200)
                .message("Users retrieved successfully")
                .data(users)
                .build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<UserResponseDto>> updateUser(
            @PathVariable Long id,
            @RequestBody UserRequestDto userRequestDto) {
        UserResponseDto userResponseDto = userService.updateUser(id, userRequestDto);
        if (userResponseDto == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.<UserResponseDto>builder()
                            .code(404)
                            .message("User not found")
                            .build());
        }
        return ResponseEntity.ok(ApiResponse.<UserResponseDto>builder()
                .code(200)
                .message("User updated successfully")
                .data(userResponseDto)
                .build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok(ApiResponse.<Void>builder()
                .code(200)
                .message("User deleted successfully")
                .build());
    }
}

