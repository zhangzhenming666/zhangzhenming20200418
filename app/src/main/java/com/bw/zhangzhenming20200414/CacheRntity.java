package com.bw.zhangzhenming20200414;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 时间：2020/4/14
 * 作者：张振明
 * 类的作用：
 */
@Entity
public class CacheRntity {
    @Id(autoincrement = true)
    public long id;
    public String url;
    public String json;
    @Generated(hash = 520773248)
    public CacheRntity(long id, String url, String json) {
        this.id = id;
        this.url = url;
        this.json = json;
    }
    @Generated(hash = 1820081621)
    public CacheRntity() {
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getUrl() {
        return this.url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getJson() {
        return this.json;
    }
    public void setJson(String json) {
        this.json = json;
    }
}
