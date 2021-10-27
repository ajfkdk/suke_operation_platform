package com.example.wx_1025;

import com.example.wx_1025.config.WxConfig;
import com.example.wx_1025.domain.MpStatisticsUser;
import com.example.wx_1025.domain.TimeHorizon;
import com.example.wx_1025.enums.WxMpApiUrl;
import com.example.wx_1025.util.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Slf4j
@SpringBootTest
class Wx1025ApplicationTests {

//    @Test
//    void contextLoads() {
//        System.out.println(WxMpApiUrl.api.DEL_GUIDE_IMAGE_MATERIAL);
//        System.out.println(WxMpApiUrl.api.DEL_GUIDE_IMAGE_MATERIAL.getUrl());
//    }
@Autowired
private RedisUtil redisUtil;
    @Autowired
    private WxConfig config;
    @Autowired
    RestTemplateUtils util;
    @Autowired
    private RestTemplateUtils restTemplateUtils;
    @Autowired
    private TokenUtil tokenUtil;

    @Test
    public void test3(){
        System.out.println(WxMpApiUrl.api.GET_ACCESS_TOKEN.getUrl());
    }





    @Test
    public void test(){
        ResponseEntity<String> stringResponseEntity = util.get("http://www.baidu.com", String.class);

    }


    @Test
    public void test1(){
        redisUtil.set("nihao","这个一个随便测试的字段",5);
    }

    @Test
    public void test2(){
//        MpStatisticsUser dao = new MpStatisticsUser();
//        dao.setNewUser(1);
//        dao.setCancelUser(3);
//        dao.setCumulateUser(899);
//        dao.setId(1);
//        boolean insert = dao.insert();
//        System.out.println(insert?"success":"fail");
    }


    @Test
    public void test4(){
        MpStatisticsUser mpStatisticsUser = new MpStatisticsUser();
        MpStatisticsUser mpStatisticsUser1 = mpStatisticsUser.selectById(1);
        System.out.println(mpStatisticsUser1.toString());
    }


/*
* 请求并封装
*
* {"list":[{"ref_date":"2021-10-21","user_source":0,"new_user":0,"cancel_user":0},{"ref_date":"2021-10-22","user_source":0,"new_user":0,"cancel_user":0},{"ref_date":"2021-10-22","user_source":17,"new_user":1,"cancel_user":1},{"ref_date":"2021-10-22","user_source":30,"new_user":1,"cancel_user":0}]}
* */
    @Test
    public void test5(){


        String token = tokenUtil.getToken();
        String CumulateUrl = WxMpApiUrl.api.GET_USER_CUMULATE.getUrl().replace("ACCESS_TOKEN", token);
        TimeHorizon timeHorizon = TimeUtil.fastTimeHorizon("2021-10-22", "2021-10-22");
        System.out.println("组装好的时间事件："+timeHorizon.toString());
        String TimeJson = JsonUtil.objecttoJsonString(timeHorizon);
        ResponseEntity<String> post = restTemplateUtils.post(CumulateUrl, TimeJson, String.class);
        if(!Objects.requireNonNull(post.getBody()).contains("45009")){
            String body = post.getBody();
            assert body != null;
            String s = JsonUtil.formatJson(body);
            List list = JsonUtil.jsonStringToObject(s, List.class);
            System.out.println(body);
        }else {
            log.error("微信接口的调用次数已经达到上限");
        }

    }




    
}
