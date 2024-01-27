package com.rhars.BookCentral.services;


import com.rhars.BookCentral.dataVO.BookVO;
import com.rhars.BookCentral.dataVO.UserVO;
import com.rhars.BookCentral.mapper.DozerMapper;
import com.rhars.BookCentral.models.Book;
import com.rhars.BookCentral.models.User;
import com.rhars.BookCentral.repositories.BookRepository;
import com.rhars.BookCentral.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    @Autowired
    private UserRepository userRepository;

    public List<BookVO> findAll(){
        return DozerMapper.parseListObject(repository.findAll(), BookVO.class);
    }

    public BookVO findById(Long id) {
        return DozerMapper.parseObject(repository.findById(id).get(), BookVO.class);
    }

    public BookVO save(BookVO bookVO) {

            var book = repository.save(DozerMapper.parseObject(bookVO, Book.class));
            return DozerMapper.parseObject(book, BookVO.class);

    }


    public BookVO update(BookVO bookVO) {
        var dbBook = repository.findById(bookVO.getId());

        var book = repository.save(DozerMapper.parseObject(bookVO, Book.class));
        return DozerMapper.parseObject(book, BookVO.class);

    }

    public String delete(Long id) {
        var dbBook = repository.findById(id);
        if(dbBook.isPresent()) {
            repository.deleteById(id);
            return "Book with id " + id + " has been deleted!";
        }
        return "ID " + id + " not found!";
    }

    public List<BookVO> buscarPorNome(String nome){
        List<Book> books = repository.buscarPorNome(nome);
        return DozerMapper.parseListObject(books, BookVO.class);
    }

    public List<BookVO> filterByPublic(String googleId) {
        List<Book> books = repository.filterByPublic(googleId);
        if (books == null) {
            return null;
        }
        return DozerMapper.parseListObject(books, BookVO.class);
    }
}
