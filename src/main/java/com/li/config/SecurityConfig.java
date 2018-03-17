package com.li.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by lihou on 2018/3/15.
 * 权限控制以及单点登录实现
 */

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)//注意要设置(prePostEnabled=true)，因为它默认值是false
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //inMemoryAuthentication 从内存中获取
        auth.inMemoryAuthentication().passwordEncoder(new MyPasswordEncoder()).
        withUser("user").password("123456").roles("USER")
                .and().withUser("admin").password("123456").roles("ADMIN");

    }

    /**定义安全策略*/
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()//配置安全策略
                .antMatchers("/","/springboot2").permitAll()//定义/请求不需要验证
                .anyRequest().authenticated()//其余的所有请求都需要验证
                .and()
                .logout()
                .logoutSuccessUrl("/index").
                permitAll()
                .and()
                .formLogin();//使用form表单登录
                //以下这句就可以控制单个用户只能创建一个session，也就只能在服务器登录一次
                http.sessionManagement().maximumSessions( 1 ).expiredUrl( "/login" );
        }




}
