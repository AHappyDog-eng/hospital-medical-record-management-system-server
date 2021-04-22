package com.hospital.managementsystem.service;

import com.alibaba.fastjson.JSON;
import com.hospital.managementsystem.domin.Test;
import com.hospital.managementsystem.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ning.wang
 * @date 2021/4/22 17:39
 */

@Service
public class TestServiceImpl implements TestService {
  @Autowired
  TestMapper testMapper;


  @Override
  public String getUser(String id) {
    Test user = testMapper.getUser(id);
    return JSON.toJSONString(user);
  }
}
