package com.spring.cloud.configclient.modules;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author JiangJunpeng
 * @date 2019/6/6
 */
@RestController
@RefreshScope
public class ConfigClientController {

    @Value("${data}")
    String data;

    @RequestMapping("data")
    public String data(){
        return data;
    }
}
