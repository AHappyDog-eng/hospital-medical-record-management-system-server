package com.hospital.managementsystem.mapper;

import com.hospital.managementsystem.domin.po.PatientPo;
import com.hospital.managementsystem.domin.vo.PatientVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ning.wang
 * @date 2021/4/22 18:54
 */
@Mapper
@Repository
public interface PatientMapper {
  void add(PatientPo patientVo);

  void delete(Integer id);

  void update(PatientPo patientVo);

  PatientPo select(String idNumber);

  List<PatientVo> list();

  void deleteList(List ids);
}
