package com.rhars.BookCentral.dataVO;

import com.rhars.BookCentral.models.Book;
import org.springframework.hateoas.RepresentationModel;


import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class AnnotationVO implements Serializable {

    private Long id;

    private Book idBook;

    private String title;

    private int page;

    private String body;

    private Date dateCreate;


    public AnnotationVO() {}

    public AnnotationVO(Book idBook, String title, int page, String body, Date dateCreate) {
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

        AnnotationVO annotationVO = (AnnotationVO) o;

        return Objects.equals(id, annotationVO.id) && Objects.equals(idBook, annotationVO.idBook) && Objects.equals(title, annotationVO.title) && Objects.equals(page, annotationVO.page) && Objects.equals(body, annotationVO.body) && Objects.equals(dateCreate, annotationVO.dateCreate);

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
        return "AnnotationVO{" +
                "id=" + id +
                ", idBook=" + idBook +
                ", title='" + title + '\'' +
                ", page=" + page +
                ", body='" + body + '\'' +
                ", dateCreate=" + dateCreate +
                '}';
    }
}
