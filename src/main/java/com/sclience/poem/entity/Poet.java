package com.sclience.poem.entity;

import java.util.Date;
import java.util.List;

/**
 * Created by 王克强 on 2018/7/16.
 */
public class Poet {
    private int poet_id;
    private String poet_name;
    private Date createTime;
    private Date updateTime;
    private List<Poetry> list;
    public Poet() {
    }

    public Poet(int poet_id, String poet_name, Date createTime, Date updateTime, List<Poetry> list) {
        this.poet_id = poet_id;
        this.poet_name = poet_name;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.list = list;
    }

    public int getPoet_id() {
        return poet_id;
    }

    public void setPoet_id(int poet_id) {
        this.poet_id = poet_id;
    }

    public String getPoet_name() {
        return poet_name;
    }

    public void setPoet_name(String poet_name) {
        this.poet_name = poet_name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public List<Poetry> getList() {
        return list;
    }

    public void setList(List<Poetry> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Poet{" +
                "poet_id=" + poet_id +
                ", poet_name='" + poet_name + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", list=" + list +
                '}';
    }
}
