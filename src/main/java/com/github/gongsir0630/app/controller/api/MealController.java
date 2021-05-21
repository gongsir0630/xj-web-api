package com.github.gongsir0630.app.controller.api;

import com.github.gongsir0630.app.controller.res.Result;
import com.github.gongsir0630.app.service.MealService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author <a href="https://github.com/gongsir0630">码之泪殇</a>
 * @date 2021/5/18 17:11
 * 你的指尖,拥有改变世界的力量
 * @description description
 */
@RestController
@Api(tags = "套餐信息接口")
@Slf4j
@RequestMapping("/meal")
public class MealController {

    @Resource
    private MealService mealService;

    @GetMapping("list")
    public ResponseEntity<Result<?>> list() {
        return ResponseEntity.ok(Result.success(this.mealService.list()));
    }

    @GetMapping("list/{id}")
    public ResponseEntity<Result<?>> list(@PathVariable int id) {
        return ResponseEntity.ok(Result.success(this.mealService.getById(id)));
    }
}
