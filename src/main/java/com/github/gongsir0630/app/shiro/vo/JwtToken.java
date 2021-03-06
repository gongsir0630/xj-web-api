package com.github.gongsir0630.app.shiro.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author <a href="https://github.com/gongsir0630">码之泪殇</a>
 * @date 2021/3/29 14:11
 * 你的指尖,拥有改变世界的力量
 * @description 鉴权用的token，需要实现 AuthenticationToken
 */
@Data
@AllArgsConstructor
public class JwtToken implements AuthenticationToken {
  private String token;
  @Override
  public String getPrincipal() {
    return token;
  }

  @Override
  public String getCredentials() {
    return token;
  }
}
