package com.github.gongsir0630.app.controller.api;

import com.github.gongsir0630.app.controller.res.Result;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="https://github.com/gongsir0630">码之泪殇</a>
 * @date 2021/5/9 17:34
 * 你的指尖,拥有改变世界的力量
 * @description 登录接口
 */
@RestController
@Slf4j
@RequestMapping("/auth")
public class LoginController {

    /**
     * 调用 mobile.py 发送验证码
     * @param phone 手机号,传入 python 脚本
     * @return
     */
    @GetMapping("/sms")
    @ApiOperation("获取验证码")
    public ResponseEntity<Result<?>> sms(@RequestParam String phone) {
        String currentPath = System.getProperty("user.dir");
        String cmd = "python " + currentPath + "scripts/mobile.py " + phone;
        List<String> res = getCmdRes(cmd);
        res.forEach(System.out::println);
        return ResponseEntity.ok(Result.success(res));
    }


    @GetMapping("/login")
    @ApiOperation("验证码登录")
    public ResponseEntity<Result<?>> login(@RequestParam String phone,
                                        @RequestParam String code) {
        String currentPath = System.getProperty("user.dir");
        String cmd = "python " + currentPath + "scripts/mobile.py " + phone + " " + code;
        List<String> res = getCmdRes(cmd);
        res.forEach(System.out::println);
        return ResponseEntity.ok(Result.success(res));
    }

    private List<String> getCmdRes(String cmd) {
        Runtime runtime = Runtime.getRuntime();
        List<String> result = new ArrayList<>();
        System.out.println(cmd);
        try {
            Process process = runtime.exec(cmd);
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result.add(line);
                System.out.println(line);
            }
            in.close();
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }
}
