package com.re.repractice.mapper;

import com.re.repractice.dto.request.UserRequestDto;
import com.re.repractice.dto.response.UserResponseDto;
import com.re.repractice.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserResponseDto toUserResponseDto(User user);
    User toUser(UserRequestDto userRequestDto);
}

