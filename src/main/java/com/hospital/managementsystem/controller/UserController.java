package com.hospital.managementsystem.controller;

import com.hospital.managementsystem.domin.User;
import com.hospital.managementsystem.service.UserServiceImpl;
import com.hospital.managementsystem.utils.Result;
import net.sf.oval.constraint.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ning.wang
 * @date 2021/4/22 18:53
 */
@RestController
@RequestMapping("/yapi")
public class UserController {
  @Autowired
  UserServiceImpl userService;

  @RequestMapping("register")
  public Result register(@RequestBody User user) {
    return userService.register(user);
  }

  @RequestMapping("/login")
  public Result login(@NotNull(message = "username 不能为空") String username,@NotNull(message = "password 不能为空") String password) {
    return userService.login(username, password);
  }

  @RequestMapping("/delete")
  public Result delete(String username) {
    return userService.delete(username);
  }

  @RequestMapping("/update")
  public Result update(String oldPassword, String newPassword, String username) {
    return userService.update(oldPassword, newPassword, username);
  }
}
