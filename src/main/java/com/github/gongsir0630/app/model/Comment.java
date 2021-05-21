package com.github.gongsir0630.app.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * @author <a href="https://github.com/gongsir0630">码之泪殇</a>
 * @date 2021/5/18 16:55
 * 你的指尖,拥有改变世界的力量
 * @description description
 */
@Data
public class Comment {
    @TableId(value = "phone",type = IdType.INPUT)
    private String phone;
    @JSONField(format = "yyyy-MM-dd")
    private Date publishTime;
    private String text;
    private Integer num;
}
