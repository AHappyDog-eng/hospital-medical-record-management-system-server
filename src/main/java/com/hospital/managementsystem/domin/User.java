package com.hospital.managementsystem.domin;

import com.hospital.managementsystem.enums.RoleEnum;
import lombok.Data;

/**
 * @author ning.wang
 * @date 2021/4/22 18:25
 */
@Data
public class User {
  private String id;
  private String username;
  private String password;
  /**用户默认角色为医生*/
  private String role = RoleEnum.DOCTOR.getRemark();
  private int power = RoleEnum.DOCTOR.getPower();
}
