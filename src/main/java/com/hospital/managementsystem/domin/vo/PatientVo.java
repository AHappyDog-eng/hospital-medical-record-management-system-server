package com.hospital.managementsystem.domin.vo;

import com.hospital.managementsystem.utils.Murmur;
import lombok.Data;


/**
 * @author ning.wang
 * @date 2021/4/28 21:04
 */
@Data
public class PatientVo {
  //唯一标志
  private String id;
  private String patientName;
  private String age;
  private String sex;
  private String height;
  private String weight;
  private String tel;
  // 首次录入时间时间戳
  private Long firstTime;

  // 生成用来生成外键
  private String caseOfPatientId;

  public void generateCaseOfPatientId() {
    this.caseOfPatientId = Murmur.hash(this.patientName, tel, firstTime);
  }
}
