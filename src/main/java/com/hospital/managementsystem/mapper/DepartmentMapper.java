package com.hospital.managementsystem.mapper;

import com.hospital.managementsystem.domin.po.DepartmentPo;
import com.hospital.managementsystem.domin.po.DoctorPo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ning.wang
 * @date 2021/4/29 0:49
 */
@Mapper
@Repository
public interface DepartmentMapper {
  void add(DepartmentPo departmentPo);

  void delete(Integer id);

  void update(DepartmentPo departmentPo);

  DepartmentPo select(Integer id);

  List<DepartmentPo> list();

  List<DepartmentPo> listById(String idNumber);

  void deleteList(List ids);
}
