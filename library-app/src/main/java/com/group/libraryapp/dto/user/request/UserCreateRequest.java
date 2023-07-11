package com.group.libraryapp.dto.user.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


public class UserCreateRequest {
    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    private String name;
    private Integer age;
}
