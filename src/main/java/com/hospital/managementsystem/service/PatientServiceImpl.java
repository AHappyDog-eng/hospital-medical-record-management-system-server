package com.hospital.managementsystem.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.hospital.managementsystem.common.Constants;
import com.hospital.managementsystem.domin.po.DoctorPo;
import com.hospital.managementsystem.domin.po.PatientPo;
import com.hospital.managementsystem.domin.vo.PatientVo;
import com.hospital.managementsystem.enums.Status;
import com.hospital.managementsystem.mapper.PatientMapper;
import com.hospital.managementsystem.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ning.wang
 * @date 2021/4/28 21:18
 */
@Service
public class PatientServiceImpl implements PatientService {

  @Autowired
  PatientMapper patientMapper;

  @Override
  public Result add(PatientPo patientVo) {
    PatientPo select = patientMapper.select(patientVo.getIdNumber());
    if (select != null) {
      return new Result(Status.USER_EXIST_ERROR);
    }
    patientMapper.add(patientVo);
    return new Result(Status.SUCCESS);
  }


  @Override
  public Result<Map<String,Object>> list(Integer pageNum, Integer limit) {
    if (pageNum <= 0) {
      pageNum = Constants.DEFAULT_PAGE_NUM;
    }
    if (limit <= 1) {
      limit = Constants.DEFAULT_PAGE_SIZE;
    }
    PageHelper.startPage(pageNum, limit);
    List<PatientVo> list = patientMapper.list();
    PageInfo<PatientVo> pageInfo = new PageInfo<>(list);
    long total = pageInfo.getTotal();
    Result<Map<String,Object>> result = new Result<>(Status.SUCCESS);
    HashMap<String, Object> hashMap = Maps.newHashMap();
    hashMap.put("result",list);
    hashMap.put("totals",total);
    result.setData(hashMap);
    return result;
  }

  @Override
  public Result deleteList(List ids) {
    if (ids.size()<=0) return new Result(Status.SUCCESS);
    patientMapper.deleteList(ids);
    return new Result(Status.SUCCESS);
  }

  @Override
  public Result delete(Integer id) {
    patientMapper.delete(id);
    return new Result(Status.SUCCESS);
  }

  @Override
  public Result update(PatientPo patientVo) {
    PatientPo select = patientMapper.select(patientVo.getIdNumber());
    if (select == null) {
      return new Result(Status.USER_NOT_EXIST_ERROR);
    }
    patientMapper.update(patientVo);
    return new Result(Status.SUCCESS);
  }

  @Override

  public Result select(String id) {
    PatientPo patientVo = patientMapper.select(id);
    Result<PatientPo> result = new Result<>(Status.SUCCESS);
    result.setData(patientVo);
    return result;
  }
}
