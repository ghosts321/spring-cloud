package com.spring.cloud.servicezuul.moudles.demo;

import java.util.List;

/**
 *
 * @author JiangJunpeng
 * @date 2019/6/11
 */
public interface DemoService {

    Demo addUser(Demo demo);

    Demo updateUser(Demo demo);

    void deleteUserById(long id);

    List<Demo> findAll();

    Demo findUserByName(String name);
}
