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

  @RequestMapping("/user/register")
  public Result register(@RequestBody User user) {
    return userService.register(user);
  }

  @RequestMapping("/user/login")
  public Result login(@RequestBody User user) {
    return userService.login(user.getUsername(), user.getPassword());
  }

  @RequestMapping("/user/delete")
  public Result delete(String username) {
    return userService.delete(username);
  }

  @RequestMapping("/user/update")
  public Result update(String oldPassword, String newPassword, String username) {
    return userService.update(oldPassword, newPassword, username);
  }

  @RequestMapping("/user/select/token")
  public Result selectToken(String token) {
    return userService.getUserByToken(token);
  }

  @RequestMapping("/user/list")
  public Result list(Integer pageNum,Integer limit){
    Result list = userService.list(pageNum, limit);
    return list;
  }
}
