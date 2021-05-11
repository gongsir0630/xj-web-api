package com.github.gongsir0630.app.controller.api;

import cn.hutool.core.map.MapUtil;
import com.alibaba.fastjson.JSONObject;
import com.github.gongsir0630.app.controller.res.Result;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
     * 存储所有数据
     */
    private final Map<String,List<String>> allData = MapUtil.newHashMap();

    /**
     * 调用 mobile.py 发送验证码
     * @param phone 手机号,传入 python 脚本
     * @return result
     */
    @GetMapping("/sms")
    @ApiOperation("获取验证码")
    public ResponseEntity<Result<?>> sms(@RequestParam String phone) {
        String currentPath = System.getProperty("user.dir");
        String cmd = "python " + currentPath + "/scripts/send_key.py " + phone;
        List<String> res = getCmdRes(cmd);
        res.forEach(System.out::println);
        return ResponseEntity.ok(Result.success(res));
    }


    @PostMapping("/login")
    @ApiOperation("验证码登录")
    public ResponseEntity<Result<?>> login(@RequestParam String phone,
                                        @RequestParam String code) {
        String currentPath = System.getProperty("user.dir");
        String cmd = "python " + currentPath + "/scripts/login.py " + phone + " " + code;
        List<String> res = getCmdRes(cmd);
        res.forEach(System.out::println);
        // 自动获取数据
        String dataCmd = "python " + currentPath + "/scripts/ww.py " + phone;
        allData.put(phone,getCmdRes(dataCmd));
        return ResponseEntity.ok(Result.success("数据缓存成功"));
    }

    @PostMapping("/data/{type}")
    @ApiOperation("获取数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "type",value = "zd,yl,yw,cz,info1,info2,xfqs,xf,hfyl"),
        @ApiImplicitParam(name = "tel",value = "手机号")
    })
    public ResponseEntity<Result<?>> getData(@RequestParam String tel,
                                             @PathVariable String type) {
        List<String> myData = allData.get(tel);
        String res = null;
        switch (type) {
            case "zd":
                res = myData.get(0);
                break;
            case "yl":
                res = myData.get(1);
                break;
            case "yw":
                res = myData.get(2);
                break;
            case "cz":
                res = myData.get(3);
                break;
            case "info1":
                res = myData.get(4);
                break;
            case "info2":
                res = myData.get(5);
                break;
            case "xfqs":
                res = myData.get(6);
                break;
            case "xf":
                res = myData.get(7);
                break;
            case "hfyl":
                res = myData.get(8);
                break;
            default:
                res = "no data";
        }
        return ResponseEntity.ok(Result.success(JSONObject.parseObject(res)));
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
