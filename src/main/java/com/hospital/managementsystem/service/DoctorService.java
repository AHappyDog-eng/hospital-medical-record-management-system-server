package com.hospital.managementsystem.service;

import com.hospital.managementsystem.domin.po.CasePo;
import com.hospital.managementsystem.domin.po.DoctorPo;
import com.hospital.managementsystem.utils.Result;

import java.util.List;
import java.util.Map;

/**
 * @author ning.wang
 * @date 2021/5/12 22:07
 */
public interface DoctorService {
  Result add(DoctorPo doctorPo);

  Result delete(Integer id);

  Result update(DoctorPo doctorPo);

  Result<DoctorPo> select(Integer id);

  Result<Map<String,Object>> list(Integer pageNum, Integer limit);

  Result<Map<String,Object>> listById(String personId,Integer pageNum,Integer limit);

  Result deleteList(List ids);

  Result getDoctorByNameAndDep(String name,String department);
}
