package com.github.gongsir0630.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.gongsir0630.app.mapper.SecretKeyMapper;
import com.github.gongsir0630.app.model.project.SecretKey;
import com.github.gongsir0630.app.service.SecretKeyService;
import org.springframework.stereotype.Service;

/**
 * @author <a href="https://github.com/gongsir0630">码之泪殇</a>
 * @date 2021/4/10 19:38
 * 你的指尖,拥有改变世界的力量
 * @description 秘钥信息接口实现
 */
@Service
public class SecretKeyServiceImpl extends ServiceImpl<SecretKeyMapper, SecretKey> implements SecretKeyService {
  /**
   * 通过平台名称获取 ak 和 sk
   *
   * @param name 名称
   * @return 秘钥信息
   */
  @Override
  public SecretKey getSkByPlatName(String name) {
    SecretKey key = new SecretKey();
    key.setPlatName("七牛云");
    key.setId(1);
    key.setAk("AK");
    key.setSk("SK");
    return key;
  }
}
