package com.hospital.managementsystem.service;

import com.hospital.managementsystem.domin.vo.PatientVo;
import com.hospital.managementsystem.enums.Status;
import com.hospital.managementsystem.mapper.PatientMapper;
import com.hospital.managementsystem.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    PatientVo select = patientMapper.select(patientVo.getTel());
    if (select != null) {
      return new Result(Status.USER_EXIST_ERROR);
    }

    patientVo.setFirstTime(System.currentTimeMillis());
    patientMapper.add(patientVo);
    return new Result(Status.SUCCESS);
  }


  @Override
  public Result<List<PatientVo>> list() {
    List<PatientVo> list = patientMapper.list();
    Result<List<PatientVo>> result = new Result<>(Status.SUCCESS);
    result.setData(list);
    return result;
  }

  @Override
  public Result delete(String id) {
    patientMapper.delete(id);
    return new Result(Status.SUCCESS);
  }

  @Override
  public Result update(PatientVo patientVo) {
    PatientVo select = patientMapper.select(patientVo.getTel());
    if (select == null){
      return new Result(Status.USER_NOT_EXIST_ERROR);
    }
    patientVo.setFirstTime(select.getFirstTime());
    patientMapper.update(patientVo);
    return new Result(Status.SUCCESS);
  }

  @Override

  public Result select(String id) {
    PatientVo patientVo = patientMapper.select(id);
    Result<PatientVo> result = new Result<>(Status.SUCCESS);
    result.setData(patientVo);
    return result;
  }
}
