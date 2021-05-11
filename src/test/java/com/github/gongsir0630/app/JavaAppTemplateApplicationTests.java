package com.github.gongsir0630.app;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Slf4j
class JavaAppTemplateApplicationTests {

    @Test
    void testJson() {
        String str = "{\"data\": {\"remark\": null, \"realFee\": \"255.80\", \"curFee\": \"212.74\", \"curFeeTotal\": \"212.74\", \"oweFee\": \"0.00\"}, \"retCode\": \"000000\", \"retMsg\": \"success\", \"sOperTime\": \"20210511073937\"}";
        System.out.println(JSONObject.parseObject(str));
    }

    @Test
    void contextLoads() {
        String phone = "15775828083";
        Runtime runtime = Runtime.getRuntime();
        List<String> result = new ArrayList<>();
        String currentPath = System.getProperty("user.dir");
        String cmd = "python " + currentPath + "/scripts/send_key.py " + phone;
        log.info(cmd);
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
        log.info("result: {}",result);
    }

    @Test
    void testLogin() {
        String phone = "18708165836";
        String code = "111300";
        Runtime runtime = Runtime.getRuntime();
        List<String> result = new ArrayList<>();
        String currentPath = System.getProperty("user.dir");
        String cmd = "python " + currentPath + "/scripts/login.py " + phone + " " + code;
        log.info(cmd);
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
        log.info("result: {}",result);
    }

    @Test
    void testGetData() {
        String phone = "15775828083";
        Runtime runtime = Runtime.getRuntime();
        List<String> result = new ArrayList<>();
        String currentPath = System.getProperty("user.dir");
        String cmd = "python " + currentPath + "/scripts/ww.py " + phone;
        log.info(cmd);
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
        log.info("result: {}",result);
    }

}
