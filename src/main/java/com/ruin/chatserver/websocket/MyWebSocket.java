package com.ruin.chatserver.websocket;

import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author ruin
 * @date 2020/1/25-11:06
 */

@ServerEndpoint(value = "/websocket")
@Component
public class MyWebSocket {

//    线程安全Set 用来存放每个客户端对应的MyWebSocket对象
    private static CopyOnWriteArraySet<MyWebSocket> webSocketSet = new CopyOnWriteArraySet<MyWebSocket>();

//    与某个客户端的连接会话 通过它来给客户端发送数据
    private Session session;

    @OnOpen
    public void onOpen(Session session){
        this.session=session;
        webSocketSet.add(this);
        System.out.println("有新连接加入！当前在线人数为" + webSocketSet.size());
        broadcast("有新连接加入-->当前在线人数为："+webSocketSet.size());
    }

    @OnClose
    public void onClose(){
        webSocketSet.remove(this);
        System.out.println("有一连接关闭！当前在线人数为" + webSocketSet.size());
        broadcast("有一连接关闭！当前在线人数为" + webSocketSet.size());
    }

    @OnError
    public void onError(Session session,Throwable error){
        System.out.println("发生错误");
        error.printStackTrace();
    }

    /**
     * 收到客户端消息
     */
    @OnMessage
    public void onMessage(String message,Session session){
        System.out.println("来自客户端的消息:" + message);
        broadcast(message);
    }

    /**
     * 群发消息
     * @param message
     */
    public void broadcast(String message){
        for(MyWebSocket item:webSocketSet){
            item.session.getAsyncRemote().sendText(message);
        }
    }

}
