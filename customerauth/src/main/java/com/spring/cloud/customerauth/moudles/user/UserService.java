package com.spring.cloud.customerauth.moudles.user;

/**
 * Created by JiangJunpeng on 2019/6/13.<br>
 */
public interface UserService {

    User findByUsername(String username);

    User addUser(User user);
}
