package com.zhangxiang.model;

import org.apache.ibatis.annotations.Mapper;

public class About {
    private Integer aboutId;

    private String aboutTitle;

    private String aboutContent;

    private String aboutSubscript;

    public About() {
    }

    public About(String aboutTitle, String aboutContent, String aboutSubscript) {
        this.aboutTitle = aboutTitle;
        this.aboutContent = aboutContent;
        this.aboutSubscript = aboutSubscript;
    }

    public Integer getAboutId() {
        return aboutId;
    }

    public void setAboutId(Integer aboutId) {
        this.aboutId = aboutId;
    }

    public String getAboutTitle() {
        return aboutTitle;
    }

    public void setAboutTitle(String aboutTitle) {
        this.aboutTitle = aboutTitle;
    }

    public String getAboutContent() {
        return aboutContent;
    }

    public void setAboutContent(String aboutContent) {
        this.aboutContent = aboutContent;
    }

    public String getAboutSubscript() {
        return aboutSubscript;
    }

    public void setAboutSubscript(String aboutSubscript) {
        this.aboutSubscript = aboutSubscript;
    }
}
