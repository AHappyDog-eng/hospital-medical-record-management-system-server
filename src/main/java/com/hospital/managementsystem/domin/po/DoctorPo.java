package com.hospital.managementsystem.domin.po;

import lombok.Data;

/**
 * @author ning.wang
 * @date 2021/5/12 22:03
 */
@Data
public class DoctorPo {
  //医生关联表唯一numberId
  private Integer id;
  private String numberId;
  private String name;
  private String sex;
  private String age;
  private String tel;
  private String homeAddress;
  private String departmentId;
  private String department;
  private String position;
}
