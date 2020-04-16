package com.bw.zhangzhenming20200414.net;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 时间：2020/4/14
 * 作者：张振明
 * 类的作用：
 */
public class JudgeUtil {
    //正则
    public static  boolean getPhone(String phone){
        Pattern compile = Pattern.compile("^1[0-9]{10}$");
        Matcher matcher = compile.matcher(phone);
        boolean matches = matcher.matches();
        return matches;
    }

    public static  boolean getPwd(String pwd){
        Pattern compile = Pattern.compile("^[a-zA-Z][a-zA-Z0-9]{5,10}$");
        Matcher matcher = compile.matcher(pwd);
        boolean matches = matcher.matches();
        return matches;
    }
}
