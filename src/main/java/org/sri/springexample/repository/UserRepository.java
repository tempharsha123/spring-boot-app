package org.sri.springexample.repository;


import org.springframework.data.repository.Repository;
import org.sri.springexample.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends Repository<User,String> {


    public List<User> findAll();

    public Optional<User> findOne(String userID);
    public Optional<User> findByEmail(String email);

    public User save(User user);

    public void delete(User user);

}
