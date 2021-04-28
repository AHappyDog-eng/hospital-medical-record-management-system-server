package com.hospital.managementsystem.domin.vo;

import lombok.Data;

/**
 * @author ning.wang
 * @date 2021/4/29 0:40
 * 病例实体
 */
@Data
public class CaseVo {
  private String id;
  /**身份证号*/
  private String personId;
  private String name;
  private String sex;
  private String age;
  private String interHospitalTime;
  /**科室*/
  private String subject;
  /**病名称*/
  private String illness;
  /**籍贯住址*/
  private String nativePlace;
  private String tel;
}
