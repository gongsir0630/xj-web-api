package com.github.gongsir0630.app.controller.api;

import com.github.gongsir0630.app.controller.res.Result;
import com.github.gongsir0630.app.model.Comment;
import com.github.gongsir0630.app.service.CommentService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author <a href="https://github.com/gongsir0630">码之泪殇</a>
 * @date 2021/5/18 17:11
 * 你的指尖,拥有改变世界的力量
 * @description description
 */
@RestController
@Api(tags = "评价接口")
@Slf4j
@RequestMapping("/com")
public class CommentController {

    @Resource
    private CommentService commentService;

    @GetMapping("list")
    public ResponseEntity<Result<?>> list() {
        return ResponseEntity.ok(Result.success(this.commentService.list()));
    }

    @PostMapping
    public ResponseEntity<Result<?>> save(String tel,String text,int num) {
        Comment comment = new Comment();
        comment.setPhone(tel);
        comment.setPublishTime(new Date());
        comment.setNum(num);
        comment.setText(text);
        this.commentService.saveOrUpdate(comment);
        return getCommentByTel(tel);
    }

    @GetMapping("/{tel}")
    public ResponseEntity<Result<?>> getCommentByTel(@PathVariable String tel) {
        return ResponseEntity.ok(Result.success(this.commentService.getById(tel)));
    }
}
