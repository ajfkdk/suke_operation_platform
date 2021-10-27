package com.example.wx_1025.util;

import com.alibaba.fastjson.JSON;

/**
 * @program: wx_1025
 * @description: 关于json解析的工具类
 * @author: chenzou
 * @create: 2021-10-27 10:55
 **/
public class JsonUtil {

    public static String objecttoJsonString(Object javaObject){

        return JSON.toJSONString(javaObject);
    }

    public static <T> T jsonStringToObject(String jsonString,Class<T> clazz ){

        return JSON.parseObject(jsonString, clazz);

    }

    public static String formatJson(String requestJsonFromWx){
        return requestJsonFromWx.substring(requestJsonFromWx.indexOf("["), requestJsonFromWx.indexOf("]")+1);
    }

}
