package com.hospital.managementsystem.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.hospital.managementsystem.common.Constants;
import com.hospital.managementsystem.domin.User;
import com.hospital.managementsystem.domin.po.CasePo;
import com.hospital.managementsystem.enums.RoleEnum;
import com.hospital.managementsystem.enums.Status;
import com.hospital.managementsystem.mapper.UserMapper;
import com.hospital.managementsystem.utils.Murmur;
import com.hospital.managementsystem.utils.Result;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.hospital.managementsystem.enums.Status.*;

/**
 * @author ning.wang
 * @date 2021/4/22 18:54
 */
@Service
public class UserServiceImpl implements UserService {
  @Autowired
  private UserMapper userMapper;
  @Autowired
  private Murmur murmur;

  @Override
  public Result register(User user) {
    if (StringUtils.equalsIgnoreCase(user.getRole(), RoleEnum.ADMIN.getRemark())) {
      user.setPower(RoleEnum.ADMIN.getPower());
    }

    if (findByUserName(user.getUsername()) != null) {
      return new Result(USER_EXIST_ERROR);
    }

    userMapper.register(user);
    return new Result(Status.SUCCESS);
  }

  @Override
  public Result login(String username, String password) {
    User login = userMapper.login(username, password);
    if (login != null) {
      User user = findByUserName(username);

      Result<Map> result = new Result<>(SUCCESS);
      HashMap<String, String> map = Maps.newHashMap();
      map.put("token", murmur.base64(username));
      map.put("headSculptureUrl", user.getHeadSculptureUrl());
      result.setData(map);
      return result;
    } else {
      return new Result(USERNAME_AND_PASSWORD_ERROR);
    }
  }

  @Override
  public Result update(String oldPassword, String newPassword, String username) {
    User user = userMapper.login(username, oldPassword);
    if (user == null) {
      return new Result(USER_NOT_EXIST_ERROR);
    }
    userMapper.update(oldPassword, newPassword, username);
    return new Result(SUCCESS);
  }

  @Override
  public Result delete(String username) {
    userMapper.delete(username);
    return new Result(SUCCESS);
  }

  @Override
  public User findByUserName(String username) {
    return userMapper.findByUserName(username);
  }

  @Override
  public Result list(Integer pageNum,Integer limit) {
    if (pageNum <= 0) {
      pageNum = Constants.DEFAULT_PAGE_NUM;
    }
    if (limit <= 1) {
      limit = Constants.DEFAULT_PAGE_SIZE;
    }
    PageHelper.startPage(pageNum, limit);
    List<User> list = userMapper.list();
    PageInfo<User> pageInfo = new PageInfo<>(list);
    long total = pageInfo.getTotal();
    Result<Map<String,Object>> result = new Result<>(Status.SUCCESS);
    HashMap<String, Object> hashMap = Maps.newHashMap();
    hashMap.put("result",list);
    hashMap.put("totals",total);
    result.setData(hashMap);
    return result;
  }

  public Result getUserByToken(String token) {
    String username = murmur.decode(token);
    User user = findByUserName(username);
    Result<Object> result = new Result<>(SUCCESS);
    result.setData(user);
    return result;
  }

}
