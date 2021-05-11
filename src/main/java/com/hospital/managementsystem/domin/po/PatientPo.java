package com.hospital.managementsystem.domin.po;

import lombok.Data;

/**
 * @author ning.wang
 * @date 2021/5/10 23:05
 */
@Data
public class PatientPo {

  /**姓名：name
   身份证号：IdNumber
   性别：sex
   年龄：age
   电话：telphone
   现住址：currentAddress
   状态：status
   */
  public String id;
  public String idNumber;
  public String name;
  public String sex;
  public String age;
  public String telPhone;
  public String currentAddress;
  public String status;


}
