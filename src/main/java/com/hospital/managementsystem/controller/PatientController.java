package com.hospital.managementsystem.controller;

import com.hospital.managementsystem.domin.vo.PatientVo;
import com.hospital.managementsystem.service.PatientServiceImpl;
import com.hospital.managementsystem.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ning.wang
 * @date 2021/4/28 21:11
 */
@RestController
@RequestMapping("/yapi/patient")
public class PatientController {
  @Autowired
  private PatientServiceImpl service;

  @RequestMapping("/add")
  public Result add(@RequestBody PatientVo patientVo) {
    return service.add(patientVo);
  }

  @RequestMapping("/delete")
  public Result delete(String id) {
    return service.delete(id);
  }

  @RequestMapping("/update")
  public Result update(@RequestBody PatientVo patientVo) {
    return service.update(patientVo);
  }

  @RequestMapping("/select")
  public Result select(String id) {
    return service.select(id);
  }

  @RequestMapping("/list")
  public Result list() {
    return service.list();
  }
}
