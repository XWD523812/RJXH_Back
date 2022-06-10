package com.ldzy.rjxh.model;

import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @Auction:XWD
 * @Data:2022/6/1
 * @Description: ${向文定_测试版本}
 * @version:1.0
 */

@Component
public class Bulletin {
    private Integer bulletinid; // 告示编号
    private Integer memberid; // 所属成员编号
    private String bulletintitle; // 告示标题
    private String bulletinbody; // 告示内容
    private String bulletinclass; // 告示类型
    private Date bulletindate; // 最后更新时间
    private Integer bulletinstate; // 告示状态 0？1
    private Integer attendance; // 浏览数量

    private List<Picture> pictures;

    public Bulletin() {
    }

    @Override
    public String toString() {
        return "Bulletin{" +
                "bulletinid=" + bulletinid +
                ", memberid=" + memberid +
                ", bulletintitle='" + bulletintitle + '\'' +
                ", bulletinbody='" + bulletinbody + '\'' +
                ", bulletinclass='" + bulletinclass + '\'' +
                ", bulletindate=" + bulletindate +
                ", bulletinstate=" + bulletinstate +
                ", attendance=" + attendance +
                ", pictures=" + pictures +
                '}';
    }

    public Integer getBulletinid() {
        return bulletinid;
    }

    public void setBulletinid(Integer bulletinid) {
        this.bulletinid = bulletinid;
    }

    public Integer getMemberid() {
        return memberid;
    }

    public void setMemberid(Integer memberid) {
        this.memberid = memberid;
    }

    public String getBulletintitle() {
        return bulletintitle;
    }

    public void setBulletintitle(String bulletintitle) {
        this.bulletintitle = bulletintitle;
    }

    public String getBulletinbody() {
        return bulletinbody;
    }

    public void setBulletinbody(String bulletinbody) {
        this.bulletinbody = bulletinbody;
    }

    public String getBulletinclass() {
        return bulletinclass;
    }

    public void setBulletinclass(String bulletinclass) {
        this.bulletinclass = bulletinclass;
    }

    public Date getBulletindate() {
        return bulletindate;
    }

    public void setBulletindate(Date bulletindate) {
        this.bulletindate = bulletindate;
    }

    public Integer getBulletinstate() {
        return bulletinstate;
    }

    public void setBulletinstate(Integer bulletinstate) {
        this.bulletinstate = bulletinstate;
    }

    public Integer getAttendance() {
        return attendance;
    }

    public void setAttendance(Integer attendance) {
        this.attendance = attendance;
    }

    public List<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }
}
