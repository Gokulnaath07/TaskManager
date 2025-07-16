package com.teamseven07.todolist.Services;

import com.teamseven07.todolist.Model.User;
import com.teamseven07.todolist.Repositories.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final AuthenticationManager authManager;
    private final JWTService jwtService;

    public UserService(UserRepository userRepository, AuthenticationManager authManager, JWTService jwtService) {
        this.userRepository=userRepository;
        this.authManager=authManager;
        this.jwtService=jwtService;
    }

    private BCryptPasswordEncoder byCrypt= new BCryptPasswordEncoder(12);

    public User register(User user){
        user.setPassword(byCrypt.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public String verify(User user) {
        Authentication authentication=authManager
                .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        if(authentication.isAuthenticated()){
            return jwtService.generateToken(user.getUsername());
        }
        return "Failure";
    }
}
