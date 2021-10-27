package com.example.wx_1025.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.sql.Date;

/**
 * @program: wx_1025
 * @description: 用户统计bean
 * @author: chenzou
 * @create: 2021-10-26 10:59
 **/
@Data
public class MpStatisticsUser extends Model<MpStatisticsUser> {
    private int id;
    private Date ref_date;
    private int user_source;
    private int new_user;
    private int cancel_user;
    private int cumulate_user;
}
