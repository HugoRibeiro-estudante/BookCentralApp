package com.rhars.BookCentral.dataVO;

import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;


public class UserVO extends RepresentationModel<UserVO> implements Serializable {

    private Long id;

    private String name;

    private String userName;

    private String email;

    private int age;

    public UserVO() {}

    public UserVO(String name, String userName, String email, int age) {
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        UserVO userVO = (UserVO) o;

        if (age != userVO.age) return false;
        if (id != null ? !id.equals(userVO.id) : userVO.id != null) return false;
        if (name != null ? !name.equals(userVO.name) : userVO.name != null) return false;
        if (userName != null ? !userName.equals(userVO.userName) : userVO.userName != null) return false;
        return email != null ? email.equals(userVO.email) : userVO.email == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + age;
        return result;
    }


    @Override
    public String toString() {
        return "UserVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
