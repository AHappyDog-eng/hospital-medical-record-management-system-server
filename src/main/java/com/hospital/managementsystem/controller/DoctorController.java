package com.hospital.managementsystem.controller;

import com.hospital.managementsystem.domin.po.CasePo;
import com.hospital.managementsystem.domin.po.DoctorPo;
import com.hospital.managementsystem.service.DoctorServiceImpl;
import com.hospital.managementsystem.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ning.wang
 * @date 2021/5/12 22:06
 */
@RequestMapping("/yapi/doctor")
@RestController
public class DoctorController {
  @Autowired
  private DoctorServiceImpl doctorService;

  @RequestMapping("/add")
  public Result add(@RequestBody DoctorPo doctorPo) {
    return doctorService.add(doctorPo);
  }

  @RequestMapping("/delete")
  public Result delete(Integer id) {
    return doctorService.delete(id);
  }

  @RequestMapping("/update")
  public Result update(@RequestBody DoctorPo doctorPo) {
    return doctorService.update(doctorPo);
  }

  @RequestMapping("/select")
  public Result select(Integer id) {
    return doctorService.select(id);
  }

  @RequestMapping("/list")
  public Result list(Integer pageNum, Integer limit) {
    return doctorService.list(pageNum, limit);
  }

  @RequestMapping("/list/id")
  public Result listId(String departmentId, Integer pageNum, Integer limit) {
    return doctorService.listById(departmentId, pageNum, limit);
  }

  @RequestMapping("/delete/list")
  public Result deleteList(@RequestBody List<String> ids) {
    return doctorService.deleteList(ids);
  }
}
