package com.routeapp.service;

import com.routeapp.entity.User;

public interface UserService {
    User findUserByEmail(String email);
    void saveUser(User user);
}
