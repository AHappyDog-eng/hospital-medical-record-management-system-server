package com.hospital.managementsystem.mapper;

import com.hospital.managementsystem.domin.vo.CaseVo;
import com.hospital.managementsystem.domin.vo.PatientVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ning.wang
 * @date 2021/4/29 0:49
 */
@Mapper
@Repository
public interface CaseMapper {
  void add(CaseVo caseVo);

  void delete(Integer id);

  void update(CaseVo caseVo);

  CaseVo select(Integer id);

  List<CaseVo> list();

  List<CaseVo> listById(String personId);
}
