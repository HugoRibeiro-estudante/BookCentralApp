package com.rhars.BookCentral.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "annotation")
public class Annotation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIgnore
    private Book book;

    @Column(name = "title", nullable = false, length = 80)
    private String title;

    @Column(name = "page", nullable = false, length = 2000)
    private int page;

    @Column(name = "body", nullable = false, length = 10000)
    private String body;

    @Column(name = "date_create", nullable = true)
    private Date dateCreate = new Date();


    public Annotation() {}

    public Annotation(String title, int page, String body, Date dateCreate) {
        this.title = title;
        this.page = page;
        this.body = body;
        this.dateCreate = dateCreate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Annotation that = (Annotation) o;
        return page == that.page && Objects.equals(id, that.id) && Objects.equals(book, that.book) && Objects.equals(title, that.title) && Objects.equals(body, that.body) && Objects.equals(dateCreate, that.dateCreate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, book, title, page, body, dateCreate);
    }

    @Override
    public String toString() {
        return "Annotation{" +
                "id=" + id +
                ", book=" + book +
                ", title='" + title + '\'' +
                ", page=" + page +
                ", body='" + body + '\'' +
                ", dateCreate=" + dateCreate +
                '}';
    }
}
