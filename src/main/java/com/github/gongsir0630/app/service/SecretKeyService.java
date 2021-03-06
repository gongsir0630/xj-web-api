package com.github.gongsir0630.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.gongsir0630.app.model.project.SecretKey;

/**
 * @author <a href="https://github.com/gongsir0630">码之泪殇</a>
 * @date 2021/4/10 19:38
 * 你的指尖,拥有改变世界的力量
 * @description 秘钥信息接口
 */
public interface SecretKeyService extends IService<SecretKey> {
  /**
   * 通过平台名称获取 ak 和 sk
   * @param name 名称
   * @return 秘钥信息
   */
  SecretKey getSkByPlatName(String name);
}
