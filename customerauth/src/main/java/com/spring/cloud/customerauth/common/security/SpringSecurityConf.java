package com.spring.cloud.customerauth.common.security;

import com.spring.cloud.customerauth.common.filters.JwtAuthenticationTokenFilter;
import com.spring.cloud.customerauth.moudles.user.JwtUserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author: JiangJunpeng
 * @date: 2019/6/12
 * @description:
 */
@Configuration
public class SpringSecurityConf extends WebSecurityConfigurerAdapter {

    //未登陆时返回 JSON 格式的数据给前端（否则为 html）
    @Autowired
    AjaxAuthenticationEntryPoint authenticationEntryPoint;

    //登录成功返回的 JSON 格式数据给前端（否则为 html）
    @Autowired
    AjaxAuthenticationSuccessHandler authenticationSuccessHandler;

    //登录失败返回的 JSON 格式数据给前端（否则为 html）
    @Autowired
    AjaxAuthenticationFailureHandler authenticationFailureHandler;

    //注销成功返回的 JSON 格式数据给前端（否则为 登录时的 html）
    @Autowired
    AjaxLogoutSuccessHandler logoutSuccessHandler;

    //无权访问返回的 JSON 格式数据给前端（否则为 403 html 页面）
    @Autowired
    AjaxAccessDeniedHandler accessDeniedHandler;

    // 自定义user
    @Autowired
    JwtUserDetailsServiceImpl userService;

    // JWT 拦截器
    @Autowired
    JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    //这里配置PasswordEncoder,BCryptPasswordEncoder是security提供的PasswordEncorder的一个实现类
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 加入自定义的安全认证
//        auth.authenticationProvider(provider);
        auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // 去掉 CSRF
        http.csrf().disable()
                // 使用 JWT，关闭token
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()

                .httpBasic().authenticationEntryPoint(authenticationEntryPoint)

                .and()
                //定义哪些URL需要被保护、哪些不需要被保护
                .authorizeRequests()
                .antMatchers("/register", "/doRegister", "/login", "/doLogin").permitAll()
                //任何请求,登录后可以访问
                .anyRequest().authenticated()
                // RBAC 动态 url 认证
//                .access("@rbacauthorityservice.hasPermission(request,authentication)")

                .and()
                //开启登录, 定义当需要用户登录时候，转到的登录页面
                .formLogin()
//                .loginPage("/test/login.html")
//                .loginProcessingUrl("/login")
                // 登录成功
                .successHandler(authenticationSuccessHandler)
                // 登录失败
                .failureHandler(authenticationFailureHandler)
                .permitAll()

                .and()
                //默认注销行为为logout
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessHandler(logoutSuccessHandler)
                .permitAll();

        // 记住我
        http.rememberMe().rememberMeParameter("remember-me")
                .userDetailsService(userService).tokenValiditySeconds(1000);

        // 无权访问 JSON 格式的数据
        http.exceptionHandling().accessDeniedHandler(accessDeniedHandler);
        // JWT Filter
        http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);

    }
}
