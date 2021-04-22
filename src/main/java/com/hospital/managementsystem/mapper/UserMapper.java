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
  Result register(User user);

  Result login(@Param("username") String username, @Param("password") String password);

  Result update(@Param("oldPasswordc") String oldPassword, @Param("newPassword") String newPassword,@Param("username") String username);

  Result delete(String username);

  User findByUserName(String username);
}
