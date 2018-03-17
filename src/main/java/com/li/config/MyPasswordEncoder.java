package com.li.config;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by lihou on 2018/3/15.
 * 密码编译器，没有密码编译规则会报错
 */
public class MyPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence arg0) {
        return arg0.toString();
    }

    @Override
    public boolean matches(CharSequence arg0, String arg1) {
        return arg1.equals(arg0.toString());
    }

}