package com.rhars.BookCentral.models;


import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book")
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "autor", nullable = false)
    private String autor;

    @Column(name = "number_pages", nullable = false, length = 2000)
    private int numberPages;

    @Column(name = "category", nullable = false, length = 100)
    private String category;

    @OneToMany
    @JoinColumn(name = "annotation_id")
    List<Annotation> annotations = new ArrayList<>();

    @ManyToMany(mappedBy = "books", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<User> users = new ArrayList<>();

    public Book() {}

    public Book(String title, String autor, int numberPages, String category) {
        this.title = title;
        this.autor = autor;
        this.numberPages = numberPages;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getNumberPages() {
        return numberPages;
    }

    public void setNumberPages(int numberPages) {
        this.numberPages = numberPages;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (numberPages != book.numberPages) return false;
        if (id != null ? !id.equals(book.id) : book.id != null) return false;
        if (title != null ? !title.equals(book.title) : book.title != null) return false;
        if (autor != null ? !autor.equals(book.autor) : book.autor != null) return false;
        if (category != null ? !category.equals(book.category) : book.category != null) return false;
        if (annotations != null ? !annotations.equals(book.annotations) : book.annotations != null) return false;
        return users != null ? users.equals(book.users) : book.users == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (autor != null ? autor.hashCode() : 0);
        result = 31 * result + numberPages;
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (annotations != null ? annotations.hashCode() : 0);
        result = 31 * result + (users != null ? users.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", autor='" + autor + '\'' +
                ", numberPages=" + numberPages +
                ", category='" + category + '\'' +
                ", annotations=" + annotations +
                ", users=" + users +
                '}';
    }
}
