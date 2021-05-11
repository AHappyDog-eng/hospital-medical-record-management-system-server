package com.hospital.managementsystem.controller;

import com.hospital.managementsystem.domin.po.PatientPo;
import com.hospital.managementsystem.domin.vo.PatientVo;
import com.hospital.managementsystem.service.PatientServiceImpl;
import com.hospital.managementsystem.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
  public Result add(@RequestBody PatientPo patientVo) {
    return service.add(patientVo);
  }

  @RequestMapping("/delete")
  public Result delete(Integer id) {
    return service.delete(id);
  }

  @RequestMapping("/update")
  public Result update(@RequestBody PatientPo patientVo) {
    return service.update(patientVo);
  }

  @RequestMapping("/select")
  public Result select(String idNumber) {
    return service.select(idNumber);
  }

  @RequestMapping("/list")
  public Result list(Integer pageNum, Integer limit) {
    return service.list(pageNum, limit);
  }

  @RequestMapping("/delete/list")
  public Result deleteList(@RequestBody List<String> ids) {
    return service.deleteList(ids);
  }
}
