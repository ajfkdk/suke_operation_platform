package com.example.wx_1025.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @program: wx_1025
 * @description: 微信基本信息的配置类
 * @author: chenzou
 * @create: 2021-10-26 08:56
 **/
@Component
@Data
@ConfigurationProperties(prefix= "wx.configs")
public class WxConfig {
    String AppId;
    String Secret;
    String Token;
    String AesKey;
}
