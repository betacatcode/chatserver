package com.ruin.chatserver.service.impl;

import com.ruin.chatserver.dao.UserMapper;
import com.ruin.chatserver.domain.Msg;
import com.ruin.chatserver.domain.User;
import com.ruin.chatserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * @author ruin
 * @date 2020/1/24-15:01
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public Msg doLogin(String account, String password) {
        Msg msg=new Msg();
        User findUser=new User();

        findUser.setAccount(account);
        List<User> users=null;
        if(!ObjectUtils.isEmpty(account)&&!ObjectUtils.isEmpty(password)){
            users = userMapper.select(findUser);
        }
        if(users==null||users.size()==0){
            msg.setStatusCode(400);
            msg.setExtra("There is no such person.");
            return msg;
        }

        if(users.get(0).getPassword().equals(password)){
            msg.setStatusCode(200);
            msg.setContent(users.get(0));
            msg.setExtra("Login successfully!");
        }else {
            msg.setStatusCode(400);
            msg.setExtra("Password Error..");
        }

        return msg;
    }
}
