package com.spring.cloud.servicezuul.moudles.demo;

import lombok.Data;

import javax.persistence.*;

/**
 *
 * @author JiangJunpeng
 * @date 2019/6/11
 */
@Data
@Entity(name = "demo")
public class Demo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 32)
    private Long id;
    @Column(length = 3)
    private int age;
    @Column(length = 50)
    private String name;
    @Column(length = 32)
    private Float height;
}
