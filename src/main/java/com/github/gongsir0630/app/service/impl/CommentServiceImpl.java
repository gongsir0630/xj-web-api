package com.github.gongsir0630.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.gongsir0630.app.mapper.CommentMapper;
import com.github.gongsir0630.app.model.Comment;
import com.github.gongsir0630.app.service.CommentService;
import org.springframework.stereotype.Service;

/**
 * @author <a href="https://github.com/gongsir0630">码之泪殇</a>
 * @date 2021/5/18 17:11
 * 你的指尖,拥有改变世界的力量
 * @description description
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {
}
