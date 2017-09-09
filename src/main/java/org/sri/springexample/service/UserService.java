package org.sri.springexample.service;

import org.springframework.stereotype.Component;
import org.sri.springexample.entity.User;

import java.util.List;

@Component
public interface UserService {

        User findByEmailID(String email);

        List<User> findAll();

        User createUser(User user);

        User updateUser(User user);

        void deleteUserByEmailID(String id);



}
