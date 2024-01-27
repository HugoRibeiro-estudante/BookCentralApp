package com.rhars.BookCentral.services;

import com.rhars.BookCentral.controllers.UserController;
import com.rhars.BookCentral.dataVO.BookVO;
import com.rhars.BookCentral.dataVO.UserVO;
import com.rhars.BookCentral.exceptions.RequiredObjectIsNullException;
import com.rhars.BookCentral.exceptions.ResourceNotFoundException;
import com.rhars.BookCentral.mapper.DozerMapper;
import com.rhars.BookCentral.models.Book;
import com.rhars.BookCentral.models.User;
import com.rhars.BookCentral.repositories.BookRepository;
import com.rhars.BookCentral.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private BookRepository bookRepository;

    public List<UserVO> findAll() {
        var userDbList = repository.findAll();
        var users = DozerMapper.parseListObject(userDbList, UserVO.class);
        users.stream().forEach(user -> {
            try {
                user.add(linkTo(methodOn(UserController.class).findById(user.getId()))
                        .withSelfRel()
                );
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
        return users;
    }

    public UserVO findById(Long id) throws Exception {
        var userDb = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records for this ID."));
        var user = DozerMapper.parseObject(userDb, UserVO.class);
        user.add(linkTo(methodOn(UserController.class).findById(id)).withSelfRel());

        return user;
    }


    public UserVO save(UserVO userVO) throws Exception{
        if(userVO == null) throw new RequiredObjectIsNullException();

        User user = DozerMapper.parseObject(userVO, User.class);
        var userDb = repository.save(user);
        userVO = DozerMapper.parseObject(userDb, UserVO.class);
        userVO.add(linkTo(methodOn(UserController.class).findById(userVO.getId())).withSelfRel());
        return userVO;
    }

    public UserVO update(UserVO userVO) throws Exception {
        if(userVO == null) throw new RequiredObjectIsNullException();

        var dbUser = repository.findById(userVO.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));
        User user = DozerMapper.parseObject(userVO, User.class);
        user = repository.save(user);
        userVO = DozerMapper.parseObject(user, UserVO.class);
        userVO.add(linkTo(methodOn(UserController.class).findById(userVO.getId())).withSelfRel());
        return userVO;
    }

    public String delete(Long id) {
        var dbUser = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));
        repository.deleteById(id);
        return "User with id " + id + " has been deleted!";
    }

//    public List<UserVO> buscarPorUserName(String userName){
//        List<User> users = repository.buscarPorUserName(userName);
//        return DozerMapper.parseListObject(users, UserVO.class);
//    }

    public UserVO addBook(Long id, Long idBook) {
        User user = repository.findById(id).get();
        Book book = bookRepository.findById(idBook).get();
        user.getBooks().add(book);
        user = repository.save(user);
        return DozerMapper.parseObject(user, UserVO.class);
    }

    public UserVO findByEmail(String email) {
        User user = repository.findByEmail(email);
        if (user == null) {
            return null;
        }
        return DozerMapper.parseObject(user, UserVO.class);
    }

}
