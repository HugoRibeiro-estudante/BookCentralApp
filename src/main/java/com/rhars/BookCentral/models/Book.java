package com.rhars.BookCentral.models;


import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "book")
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "editor_users", nullable = false)
    private List<User> editorUsers;

    @Column(name = "autor", nullable = false)
    private String autor;

    @Column(name = "number_pages", nullable = false, length = 2000)
    private int numberPages;

    @Column(name = "category", nullable = false, length = 100)
    private String category;

    public Book() {}

    public Book(String title, List<User> editorUsers, String autor, int numberPages, String category) {
        this.title = title;
        this.editorUsers = editorUsers;
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

    public List<User> getEditorUsers() {
        return editorUsers;
    }

    public void setEditorUsers(List<User> editorUsers) {
        this.editorUsers = editorUsers;
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
        if (editorUsers != null ? !editorUsers.equals(book.editorUsers) : book.editorUsers != null) return false;
        if (autor != null ? !autor.equals(book.autor) : book.autor != null) return false;
        return category != null ? category.equals(book.category) : book.category == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (editorUsers != null ? editorUsers.hashCode() : 0);
        result = 31 * result + (autor != null ? autor.hashCode() : 0);
        result = 31 * result + numberPages;
        result = 31 * result + (category != null ? category.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", editorUsers=" + editorUsers +
                ", autor='" + autor + '\'' +
                ", numberPages=" + numberPages +
                ", category='" + category + '\'' +
                '}';
    }
}
