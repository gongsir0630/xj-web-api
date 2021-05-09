package com.github.gongsir0630.app;

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
    void contextLoads() {
        String phone = "15008211710";
        Runtime runtime = Runtime.getRuntime();
        List<String> result = new ArrayList<>();
        String currentPath = System.getProperty("user.dir");
        String cmd = "python " + currentPath + "/scripts/mobile.py " + phone;
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
        String phone = "15008211710";
        String code = "610840";
        Runtime runtime = Runtime.getRuntime();
        List<String> result = new ArrayList<>();
        String currentPath = System.getProperty("user.dir");
        String cmd = "python " + currentPath + "/scripts/ww.py " + phone + " " + code;
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
