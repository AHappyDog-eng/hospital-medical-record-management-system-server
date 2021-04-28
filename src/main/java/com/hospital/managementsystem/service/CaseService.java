package com.hospital.managementsystem.service;

import com.hospital.managementsystem.domin.vo.CaseVo;
import com.hospital.managementsystem.utils.Result;

import java.util.List;

/**
 * @author ning.wang
 * @date 2021/4/29 0:52
 */
public interface CaseService {
  Result add(CaseVo caseVo);

  Result delete(Integer id);

  Result update(CaseVo caseVo);

  Result<CaseVo> select(Integer id);

  Result<List<CaseVo>> list();

  Result<List<CaseVo>> listById(String personId);


}
