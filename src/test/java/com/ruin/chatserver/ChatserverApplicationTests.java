package com.ruin.chatserver;

import com.ruin.chatserver.dao.UserMapper;
import com.ruin.chatserver.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ChatserverApplicationTests {

	@Autowired
	UserMapper userMapper;

	@Test
	void contextLoads() {
	}

	@Test
	void findTest(){
		User user=new User();
		List<User> users = userMapper.select(user);
		System.out.println(users);
	}
}
