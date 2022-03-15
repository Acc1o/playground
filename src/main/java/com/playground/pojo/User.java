package com.playground.pojo;


public class User {

  private String id;
  private String name;
  private String phone;
  private String userno;
  private String pwd;
  private long isforbidden;
  private String disablethereason;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }


  public String getUserno() {
    return userno;
  }

  public void setUserno(String userno) {
    this.userno = userno;
  }


  public String getPwd() {
    return pwd;
  }

  public void setPwd(String pwd) {
    this.pwd = pwd;
  }


  public long getIsforbidden() {
    return isforbidden;
  }

  public void setIsforbidden(long isforbidden) {
    this.isforbidden = isforbidden;
  }


  public String getDisablethereason() {
    return disablethereason;
  }

  public void setDisablethereason(String disablethereason) {
    this.disablethereason = disablethereason;
  }

}
