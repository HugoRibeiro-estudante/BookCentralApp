package com.rhars.BookCentral.dataVO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.rhars.BookCentral.models.Annotation;
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

    private List<User> editorUsers;

    private List<String> authors;

    private int numberPages;

    private List<String> categories;

    private List<Annotation> annotations = new ArrayList<>();

    private List<User> users = new ArrayList<>();

    public BookVO() {}

    public BookVO(String googleId, String title, List<User> editorUsers, List<String> authors, int numberPages, List<String> categories, List<Annotation> annotations, List<User> users) {
        this.googleId = googleId;
        this.title = title;
        this.editorUsers = editorUsers;
        this.authors = authors;
        this.numberPages = numberPages;
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

    public List<User> getEditorUsers() {
        return editorUsers;
    }

    public void setEditorUsers(List<User> editorUsers) {
        this.editorUsers = editorUsers;
    }

    public List<String> getauthors() {
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
        return numberPages == bookVO.numberPages && Objects.equals(id, bookVO.id) && Objects.equals(googleId, bookVO.googleId) && Objects.equals(title, bookVO.title) && Objects.equals(editorUsers, bookVO.editorUsers) && Objects.equals(authors, bookVO.authors) && Objects.equals(categories, bookVO.categories) && Objects.equals(annotations, bookVO.annotations) && Objects.equals(users, bookVO.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, googleId, title, editorUsers, authors, numberPages, categories, annotations, users);
    }

    @Override
    public String toString() {
        return "BookVO{" +
                "id=" + id +
                ", googleId='" + googleId + '\'' +
                ", title='" + title + '\'' +
                ", editorUsers=" + editorUsers +
                ", authors=" + authors +
                ", numberPages=" + numberPages +
                ", categories=" + categories +
                ", annotations=" + annotations +
                ", users=" + users +
                '}';
    }
}
