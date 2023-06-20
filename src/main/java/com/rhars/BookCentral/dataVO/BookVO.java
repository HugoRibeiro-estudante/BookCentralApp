package com.rhars.BookCentral.dataVO;

import com.rhars.BookCentral.models.User;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.List;
public class BookVO extends RepresentationModel<BookVO> implements Serializable {

    private Long id;

    private String title;

    private List<User> editorUsers;

    private String autor;

    private int numberPages;

    private String category;

    public BookVO() {}

    public BookVO(String title, List<User> editorUsers, String autor, int numberPages, String category) {
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
        if (!super.equals(o)) return false;

        BookVO bookVO = (BookVO) o;

        if (numberPages != bookVO.numberPages) return false;
        if (id != null ? !id.equals(bookVO.id) : bookVO.id != null) return false;
        if (title != null ? !title.equals(bookVO.title) : bookVO.title != null) return false;
        if (editorUsers != null ? !editorUsers.equals(bookVO.editorUsers) : bookVO.editorUsers != null) return false;
        if (autor != null ? !autor.equals(bookVO.autor) : bookVO.autor != null) return false;
        return category != null ? category.equals(bookVO.category) : bookVO.category == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (editorUsers != null ? editorUsers.hashCode() : 0);
        result = 31 * result + (autor != null ? autor.hashCode() : 0);
        result = 31 * result + numberPages;
        result = 31 * result + (category != null ? category.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BookVO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", editorUsers=" + editorUsers +
                ", autor='" + autor + '\'' +
                ", numberPages=" + numberPages +
                ", category='" + category + '\'' +
                '}';
    }
}
