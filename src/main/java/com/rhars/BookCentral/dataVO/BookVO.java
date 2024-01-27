package com.rhars.BookCentral.dataVO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.rhars.BookCentral.models.Annotation;
import com.rhars.BookCentral.models.Privacy;
import com.rhars.BookCentral.models.Status;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import org.springframework.hateoas.RepresentationModel;

import com.rhars.BookCentral.models.User;
public class BookVO extends RepresentationModel<BookVO> implements Serializable {

    private Long id;

    private String googleId;

    private String title;


    private List<String> authors;

    private int numberPages;

    private Status status;

    private Privacy privacy;

    private String photo;

    private List<String> categories;

    private List<Annotation> annotations = new ArrayList<>();

    private List<User> users = new ArrayList<>();

    public BookVO() {}

    public BookVO(String googleId, String title, List<String> authors, int numberPages, Status status, Privacy privacy, String photo, List<String> categories, List<Annotation> annotations, List<User> users) {
        this.googleId = googleId;
        this.title = title;
        this.authors = authors;
        this.numberPages = numberPages;
        this.status = status;
        this.privacy = privacy;
        this.photo = photo;
        this.categories = categories;
        this.annotations = annotations;
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGoogleId() {
        return googleId;
    }

    public void setGoogleId(String googleId) {
        this.googleId = googleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public int getNumberPages() {
        return numberPages;
    }

    public void setNumberPages(int numberPages) {
        this.numberPages = numberPages;
    }


    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Privacy getPrivacy() {
        return privacy;
    }

    public void setPrivacy(Privacy privacy) {
        this.privacy = privacy;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public List<Annotation> getAnnotations() {
        return annotations;
    }

    public void setAnnotations(List<Annotation> annotations) {
        this.annotations = annotations;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BookVO bookVO = (BookVO) o;
        return numberPages == bookVO.numberPages && Objects.equals(id, bookVO.id) && Objects.equals(googleId, bookVO.googleId) && Objects.equals(title, bookVO.title) && Objects.equals(authors, bookVO.authors) && status == bookVO.status && privacy == bookVO.privacy && Objects.equals(photo, bookVO.photo) && Objects.equals(categories, bookVO.categories) && Objects.equals(annotations, bookVO.annotations) && Objects.equals(users, bookVO.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, googleId, title, authors, numberPages, status, privacy, photo, categories, annotations, users);
    }

    @Override
    public String toString() {
        return "BookVO{" +
                "id=" + id +
                ", googleId='" + googleId + '\'' +
                ", title='" + title + '\'' +
                ", authors=" + authors +
                ", numberPages=" + numberPages +
                ", status=" + status +
                ", privacy=" + privacy +
                ", photo='" + photo + '\'' +
                ", categories=" + categories +
                ", annotations=" + annotations +
                ", users=" + users +
                '}';
    }
}
