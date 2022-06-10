package com.ldzy.rjxh.model;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Auction:XWD
 * @Data:2022/6/1
 * @Description: ${向文定_测试版本}
 * @version:1.0
 */

@Component
public class Picture {
    private Integer pictureid; // 图片编号
    private Integer bulletinid; // 所属告示编号
    private String pictureurl; // 图片保存地址
    private Date picturedate; // 图片最新更改时间

    public Picture() {
    }

    @Override
    public String toString() {
        return "Picture{" +
                "pictureid=" + pictureid +
                ", bulletinid=" + bulletinid +
                ", pictureurl='" + pictureurl + '\'' +
                ", picturedate=" + picturedate +
                '}';
    }



    public Integer getPictureid() {
        return pictureid;
    }

    public void setPictureid(Integer pictureid) {
        this.pictureid = pictureid;
    }

    public Integer getBulletinid() {
        return bulletinid;
    }

    public void setBulletinid(Integer bulletinid) {
        this.bulletinid = bulletinid;
    }

    public String getPictureurl() {
        return pictureurl;
    }

    public void setPictureurl(String pictureurl) {
        this.pictureurl = pictureurl;
    }

    public Date getPicturedate() {
        return picturedate;
    }

    public void setPicturedate(Date picturedate) {
        this.picturedate = picturedate;
    }
}
