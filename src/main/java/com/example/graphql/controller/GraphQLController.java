package com.example.graphql.controller;

import com.example.graphql.entity.UserEntity;
import com.example.graphql.records.Author;
import com.example.graphql.records.Book;
import com.example.graphql.records.User;
import com.example.graphql.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class GraphQLController {

    @Autowired
    private UserRepository userRepository;

    @QueryMapping
    public User getUser(@Argument String id) {
        Optional<UserEntity> userEntity = userRepository.findById(id);
        if (userEntity.isPresent()) {
            UserEntity userEntity1 = userEntity.get();
            return new User(userEntity1.getUserId(), userEntity1.getLastName());
        } else{
            return null;
        }
    }

    @QueryMapping
    public Book bookById(@Argument String id){
        return Book.getById(id);
    }

    @SchemaMapping
    public Author author(Book book){
        return Author.getById(book.id());
    }
}
