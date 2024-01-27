    package com.rhars.BookCentral.models;


    import com.fasterxml.jackson.annotation.JsonIgnore;
    import jakarta.persistence.*;

    import java.io.Serializable;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.Objects;

    @Entity
    @Table(name = "book")
    public class Book implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
    
        @Column(name = "google_id", nullable = false, length = 100)
        private String googleId;
    
        @Column(name = "title", nullable = false, length = 100)
        private String title;
    
        @Column(name = "authors", nullable = false)
        private List<String> authors;
    
        @Column(name = "number_pages", nullable = false)
        private int numberPages;

        @Column(name = "status", nullable = false)
        private Status status;

        @Column(name = "privacy", nullable = false)
        private Privacy privacy;

        @Column(name = "photo", nullable = true, length = 120)
        private String photo;
    
        @Column(name = "categories", nullable = false)
        private List<String> categories;
    
        @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true )
        private List<Annotation> annotations = new ArrayList<>();

        @JsonIgnore
        @ManyToMany(mappedBy = "books", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        private List<User> users = new ArrayList<>();

        public Book() {}

        public Book(String googleId, String title, List<String> authors, int numberPages, Status status, Privacy privacy, String photo, List<String> categories, List<Annotation> annotations, List<User> users) {
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

        public String getTitle() {
            return title;
        }    

        public String getGoogleId() {
            return googleId;
        }

        public void setGoogleId(String googleId) {
            this.googleId = googleId;
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
            Book book = (Book) o;
            return numberPages == book.numberPages && Objects.equals(id, book.id) && Objects.equals(googleId, book.googleId) && Objects.equals(title, book.title) && Objects.equals(authors, book.authors) && status == book.status && privacy == book.privacy && Objects.equals(photo, book.photo) && Objects.equals(categories, book.categories) && Objects.equals(annotations, book.annotations) && Objects.equals(users, book.users);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, googleId, title, authors, numberPages, status, privacy, photo, categories, annotations, users);
        }

        @Override
        public String toString() {
            return "Book{" +
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
