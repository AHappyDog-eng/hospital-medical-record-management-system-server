package com.hospital.managementsystem.service;

import com.hospital.managementsystem.domin.User;
import com.hospital.managementsystem.enums.Status;
import com.hospital.managementsystem.mapper.UserMapper;
import com.hospital.managementsystem.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.hospital.managementsystem.enums.Status.USER_EXIST_ERROR;

/**
 * @author ning.wang
 * @date 2021/4/22 18:54
 */
@Service
public class UserServiceImpl implements UserService {
  @Autowired
  private UserMapper userMapper;

  @Override
  public Result register(User user) {
    if (findByUserName(user.getUsername()) != null) {
     return new Result(USER_EXIST_ERROR);
    }
    userMapper.register(user);
    return new Result(Status.SUCCESS);
  }

  @Override
  public Result login(String username, String password) {
    return null;
  }

  @Override
  public Result update(String oldPassword, String newPassword, String username) {
    return null;
  }

  @Override
  public Result delete(String username) {
    return null;
  }

  @Override
  public User findByUserName(String username) {
    User user = userMapper.findByUserName(username);
    return null;
  }


}
