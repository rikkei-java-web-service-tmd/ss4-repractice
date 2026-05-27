package com.re.repractice.mapper;

import com.re.repractice.dto.request.UserRequestDto;
import com.re.repractice.dto.response.UserResponseDto;
import com.re.repractice.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {
    @Override
    public UserResponseDto toUserResponseDto(User user) {
        if (user == null) {
            return null;
        }
        return UserResponseDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }

    @Override
    public User toUser(UserRequestDto userRequestDto) {
        if (userRequestDto == null) {
            return null;
        }
        return User.builder()
                .name(userRequestDto.getName())
                .email(userRequestDto.getEmail())
                .build();
    }
}

