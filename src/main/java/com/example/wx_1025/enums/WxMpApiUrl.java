package com.example.wx_1025.enums;

import com.example.wx_1025.config.WxConfig;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * The interface Wx mp api url.
 *
 * @program: wx_1025
 * @description:
 * @author: chenzou
 * @create: 2021 -10-25 11:18
 */
public interface WxMpApiUrl {


    /**
     * Gets url.
     *
     * @return the url
     */
    default String getUrl() {
        return this.getPrefix() + this.getPath();
    }

    /**
     * Gets path.
     *
     * @return the path
     */
    String getPath();

    /**
     * Gets prefix.
     *
     * @return the prefix
     */
    String getPrefix();

    /**
     * The enum Api.可以快速获取微信url的枚举类
     */
    public static enum api implements WxMpApiUrl {

        /**
         * Getusercumulate api.获取积累的用户数据
         */
        GET_USER_CUMULATE("https://api.weixin.qq.com", "/datacube/getusersummary?access_token=ACCESS_TOKEN"),
        /**
         * Getusersummary api.获取用户增减数据
         */
        GET_USER_SUMMARY("https://api.weixin.qq.com","/datacube/getusercumulate?access_token=ACCESS_TOKEN"),
        /**
         * Get access token api.获取通行令牌
         */
        GET_ACCESS_TOKEN("https://api.weixin.qq.com","/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET");
        private final String prefix;
        private final String path;

         api(String prefix, String path) {
            this.prefix = prefix;
            this.path = path;
        }

        @Override
        public String getPath() {
            return this.path;
        }

        @Override
        public String getPrefix() {
            return this.prefix;
        }
    }
    }
