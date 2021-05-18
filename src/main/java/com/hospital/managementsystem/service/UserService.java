package com.hospital.managementsystem.service;

import com.hospital.managementsystem.domin.User;
import com.hospital.managementsystem.utils.Result;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ning.wang
 * @date 2021/4/22 18:54
 */
public interface UserService {
  Result register(User user);

  Result login(String username, String password);

  Result update( String oldPassword,String newPassword,String username);

  Result delete(String username);

  User findByUserName(String username);

  Result list(Integer pageNum,Integer limit);
}
