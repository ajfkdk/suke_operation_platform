package com.example.wx_1025.util;

import com.alibaba.fastjson.JSON;
import com.example.wx_1025.domain.MpStatisticsUser;
import com.example.wx_1025.domain.TimeHorizon;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

/**
 * @program: wx_1025
 * @description:
 * @author: chenzou
 * @create: 2021-10-27 10:20
 **/
@SpringBootTest
public class JsonUtilTest {

    @Test
    public void test(){
        Calendar currentTime = TimeUtil.getCurrentTime();
        Calendar beforeDay = TimeUtil.getBeforeDay(currentTime,2);
        String currentday=TimeUtil.dimFormatDate(currentTime.getTime());
        String beforday = TimeUtil.dimFormatDate(beforeDay.getTime());
        TimeHorizon timeHorizon = new TimeHorizon(beforday,currentday);

        String s = JSON.toJSONString(timeHorizon);
        System.out.println(s);
    }

    @Test
    public void test1(){
        String dataJson = "{\"beginTime\":\"2021-10-25\",\"endTime\":\"2021-10-27\"}";
        TimeHorizon timeHorizon = JSON.parseObject(dataJson, TimeHorizon.class);
        System.out.println(timeHorizon.toString());
    }

    @Test
    public void test3(){
        String json = "{\"list\":[{\"ref_date\":\"2021-10-21\",\"user_source\":0,\"new_user\":0,\"cancel_user\":0},{\"ref_date\":\"2021-10-22\",\"user_source\":0,\"new_user\":0,\"cancel_user\":0},{\"ref_date\":\"2021-10-22\",\"user_source\":17,\"new_user\":1,\"cancel_user\":1},{\"ref_date\":\"2021-10-22\",\"user_source\":30,\"new_user\":1,\"cancel_user\":0}]}";
        String s = JsonUtil.formatJson(json);
        List list = JsonUtil.jsonStringToObject(s, List.class);
        System.out.println();
    }
}
