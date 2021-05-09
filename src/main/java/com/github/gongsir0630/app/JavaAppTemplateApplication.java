package com.github.gongsir0630.app;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;

/**
 * @author <a href="https://github.com/gongsir0630">码之泪殇</a>
 * @date 2021/3/29 12:44
 * 你的指尖,拥有改变世界的力量
 */
@SpringBootApplication
public class JavaAppTemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaAppTemplateApplication.class, args);
    }

  /**
   * fastjson 配置注入: 使用阿里巴巴的 fastjson 处理 json 信息
   * @return HttpMessageConverters
   */
  @Bean
  public HttpMessageConverters fastJsonMessageConverters() {
    // fastjson 消息转换对象
    FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
    // fastjson 配置
    FastJsonConfig config = new FastJsonConfig();
    config.setSerializerFeatures(SerializerFeature.PrettyFormat);
    // 时间格式转换: 在实体类字段上使用:
    // @DateTimeFormat(pattern = "yyyy-MM-dd")
    // @JSONField(format = "yyyy-MM-dd")
    // 配置注入消息转换器
    converter.setFastJsonConfig(config);
    // 让 spring 使用自定义的消息转换器
    return new HttpMessageConverters(converter);
  }
}
