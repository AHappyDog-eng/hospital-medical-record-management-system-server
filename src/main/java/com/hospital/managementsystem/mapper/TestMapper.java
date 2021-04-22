package com.hospital.managementsystem.mapper;

import com.hospital.managementsystem.domin.Test;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @author ning.wang
 * @date 2021/4/22 17:37
 */
@Mapper
@Repository
public interface TestMapper {
  Test getUser(String id);
}
