package com.github.gongsir0630.app.controller.api;

import com.github.gongsir0630.app.controller.res.Result;
import com.github.gongsir0630.app.model.User;
import com.github.gongsir0630.app.service.UserService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author <a href="https://github.com/gongsir0630">码之泪殇</a>
 * @date 2021/5/9 17:34
 * 你的指尖,拥有改变世界的力量
 * @description demo-示例接口
 */
@RestController
@Api(tags = "demo-接口文档实例")
@Slf4j
@RequestMapping("api/demo")
public class DemoController {

    @Resource
    private UserService userService;

    @GetMapping("hello")
    public ResponseEntity<Result<?>> test() {
        return new ResponseEntity<>(Result.success("hello java-app-template!"), HttpStatus.OK);
    }

    @GetMapping("users")
    public ResponseEntity<Result<?>> getUserList() {
        List<User> users = this.userService.list();
        return new ResponseEntity<>(Result.success(users), HttpStatus.OK);
    }

    @GetMapping("needLogin")
    @RequiresAuthentication
    public ResponseEntity<Result<?>> needLogin() {
        return new ResponseEntity<>(Result.success("login success!"), HttpStatus.OK);
    }
}
