package com.spring.cloud.customerauth.moudles.user;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author JiangJunpeng
 * @date 2019/6/11
 */
public interface UserDao extends JpaRepository<User, Long> {

    /**
     * 按用户名查找
     * @param username
     * @return
     */
    User findByUsername(String username);
}
