package com.github.gongsir0630.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.gongsir0630.app.mapper.UserMapper;
import com.github.gongsir0630.app.model.User;
import com.github.gongsir0630.app.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author <a href="https://github.com/gongsir0630">码之泪殇</a>
 * @date 2021/5/9 18:16
 * 你的指尖,拥有改变世界的力量
 * @description description
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
