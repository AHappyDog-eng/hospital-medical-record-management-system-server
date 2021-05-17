package com.hospital.managementsystem.controller;

import com.hospital.managementsystem.domin.po.DepartmentPo;
import com.hospital.managementsystem.domin.po.DoctorPo;
import com.hospital.managementsystem.service.DepartmentServiceImpl;
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
@RequestMapping("/yapi/dep")
@RestController
public class DepartmentController {
  @Autowired
  private DepartmentServiceImpl departmentService;

  @RequestMapping("/add")
  public Result add(@RequestBody DepartmentPo doctorPo) {
    return departmentService.add(doctorPo);
  }

  @RequestMapping("/delete")
  public Result delete(Integer id) {
    return departmentService.delete(id);
  }

  @RequestMapping("/update")
  public Result update(@RequestBody DepartmentPo doctorPo) {
    return departmentService.update(doctorPo);
  }

  @RequestMapping("/select")
  public Result select(Integer id) {
    return departmentService.select(id);
  }

  @RequestMapping("/list")
  public Result list(Integer pageNum, Integer limit) {
    return departmentService.list(pageNum, limit);
  }


  @RequestMapping("/delete/list")
  public Result deleteList(@RequestBody List<String> ids) {
    return departmentService.deleteList(ids);
  }
}
