package org.sri.springexample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.sri.springexample.entity.User;
import org.sri.springexample.exception.BadRequestException;
import org.sri.springexample.exception.ResourceNotFoundException;
import org.sri.springexample.repository.UserRepository;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    public User findByEmailID(String emailId) {
     return userRepository.findByEmail(emailId)
                                .orElseThrow(()->
                                 new ResourceNotFoundException("There is no user with the given userID. " +
                                 "Please try with a valid user id"));
    }

    public List<User> findAll() {
        List<User> users = userRepository.findAll();
        if(users!=null)
            return users;
        else
            throw new ResourceNotFoundException("There are no users present in the database");
    }

    @Transactional
    public User createUser(User user) {
        Optional<User> existingUser= userRepository.findByEmail(user.getEmail());
        if(existingUser.isPresent())
            throw new BadRequestException("User already present.");
        return userRepository.save(user);
}

    @Transactional
    public User updateUser(User user) {
        userRepository.findByEmail(user.getEmail())
                .orElse(userRepository.save(user));

        return  userRepository.save(user);
    }

    @Transactional
    public void deleteUserByEmailID(String emailId) {
        User user =userRepository.findByEmail(emailId)
                    .orElseThrow(()->new BadRequestException("There is no user with the given userID"));

        userRepository.delete(user);
    }

}
