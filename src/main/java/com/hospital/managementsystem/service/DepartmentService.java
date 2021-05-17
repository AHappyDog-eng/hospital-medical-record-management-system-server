package com.hospital.managementsystem.service;

import com.hospital.managementsystem.domin.po.CasePo;
import com.hospital.managementsystem.domin.po.DepartmentPo;
import com.hospital.managementsystem.utils.Result;

import java.util.List;

/**
 * @author ning.wang
 * @date 2021/4/29 0:52
 */
public interface DepartmentService {
  Result add(DepartmentPo departmentPo);

  Result delete(Integer id);

  Result update(DepartmentPo departmentPo);

  Result<DepartmentPo> select(Integer id);

  Result<List<DepartmentPo>> list(Integer pageNum,Integer limit);

  Result<List<DepartmentPo>> listById(String personId,Integer pageNum,Integer limit);

  Result deleteList(List ids);
}
