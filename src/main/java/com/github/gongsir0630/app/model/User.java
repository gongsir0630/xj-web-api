package com.github.gongsir0630.app.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

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
  @TableId(value = "username",type = IdType.INPUT)
  @ApiModelProperty("用户账号")
  private String username;
  @ApiModelProperty("用户密码")
  private String password;
  @ApiModelProperty("真实姓名")
  private String realName;
  @ApiModelProperty("登陆时间")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @JSONField(format = "yyyy-MM-dd")
  private Date loginTime;
}
