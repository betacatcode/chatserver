package com.ruin.chatserver.dao;

import com.ruin.chatserver.domain.User;
import com.ruin.chatserver.mapper.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author ruin
 * @date 2020/1/24-14:56
 */

@Mapper
@Repository
public interface UserMapper extends MyMapper<User> {
}
