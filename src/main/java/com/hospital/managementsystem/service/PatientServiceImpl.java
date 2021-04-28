package com.hospital.managementsystem.service;

import com.hospital.managementsystem.domin.vo.PatientVo;
import com.hospital.managementsystem.enums.Status;
import com.hospital.managementsystem.mapper.PatientMapper;
import com.hospital.managementsystem.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ning.wang
 * @date 2021/4/28 21:18
 */
@Service
public class PatientServiceImpl implements PatientService {

  @Autowired
  PatientMapper patientMapper;
  @Override
  public Result add(PatientVo patientVo) {
    patientMapper.add(patientVo);
    return new Result(Status.SUCCESS);
  }

  @Override
  public Result delete(String id) {
    return null;
  }

  @Override
  public Result update(PatientVo patientVo) {
    return null;
  }

  @Override
  public Result select(String id) {
    return null;
  }
}
