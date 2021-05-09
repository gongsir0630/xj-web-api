package com.github.gongsir0630.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.gongsir0630.app.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author <a href="https://github.com/gongsir0630">码之泪殇</a>
 * @date 2021/5/9 17:15
 * 你的指尖,拥有改变世界的力量
 * @description userMapper
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
  // 可以在这里基于注解自定义 sql 方法
}
