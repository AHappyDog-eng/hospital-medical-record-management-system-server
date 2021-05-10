package com.hospital.managementsystem.domin.po;

import lombok.Data;

/**
 * @author ning.wang
 * @date 2021/5/10 23:05
 */
@Data
public class PatientPo {
  /**病历号：medicalRecordId
   姓名：name
   身份证号：IdNumber
   性别：sex
   年龄：age
   就诊医生：visitingDoctor
   病史：medicalHistory
   症状：symptom
   诊断结果：diagnosisResult
   就诊日期：dateOfVisit
   治疗建议：treatmentSuggestion
   就诊地址：addressOfVisit
   */
  public String medicalRecordId;
  public String name;
  // 主键
  public String idNumber;
  public String sex;
  public String age;
  public String visitingDoctor;
  public String medicalHistory;
  public String symptom;
  public String diagnosisResult;
  public String dateOfVisit;
  public String treatmentSuggestion;
  public String addressOfVisit;
}
