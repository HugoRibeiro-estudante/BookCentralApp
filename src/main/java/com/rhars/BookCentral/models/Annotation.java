package com.rhars.BookCentral.models;


import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "annotation")
public class Annotation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "id_book", nullable = false)
    private Book idBook;

    @Column(name = "title", nullable = false, length = 80)
    private String title;

    @Column(name = "page", nullable = false, length = 2000)
    private int page;

    @Column(name = "body", nullable = false, length = 10000)
    private String body;

    @Column(name = "date_create", nullable = false)
    private Date dateCreate;


    public Annotation() {}

    public Annotation(Book idBook, String title, int page, String body, Date dateCreate) {
        this.idBook = idBook;
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

    public Book getIdBook() {
        return idBook;
    }

    public void setIdBook(Book idBook) {
        this.idBook = idBook;
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

        if (page != that.page) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (idBook != null ? !idBook.equals(that.idBook) : that.idBook != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (body != null ? !body.equals(that.body) : that.body != null) return false;
        return dateCreate != null ? dateCreate.equals(that.dateCreate) : that.dateCreate == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (idBook != null ? idBook.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + page;
        result = 31 * result + (body != null ? body.hashCode() : 0);
        result = 31 * result + (dateCreate != null ? dateCreate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Annotation{" +
                "id=" + id +
                ", idBook=" + idBook +
                ", title='" + title + '\'' +
                ", page=" + page +
                ", body='" + body + '\'' +
                ", dateCreate=" + dateCreate +
                '}';
    }
}
