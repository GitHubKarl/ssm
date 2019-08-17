package com.baidu.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *    测试类   转换密码
 */
public class BCryptTest {
//    passwordEncoder;
    private static BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
    public static String Encode(String password){
        return bCryptPasswordEncoder.encode(password);
    }

    public static void main(String[] args) {
        String s="user";
        String encode = Encode(s);
        System.out.println(encode);//$2a$10$hieUSyuqee83a.B28mXGUuHg3ZTdGIDmkwKl/.6P4HWdBvkbB5S5e
    }
}
