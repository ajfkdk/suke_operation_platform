package com.example.wx_1025.util;

import com.example.wx_1025.config.WxConfig;
import com.example.wx_1025.domain.AccessToken;
import com.example.wx_1025.enums.WxMpApiUrl;
import com.example.wx_1025.my_annotation.redisAnnotation;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 * The type Token util.
 *
 * @program: wx_1025
 * @description:
 * @author: chenzou
 * @create: 2021 -10-25 17:45
 */
@Slf4j
@Component

public class TokenUtil {
    //存token 的key名字
    private final String ACCESS_TOKEN_KEY = "ACCESSTOKENKEY";


    @Autowired
    private WxConfig config;

    @Autowired
    private RestTemplateUtils restTemplateUtils;

    @Autowired
    private RedisUtil redisUtil;

    /**
     * Request for token.向微信获取access token
     */
    public void requestForToken(){
        String url = WxMpApiUrl.api.GET_ACCESS_TOKEN.getUrl().replace("APPID", config.getAppId()).replace("APPSECRET", config.getSecret());
        ResponseEntity<AccessToken> accessToken = restTemplateUtils.get(url, AccessToken.class);
        AccessToken body = accessToken.getBody();
        redisUtil.set(ACCESS_TOKEN_KEY, body.getAccess_token(), body.getExpires_in());
    }

    /**
     * Is token valid boolean.判断token是否有效
     *
     * @return the boolean
     */
    @redisAnnotation
    public boolean isTokenValid() {
            return redisUtil.hasKey(ACCESS_TOKEN_KEY);
    }

    /**
     * Get token string.获取token
     *
     * @return the string
     */
    @redisAnnotation
    public String  getToken(){
        if (isTokenValid()) {
            System.out.println("find  a token");
        }else {
            System.out.println("no token here>>>>");
            requestForToken();
            getToken();
        }
        return redisUtil.get(ACCESS_TOKEN_KEY);
    }

    /**
     * Force token refresh.强制让token刷新时间
     */
    public void forceTokenRefresh(){
        redisUtil.del(ACCESS_TOKEN_KEY);
        requestForToken();
    }
}
