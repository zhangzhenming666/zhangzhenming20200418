package com.bw.zhangzhenming20200414.net;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间：2020/4/14
 * 作者：张振明
 * 类的作用：
 */
public class TimeToUtil {
    //时间戳
    public static String getTime(long time) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh-MM-ss");
        String format = simpleDateFormat.format(new Date(time));
        return format;
    }
}
