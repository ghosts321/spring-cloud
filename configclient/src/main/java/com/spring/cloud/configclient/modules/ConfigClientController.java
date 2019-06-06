package com.spring.cloud.configclient.modules;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author JiangJunpeng
 * @date 2019/6/6
 */
@RestController
public class ConfigClientController {

    @Value("${data}")
    String data;

    @RequestMapping("data")
    public String data(){
        return data;
    }
}
