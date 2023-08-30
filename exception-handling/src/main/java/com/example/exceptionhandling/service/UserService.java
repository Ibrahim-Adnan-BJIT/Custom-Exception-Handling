package com.example.exceptionhandling.service;

import com.example.exceptionhandling.exception.EmailAlreadyExist;
import com.example.exceptionhandling.exception.ResourceNotFoundException;
import com.example.exceptionhandling.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class UserService {

    private List<User>allUser;

    public UserService(List<User> allUser) {
        this.allUser = allUser;
    }

    public User addUser(User user)
    {
       Optional<User>usedEmail= Optional.empty();
        for(User user1:allUser)
        {
            if(user1.getEmail().equals(user.getEmail()))
            {
                usedEmail= Optional.of(user1);
            }
        }
        if(usedEmail.isPresent())
        {
            throw new EmailAlreadyExist("Choose an Unique email");
        }
        allUser.add(user);
        return user;
    }
    public List<User> seeUser()
    {
        return allUser;
    }
    public User getUser(int id)
    {
        boolean found=false;
        for(User user:allUser)
        {
            if(user.getId()==id)
            {
                found=true;
                return user;
            }
        }
        throw new ResourceNotFoundException("User", "id", id);

    }


}
