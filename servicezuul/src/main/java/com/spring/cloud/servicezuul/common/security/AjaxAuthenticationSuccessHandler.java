package com.spring.cloud.servicezuul.common.security;

import com.alibaba.fastjson.JSON;
import com.spring.cloud.servicezuul.common.enums.ResultEnum;
import com.spring.cloud.servicezuul.common.utils.AccessAddressUtil;
import com.spring.cloud.servicezuul.common.utils.JwtTokenUtils;
import com.spring.cloud.servicezuul.common.utils.RedisUtils;
import com.spring.cloud.servicezuul.common.vo.ResultVO;
import com.spring.cloud.servicezuul.moudles.user.JwtUserDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户登录成功时返回给前端的数据
 * @author JiangJunpeng
 * @date 2019/6/12
 */
@Component
@Slf4j
public class AjaxAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Value("${token.expirationSeconds}")
    private int expirationSeconds;

    @Value("${token.validTime}")
    private int validTime;

    @Autowired
    private RedisUtils redisUtils;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        //获取请求的ip地址
        String ip = AccessAddressUtil.getIpAddress(httpServletRequest);
        Map<String,Object> map = new HashMap<>();
        map.put("ip",ip);

        JwtUserDetails user = (JwtUserDetails) authentication.getPrincipal();

        String jwtToken = JwtTokenUtils.generateToken(user.getUsername(), expirationSeconds, map);

        //刷新时间
        Integer expire = validTime*24*60*60*1000;
        //获取请求的ip地址
        String currentIp = AccessAddressUtil.getIpAddress(httpServletRequest);
        redisUtils.setTokenRefresh(jwtToken,user.getUsername(),currentIp);
        log.info("用户{}登录成功，信息已保存至redis",user.getUsername());

        httpServletResponse.getWriter().write(JSON.toJSONString(ResultVO.result(ResultEnum.USER_LOGIN_SUCCESS,jwtToken,true)));
    }
}
