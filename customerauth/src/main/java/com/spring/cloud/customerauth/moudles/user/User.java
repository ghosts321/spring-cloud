package com.spring.cloud.customerauth.moudles.user;

import lombok.Data;

import javax.persistence.*;

/**
 *
 * @author JiangJunpeng
 * @date 2019/6/12
 */
@Data
@Entity(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 32)
    private Long id;
    @Column(length = 50)
    private String username;
    @Column(length = 100)
    private String password;
    @Column(length = 32)
    private String role;
}
