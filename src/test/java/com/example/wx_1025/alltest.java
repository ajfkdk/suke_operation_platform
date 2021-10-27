package com.example.wx_1025;

import com.example.wx_1025.util.TokenUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @program: wx_1025
 * @description: 通用型的测试方法都在这里
 * @author: chenzou
 * @create: 2021-10-27 13:18
 **/

@SpringBootTest
public class alltest {


    @Autowired
    private TokenUtil util;

    @Test
    void tes(){
        if (util.isTokenValid()) {
            System.out.println("find  a token");
        }else {
            System.out.println("no token here>>>>");
            util.requestForToken();
            tes();
        }
    }

    @Test
    public void test2(){
        String token = util.getToken();
        System.out.println();
    }

}
