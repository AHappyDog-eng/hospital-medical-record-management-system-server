package com.hospital.managementsystem.enums;

/**
 * @author ning.wang
 * @date 2021/4/22 18:31
 */
public enum  RoleEnum {
  DOCTOR(1,"doctor"),
  ADMIN(2,"admin");
  private int power;
  private String remark;

  RoleEnum(int power, String remark) {
    this.power = power;
    this.remark = remark;
  }

  public int getPower() {
    return power;
  }
  public String getRemark(){
    return remark;
  }
}
