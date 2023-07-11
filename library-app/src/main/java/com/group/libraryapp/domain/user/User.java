package com.group.libraryapp.domain.user;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;
    @Column(nullable = false, length = 20, name = "name") // name varchar(20)
    private String name;
    private Integer age;

    // JPA를 사용하기 위해서는 기본생성자가 필요
    protected User(){}

    public User(String name, Integer age) {
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException(String.format("잘못된 name(%s)이 입력 되었습니다.",name));
        }
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Long getId() {return id;}

    public void updateName(String name){
        this.name = name;
    }
}
