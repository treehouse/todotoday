package com.teamtreehouse.todotoday.service;

import com.teamtreehouse.todotoday.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User findByUsername(String username);
}
