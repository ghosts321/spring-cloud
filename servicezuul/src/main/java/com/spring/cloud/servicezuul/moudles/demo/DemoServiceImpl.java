package com.spring.cloud.servicezuul.moudles.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 * @author JiangJunpeng
 * @date 2019/6/11
 */
@Service
@Transactional
public class DemoServiceImpl implements DemoService {

    @Autowired
    private DemoDao demoDao;

    @Override
    public Demo addUser(Demo demo) {
        return demoDao.save(demo);
    }

    @Override
    public Demo updateUser(Demo demo) {
        return demoDao.save(demo);
    }

    @Override
    public void deleteUserById(long id) {
        demoDao.deleteById(id);
    }

    @Override
    public List<Demo> findAll() {
        return demoDao.findAll();
    }

    @Override
    public Demo findUserByName(String name) {
        return demoDao.findByName(name);
    }
}
