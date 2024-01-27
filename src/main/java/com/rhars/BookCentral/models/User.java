package com.rhars.BookCentral.models;

import jakarta.persistence.*;
import net.minidev.json.annotate.JsonIgnore;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 120)
    private String name;

    @Column(name = "user_name", nullable = false, length = 50)
    private String userName;

    @Column(name = "email", nullable = false, length = 120)
    private String email;

    @Column(name = "birth_date", nullable = false, length = 120)
    private LocalDate birthDate;

    @Column(name = "photo", nullable = true, length = 120)
    private String photo;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "user_book",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "book_id")})
    List<Book> books = new ArrayList<>();

    public User() {}

    public User(String name, String userName, String email, LocalDate birthDate, String photo, List<Book> books) {
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
        User user = (User) o;
        return birthDate == user.birthDate && Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(userName, user.userName) && Objects.equals(email, user.email) && Objects.equals(photo, user.photo) && Objects.equals(books, user.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, userName, email, birthDate, photo, books);
    }

    @Override
    public String toString() {
        return "User{" +
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
