package com.ete.DataCollection.service;

import com.ete.DataCollection.model.User;
import com.ete.DataCollection.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService  {


    @Autowired
    public UserRepository userRepository;

    public boolean adduser(User user)
    {
        if(this.userRepository.existsById(user.getEmail()))
            return false;
        else{
            try {
                this.userRepository.save(user);
            }
            catch (Exception e)
            {
                return false;
            }
            return true;
        }

    }
    public List<User> getAllUsers() {
        return (List<User>) this.userRepository.findAll();
    }
}

