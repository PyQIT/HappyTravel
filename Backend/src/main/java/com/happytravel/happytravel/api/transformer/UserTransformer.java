package com.happytravel.happytravel.api.transformer;

import com.happytravel.happytravel.api.dto.UserDto;
import com.happytravel.happytravel.api.model.User;
import org.springframework.beans.BeanUtils;

public class UserTransformer {

    public static UserDto convertToDto(User user) {
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user, userDto);
        return userDto;
    }

    public static User convertToEntity(UserDto userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        return user;
    }
}