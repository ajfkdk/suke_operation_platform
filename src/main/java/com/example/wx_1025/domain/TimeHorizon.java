package com.example.wx_1025.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


/**
 * @program: wx_1025
 * @description: 用于表示时间范围的bean
 * @author: chenzou
 * @create: 2021-10-26 19:02
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimeHorizon {
    String begin_date;
    String end_date;
}
