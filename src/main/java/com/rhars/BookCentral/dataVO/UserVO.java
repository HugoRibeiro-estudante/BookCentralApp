package com.rhars.BookCentral.dataVO;

import com.rhars.BookCentral.models.Book;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class UserVO extends RepresentationModel<UserVO> implements Serializable {

    private Long id;
    private String name;
    private String userName;
    private String email;
    private LocalDate birthDate;
    private String photo;
    List<Book> books = new ArrayList<>();

    public UserVO() {}

    public UserVO(String name, String userName, String email, LocalDate birthDate, String photo, List<Book> books) {
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.birthDate = birthDate;
        this.photo = photo;
        this.books = books;
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        UserVO userVO = (UserVO) o;
        return birthDate == userVO.birthDate && Objects.equals(id, userVO.id) && Objects.equals(name, userVO.name) && Objects.equals(userName, userVO.userName) && Objects.equals(email, userVO.email) && Objects.equals(photo, userVO.photo) && Objects.equals(books, userVO.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, name, userName, email, birthDate, photo, books);
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", birthDate=" + birthDate +
                ", photo='" + photo + '\'' +
                ", books=" + books +
                '}';
    }
}
