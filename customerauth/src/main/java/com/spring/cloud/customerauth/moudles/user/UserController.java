package com.spring.cloud.customerauth.moudles.user;

import com.spring.cloud.customerauth.common.enums.ResultEnum;
import com.spring.cloud.customerauth.common.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by JiangJunpeng on 2019/6/13.<br>
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Map<String, Object> register(@RequestParam("username") String username, @RequestParam("password") String password) {

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setRole("ROLE_ADMIN");
        userService.addUser(user);
        return ResultVO.result(ResultEnum.SUCCESS,true);
    }
}
