package com.hospital.managementsystem.service;

import com.hospital.managementsystem.domin.po.PatientPo;
import com.hospital.managementsystem.domin.vo.PatientVo;
import com.hospital.managementsystem.utils.Result;

import java.util.List;

/**
 * @author ning.wang
 * @date 2021/4/28 21:15
 */
public interface PatientService {
  Result add(PatientPo patientVo);

  Result delete(Integer id);

  Result update(PatientPo patientVo);

  Result select(String id);

  Result<List<PatientVo>> list(Integer pageNum,Integer limit);

  Result deleteList(List ids);
}
