package com.example.wx_1025.domain;

import lombok.Data;

/**
 * @program: test
 * @description: wx的token实体类
 * @author: chenzou
 * @create: 2021-10-20 20:12
 **/

@Data
public class AccessToken  {
    //获取到的凭证
    String access_token;
    //凭证有效时间
    int expires_in;
}
