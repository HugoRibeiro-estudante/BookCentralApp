package com.rhars.BookCentral.repositories;

import com.rhars.BookCentral.dataVO.BookVO;
import com.rhars.BookCentral.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b FROM Book b WHERE b.title LIKE %:nome%")
    List<Book> buscarPorNome(@Param("nome") String nome);

    Optional<Book> findById(Book idBook);

}
