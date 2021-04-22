package com.hospital.managementsystem.controller;

import com.hospital.managementsystem.service.TestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ning.wang
 * @date 2021/4/22 17:41
 */
@RestController
public class TestController {
  @Autowired
  private TestServiceImpl testService;

  @RequestMapping("/test")
  public String test(String test) {
    return testService.getUser(test);
  }
}
