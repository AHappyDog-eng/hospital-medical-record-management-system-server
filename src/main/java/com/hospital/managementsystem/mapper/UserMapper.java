package com.hospital.managementsystem.mapper;

import com.hospital.managementsystem.domin.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.springframework.stereotype.Repository;

/**
 * @author ning.wang
 * @date 2021/4/22 18:54
 */
@Mapper
@Repository
public interface UserMapper {
  void register(User user);

  User login(@Param("username") String username, @Param("password") String password);

  void update(@Param("oldPassword") String oldPassword, @Param("newPassword") String newPassword, @Param("username") String username);

  void delete(String username);

  User findByUserName(String username);
}
