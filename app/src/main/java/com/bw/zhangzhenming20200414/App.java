package com.bw.zhangzhenming20200414;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.greendao.gen.DaoMaster;
import com.greendao.gen.DaoSession;

/**
 * 时间：2020/4/14
 * 作者：张振明
 * 类的作用：
 */
public class App extends Application {
    public static Context context;
    public static DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        context=this;
        initDao();
        initFresco();
    }
    private void initDao() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(context, "cache.db");
        SQLiteDatabase writableDatabase = devOpenHelper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(writableDatabase);
        daoSession = daoMaster.newSession();
    }

    private void initFresco() {
        //自定义缓存
        DiskCacheConfig bwImage = DiskCacheConfig.newBuilder(context)
                .setMaxCacheSize(1024 * 1024 * 10)
                .setBaseDirectoryPath(Environment.getExternalStorageDirectory())
                .setBaseDirectoryName("bwImage")
                .build();
        ImagePipelineConfig build = ImagePipelineConfig.newBuilder(context)
                .setMainDiskCacheConfig(bwImage)
                .build();
        Fresco.initialize(context,build);
    }
}
