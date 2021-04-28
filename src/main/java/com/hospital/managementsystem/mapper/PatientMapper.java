package com.hospital.managementsystem.mapper;

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
  void add(PatientVo patientVo);

  void delete(String id);

  void update(PatientVo patientVo);

  PatientVo select(String id);

  List<PatientVo> list();
}
