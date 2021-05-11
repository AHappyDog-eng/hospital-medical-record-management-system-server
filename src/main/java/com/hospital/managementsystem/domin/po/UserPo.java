package com.hospital.managementsystem.domin.po;

import lombok.Data;

/**
 * @author ning.wang
 * @date 2021/5/10 23:04
 */
@Data
public class UserPo {
  // 医生编号
  public String number;
  public String username;
  public String password;
  public String name;
  public String sex;
  public String age;
  /**
   * 联系电话：telphone
   * 家庭住址：homeAddress
   * 所属科室：department
   * 职位：position
   */
  public String telPhone;
  public String homeAddress;
  public String department;
  public String position;
}
