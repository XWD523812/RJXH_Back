package com.ldzy.rjxh.model;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer memberid; // 成员编号（主键）
	private String membername; // 姓名
	private String password; // 密码
	private String bumen; // 部门
	private Integer force; // 总战力
	private String picture;// 头像
	private String introduce; //个人简介
	private Integer qx; // 权限

	private List<Force> forces;
	private List<Bulletin> bulletins;

	public User() {
	}

	@Override
	public String toString() {
		return "Member{" +
				"memberid=" + memberid +
				", membername='" + membername + '\'' +
				", password='" + password + '\'' +
				", bumen='" + bumen + '\'' +
				", force=" + force +
				", picture='" + picture + '\'' +
				", introduce='" + introduce + '\'' +
				", qx=" + qx +
				", forces=" + forces +
				", bulletins=" + bulletins +
				'}';
	}

	public Integer getMemberid() {
		return memberid;
	}

	public void setMemberid(Integer memberid) {
		this.memberid = memberid;
	}

	public String getMembername() {
		return membername;
	}

	public void setMembername(String membername) {
		this.membername = membername;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBumen() {
		return bumen;
	}

	public void setBumen(String bumen) {
		this.bumen = bumen;
	}

	public Integer getForce() {
		return force;
	}

	public void setForce(Integer force) {
		this.force = force;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public Integer getQx() {
		return qx;
	}

	public void setQx(Integer qx) {
		this.qx = qx;
	}

	public List<Force> getForces() {
		return forces;
	}

	public void setForces(List<Force> forces) {
		this.forces = forces;
	}

	public List<Bulletin> getBulletins() {
		return bulletins;
	}

	public void setBulletins(List<Bulletin> bulletins) {
		this.bulletins = bulletins;
	}
}
