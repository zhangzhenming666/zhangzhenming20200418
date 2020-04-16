package com.bw.zhangzhenming20200414.net;

import android.content.Context;
import android.content.SharedPreferences;

import com.bw.zhangzhenming20200414.App;

/**
 * 时间：2020/4/14
 * 作者：张振明
 * 类的作用：
 */
public class SpUtil {
    //缓存
    public static void saveString(String key,String value){
        SharedPreferences user = App.context.getSharedPreferences("user", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = user.edit();
        edit.putString(key,value);
        edit.commit();
    }
    public static void saveInt(String key,int value){
        SharedPreferences user = App.context.getSharedPreferences("user", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = user.edit();
        edit.putInt(key,value);
        edit.commit();
    }
    public static void saveBoolean(String key,boolean value){
        SharedPreferences user = App.context.getSharedPreferences("user", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = user.edit();
        edit.putBoolean(key,value);
        edit.commit();
    }
    //取缓存
    public static String getString(String key){
        SharedPreferences user = App.context.getSharedPreferences("user", Context.MODE_PRIVATE);
        String string = user.getString(key, "");
        return string;
    }
    public static int getInt(String key){
        SharedPreferences user = App.context.getSharedPreferences("user", Context.MODE_PRIVATE);
        int anInt = user.getInt(key, -1);
        return anInt;
    }
    public static boolean getBoolean(String key){
        SharedPreferences user = App.context.getSharedPreferences("user", Context.MODE_PRIVATE);
        boolean aBoolean = user.getBoolean(key, false);
        return aBoolean;
    }
}
