package com.spring.cloud.servicezuul.moudles.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author JiangJunpeng
 * @date 2019/6/13
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    UserDao userDao;

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public User addUser(User user) {
        if (user.getUsername() != null && user.getPassword() != null){
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userDao.save(user);
        } else {
            user = null;
        }
        return user;
    }
}
