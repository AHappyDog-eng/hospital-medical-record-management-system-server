package com.hospital.managementsystem.controller;

import com.hospital.managementsystem.domin.po.CasePo;
import com.hospital.managementsystem.domin.po.DepartmentPo;
import com.hospital.managementsystem.domin.po.DoctorPo;
import com.hospital.managementsystem.domin.po.PatientPo;
import com.hospital.managementsystem.service.*;
import net.sf.oval.constraint.AssertURL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author ning.wang
 * @date 2021/4/22 17:41
 */
@RestController
public class TestController {
  @Autowired
  private TestServiceImpl testService;

  @Autowired
  private CaseServiceImpl caseService;

  @Autowired
  private PatientServiceImpl service;

  @Autowired
  private DepartmentServiceImpl departmentService;
  @Autowired
  private DoctorServiceImpl doctorService;

  @RequestMapping("/doc/add")
  public String addDoc(){
    DoctorPo po = new DoctorPo();
    for (int i = 0; i < 20; i++) {
      System.out.println(i);
      po.setAge(String.valueOf(i));
      po.setDepartment(UUID.randomUUID().toString().substring(0,18));
      po.setHomeAddress(UUID.randomUUID().toString().substring(0,15));
      po.setName(UUID.randomUUID().toString().substring(0,2));
      po.setNumberId(UUID.randomUUID().toString().substring(0,18));
      po.setPosition(UUID.randomUUID().toString().substring(0,15));
      String sex = "女";
      if (i%2==0){
        sex = "男";
      }
      po.setSex(sex);
      po.setTel(UUID.randomUUID().toString().substring(0,11));
      doctorService.add(po);
    }
    return "ok";
  }


  @RequestMapping("/dep/add")
  public String addDep() {
    DepartmentPo po = new DepartmentPo();
    for (int i = 0; i < 20; i++) {
      po.setDepartmentId(UUID.randomUUID().toString().substring(0, 18));
      po.setDepartmentName(UUID.randomUUID().toString().substring(0, 10));
      po.setDepartmentDirectorName(UUID.randomUUID().toString().substring(0, 3));
      departmentService.add(po);
    }
    return "ok";
  }


  @RequestMapping("/patient/test")
  public String test11() {
    int i = 3;
    PatientPo patientPo = new PatientPo();
    CasePo casePo = new CasePo();
    for (int j = 0; j < 20; j++) {
      patientPo.setAge(String.valueOf(j * 2));
      patientPo.setCurrentAddress(UUID.randomUUID().toString());
      String idNumber = UUID.randomUUID().toString().substring(0, 18);
      patientPo.setIdNumber(idNumber);
      casePo.setIdNumber(idNumber);

      String name = UUID.randomUUID().toString().substring(0, 3);
      patientPo.setName(name);
      casePo.setName(name);

      String sex = j % 2 == 1 ? "男" : "女";
      patientPo.setSex(sex);
      casePo.setSex(sex);

      patientPo.setTelPhone(UUID.randomUUID().toString().substring(0, 11));
      patientPo.setStatus(UUID.randomUUID().toString().substring(0, 2));
      service.add(patientPo);
      System.out.println("正在插入................." + i);
      casePo.setAddressOfVisit(UUID.randomUUID().toString().substring(0, 18));
      casePo.setAge(String.valueOf(j * 2));
      casePo.setDateOfVisit(UUID.randomUUID().toString().substring(0, 12));
      casePo.setDiagnosisResult(UUID.randomUUID().toString().substring(0, 2));
      casePo.setMedicalHistory(UUID.randomUUID().toString().substring(1, 19));
      casePo.setSymptom(UUID.randomUUID().toString().substring(0, 12));
      casePo.setTreatmentSuggestion(UUID.randomUUID().toString().substring(15));
      casePo.setVisitingDoctor("none");
      caseService.add(casePo);

      i = i * 2;
    }
    return "ok";
  }


  @RequestMapping("/test")
  public String test(String test) {
    return testService.getUser(test);
  }

}
