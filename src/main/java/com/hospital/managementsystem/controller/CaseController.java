package com.hospital.managementsystem.controller;

import com.hospital.managementsystem.domin.vo.CaseVo;
import com.hospital.managementsystem.service.CaseServiceImpl;
import com.hospital.managementsystem.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ning.wang
 * @date 2021/4/29 1:04
 */
@RequestMapping("/yapi/case")
@RestController
public class CaseController {

  @Autowired
  private CaseServiceImpl caseService;

  @RequestMapping("/add")
  public Result add(@RequestBody CaseVo caseVo) {
    return caseService.add(caseVo);
  }

  @RequestMapping("/delete")
  public Result delete(Integer id) {
    return caseService.delete(id);
  }

  @RequestMapping("/update")
  public Result update(@RequestBody CaseVo caseVo) {
    return caseService.update(caseVo);
  }

  @RequestMapping("/select")
  public Result select(Integer id) {
    return caseService.select(id);
  }

  @RequestMapping("/list")
  public Result list() {
    return caseService.list();
  }

  @RequestMapping("/list/id")
  public Result listId(String personId){
    return caseService.listById(personId);
  }
}
