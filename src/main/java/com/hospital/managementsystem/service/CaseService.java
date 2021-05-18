package com.hospital.managementsystem.service;

import com.hospital.managementsystem.domin.po.CasePo;
import com.hospital.managementsystem.domin.vo.CaseVo;
import com.hospital.managementsystem.utils.Result;

import java.util.List;
import java.util.Map;

/**
 * @author ning.wang
 * @date 2021/4/29 0:52
 */
public interface CaseService {
  Result add(CasePo caseVo);

  Result delete(Integer id);

  Result update(CasePo caseVo);

  Result<CasePo> select(Integer id);

  Result<Map<String,Object>> list(Integer pageNum, Integer limit);

  Result<Map<String,Object>> listById(String personId,Integer pageNum,Integer limit);

  Result deleteList(List ids);
}
