package com.spring.cloud.customerauth.moudles.demo;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author JiangJunpeng
 * @date 2019/6/11
 */
public interface DemoDao extends JpaRepository<Demo, Long> {

    /**
     * 按用户名查找
     * @param name
     * @return
     */
    Demo findByName(String name);
}
