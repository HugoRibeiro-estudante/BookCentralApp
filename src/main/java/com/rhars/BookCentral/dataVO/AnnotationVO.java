package com.rhars.BookCentral.dataVO;

import com.rhars.BookCentral.models.Book;
import org.springframework.hateoas.RepresentationModel;


import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class AnnotationVO implements Serializable {

    private Long id;
    private Book book;
    private String title;
    private int page;
    private String body;
    private Date dateCreate = new Date();


    public AnnotationVO() {}

    public AnnotationVO(Book book, String title, int page, String body, Date dateCreate) {
        this.book = book;
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
        AnnotationVO that = (AnnotationVO) o;
        return page == that.page && Objects.equals(id, that.id) && Objects.equals(book, that.book) && Objects.equals(title, that.title) && Objects.equals(body, that.body) && Objects.equals(dateCreate, that.dateCreate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, book, title, page, body, dateCreate);
    }

    @Override
    public String toString() {
        return "AnnotationVO{" +
                "id=" + id +
                ", book=" + book +
                ", title='" + title + '\'' +
                ", page=" + page +
                ", body='" + body + '\'' +
                ", dateCreate=" + dateCreate +
                '}';
    }
}
