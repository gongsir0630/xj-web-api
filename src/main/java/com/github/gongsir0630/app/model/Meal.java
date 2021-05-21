package com.github.gongsir0630.app.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author <a href="https://github.com/gongsir0630">码之泪殇</a>
 * @date 2021/5/18 11:58
 * 你的指尖,拥有改变世界的力量
 * @description description
 */
@Data
public class Meal {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private Double cost;
    private String flow;
    private String kd;
    private String voice;
    private String exvoice;
    private String exflow;
}
