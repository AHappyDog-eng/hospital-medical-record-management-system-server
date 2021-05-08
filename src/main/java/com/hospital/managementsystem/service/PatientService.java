package com.hospital.managementsystem.service;

import com.hospital.managementsystem.domin.vo.PatientVo;
import com.hospital.managementsystem.utils.Result;

import java.util.List;

/**
 * @author ning.wang
 * @date 2021/4/28 21:15
 */
public interface PatientService {
  Result add(PatientVo patientVo);

  Result delete(String id);

  Result update(PatientVo patientVo);

  Result select(String id);

  Result<List<PatientVo>> list(Integer pageNum,Integer limit);

  Result deleteList(List ids);
}
