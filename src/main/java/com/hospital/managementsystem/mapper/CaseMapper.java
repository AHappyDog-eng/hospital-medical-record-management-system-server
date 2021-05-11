package com.hospital.managementsystem.mapper;

import com.hospital.managementsystem.domin.po.CasePo;
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
  void add(CasePo caseVo);

  void delete(Integer id);

  void update(CasePo caseVo);

  CasePo select(Integer id);

  List<CasePo> list();

  List<CasePo> listById(String idNumber);

  void deleteList(List ids);
}
