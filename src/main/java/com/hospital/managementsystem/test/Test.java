package com.hospital.managementsystem.test;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import java.util.ArrayList;

/**
 * @author ning.wang
 * @date 2021/5/9 1:13
 */
public class Test {
  public static void main(String[] args) {
    ArrayList<Integer> list = Lists.newArrayList();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    System.out.println(JSON.toJSONString(list));
  }
}
