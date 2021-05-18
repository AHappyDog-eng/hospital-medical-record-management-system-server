package com.hospital.managementsystem.mapper;

import com.hospital.managementsystem.domin.po.CasePo;
import com.hospital.managementsystem.domin.po.DepartmentPo;
import com.hospital.managementsystem.domin.po.DoctorPo;
import com.hospital.managementsystem.utils.Result;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ning.wang
 * @date 2021/4/29 0:49
 */
@Mapper
@Repository
public interface DoctorMapper {
  DoctorPo getDoctorByNumberId(String numberId);
  void add(DoctorPo doctorPo);

  void delete(Integer id);

  void update(DoctorPo doctorPo);

  DoctorPo select(Integer id);

  List<DoctorPo> list();

  List<DoctorPo> listById(String departmentId);

  void deleteList(List ids);

  DoctorPo getDoctorByNameAndDep(@Param("name") String name, @Param("department") String department);
}
