package com.example.wx_1025.util;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TokenUtilTest {

    @Autowired
    private TokenUtil util;
    @Test
    void requestForToken() {
        util.requestForToken();

    }

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
    void test1(){
        String token = util.getToken();
        System.out.println(token);
    }
}