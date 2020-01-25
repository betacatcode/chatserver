package com.ruin.chatserver.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author ruin
 * @date 2020/1/24-14:59
 */
public interface MyMapper<T> extends Mapper<T>,MySqlMapper<T> {
}
