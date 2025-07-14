package com.teamseven07.todolist.Services;

import com.teamseven07.todolist.Model.User;
import com.teamseven07.todolist.Repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    private BCryptPasswordEncoder byCrypt= new BCryptPasswordEncoder(12);

    public User register(User user){
        user.setPassword(byCrypt.encode(user.getPassword()));
        return userRepository.save(user);
    }
}
