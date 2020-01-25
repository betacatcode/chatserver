package com.ruin.chatserver.controller;

import com.ruin.chatserver.domain.Msg;
import com.ruin.chatserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author ruin
 * @date 2020/1/23-17:04
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/test")
    public @ResponseBody Msg test(){
        System.out.println("执行test...");
        Msg msg=new Msg();
        msg.setStatusCode(200);
        msg.setContent(new String("测试主体"));
        msg.setExtra("测试...");
        return msg;
    }

    @PostMapping("/doLogin")
    public @ResponseBody Msg doLogin(@RequestBody Map<String,String> map){
        System.out.println(map.get("account"));
        System.out.println(map.get("password"));
        System.out.println("执行doLogin...");
        return userService.doLogin(map.get("account"),map.get("password"));
    }

}
