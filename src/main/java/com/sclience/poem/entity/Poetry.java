package com.sclience.poem.entity;

import java.util.Date;

/**
 * Created by 王克强 on 2018/7/16.
 */
public class Poetry {
    private int poetry_id;
    private String poetry_content;
    private String poetry_title;
    private Date poetry_createtime;
    private Date poetry_updatetime;
    private Poet poet;

    public Poetry() {
    }

    public Poetry(int poetry_id, String poetry_content, String poetry_title, Date poetry_createtime, Date poetry_updatetime, Poet poet) {
        this.poetry_id = poetry_id;
        this.poetry_content = poetry_content;
        this.poetry_title = poetry_title;
        this.poetry_createtime = poetry_createtime;
        this.poetry_updatetime = poetry_updatetime;
        this.poet = poet;
    }

    public int getPoetry_id() {
        return poetry_id;
    }

    public void setPoetry_id(int poetry_id) {
        this.poetry_id = poetry_id;
    }

    public String getPoetry_content() {
        return poetry_content;
    }

    public void setPoetry_content(String poetry_content) {
        this.poetry_content = poetry_content;
    }

    public String getPoetry_title() {
        return poetry_title;
    }

    public void setPoetry_title(String poetry_title) {
        this.poetry_title = poetry_title;
    }

    public Date getPoetry_createtime() {
        return poetry_createtime;
    }

    public void setPoetry_createtime(Date poetry_createtime) {
        this.poetry_createtime = poetry_createtime;
    }

    public Date getPoetry_updatetime() {
        return poetry_updatetime;
    }

    public void setPoetry_updatetime(Date poetry_updatetime) {
        this.poetry_updatetime = poetry_updatetime;
    }

    public Poet getPoet() {
        return poet;
    }

    public void setPoet(Poet poet) {
        this.poet = poet;
    }

    @Override
    public String toString() {
        return "Poetry{" +
                "poetry_id=" + poetry_id +
                ", poetry_content='" + poetry_content + '\'' +
                ", poetry_title='" + poetry_title + '\'' +
                ", poetry_createtime=" + poetry_createtime +
                ", poetry_updatetime=" + poetry_updatetime +
                ", poet=" + poet +
                '}';
    }
}
