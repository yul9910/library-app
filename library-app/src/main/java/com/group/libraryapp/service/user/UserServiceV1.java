package com.group.libraryapp.service.user;

import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequset;
import com.group.libraryapp.dto.user.response.UserResponse;
import com.group.libraryapp.repository.user.UserJdbcRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceV1 {
    private final UserJdbcRepository userJdbcRepository;

    public UserServiceV1(UserJdbcRepository userJdbcRepository){
        this.userJdbcRepository = userJdbcRepository;

    }

    public void saveUser(UserCreateRequest requset){
        userJdbcRepository.saveUser(requset.getName(), requset.getAge());
    }

    public List<UserResponse> getUsers() {
        return userJdbcRepository.getUsers();
    }

    public void updateUser(UserUpdateRequset requset){
        boolean isUserNotExist = userJdbcRepository.isUserNotExist(requset.getId());
        if(isUserNotExist){
            throw new IllegalArgumentException();
        }
        userJdbcRepository.updateUserName(requset.getName(), requset.getId());
    }

    public void deleteUser(String name){
        boolean isUserNotExist =  userJdbcRepository.isUserNotExist(name);
        if(isUserNotExist){
            throw new IllegalArgumentException();
        }
        userJdbcRepository.deleteUser(name);
    }

}
