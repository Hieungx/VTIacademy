package com.vti.dto;

import java.util.Date;

import com.vti.entity.Group;

public class GroupDTO {
	private String name;
	private short member;
	private String creator;
	private Date createDate;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public short getMember() {
		return member;
	}
	public void setMember(short member) {
		this.member = member;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public GroupDTO(String name, short member, String creator, Date createDate) {
		this.name = name;
		this.member = member;
		this.creator = creator;
		this.createDate = createDate;
	}
	
	public Group toEntity() {
		return new Group(name,member,creator,createDate);
	}

}
