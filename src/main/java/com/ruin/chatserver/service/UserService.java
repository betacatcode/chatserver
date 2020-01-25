package com.ruin.chatserver.service;

import com.ruin.chatserver.domain.Msg;

/**
 * @author ruin
 * @date 2020/1/24-14:50
 */
public interface UserService {
    public Msg doLogin(String account,String password);
}
