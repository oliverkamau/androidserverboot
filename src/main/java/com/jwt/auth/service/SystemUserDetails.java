package com.jwt.auth.service;

import com.jwt.auth.model.User;
import com.jwt.auth.repo.UserRepo;
import com.jwt.auth.util.UserDetailsImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SystemUserDetails implements UserDetailsService {
    private UserRepo userRepo;

    public SystemUserDetails(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepo.findByUsername(username);
        if (user==null)
            throw new UsernameNotFoundException("Ooops No User");
        return new UserDetailsImpl(user);
    }
}
