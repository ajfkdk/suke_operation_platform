package com.example.wx_1025.timetasked;

import com.example.wx_1025.util.RestTemplateUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * The type Get user number info.
 *
 * @program: wx_1025
 * @description: 获取用户信息的定时任务
 * @author: chenzou
 * @create: 2021 -10-26 18:46
 */
public class GetUserNumberInfo {


    @Autowired
    private RestTemplateUtils requestUtil;
    /**
     * Request data from wx.向微信请求获取数据
     */
    public void requestDataFromWx(){

    }

}
