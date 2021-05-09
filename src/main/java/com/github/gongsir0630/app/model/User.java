package com.github.gongsir0630.app.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author <a href="https://github.com/gongsir0630">码之泪殇</a>
 * @date 2021/5/9 17:08
 * 你的指尖,拥有改变世界的力量
 * @description 用户信息
 */
@TableName("user")
@Data
@ApiModel("用户信息")
public class User {
    @TableId(value = "username", type = IdType.INPUT)
    @ApiModelProperty("主键,手机号")
    private String phoneNumber;
    @ApiModelProperty("用户名")
    private String username;
    @ApiModelProperty("级别")
    private String level;
    @ApiModelProperty("当前套餐")
    private String userMeal;
    @ApiModelProperty("网龄")
    private String age;
    @ApiModelProperty("星级")
    private String star;
    @ApiModelProperty("有效期")
    private String time;
    @ApiModelProperty("用户状态")
    private String status;
    @ApiModelProperty("入网时间")
    private String date;
    @ApiModelProperty("实名认证")
    private String auth;

}
