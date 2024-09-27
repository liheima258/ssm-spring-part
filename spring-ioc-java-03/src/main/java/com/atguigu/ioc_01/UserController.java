package com.atguigu.ioc_01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * 功能：
 * 日期：2024/7/1013:24
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    public void show(){
        userService.show();
    }
}
