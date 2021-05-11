package com.hospital.managementsystem.service;

import com.github.pagehelper.PageHelper;
import com.hospital.managementsystem.common.Constants;
import com.hospital.managementsystem.domin.po.CasePo;
import com.hospital.managementsystem.domin.vo.CaseVo;
import com.hospital.managementsystem.enums.Status;
import com.hospital.managementsystem.mapper.CaseMapper;
import com.hospital.managementsystem.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ning.wang
 * @date 2021/4/29 0:53
 */
@Service
public class CaseServiceImpl implements CaseService {

  @Autowired
  CaseMapper caseMapper;

  @Override
  public Result add(CasePo caseVo) {
//    CaseVo select = caseMapper.select(Integer.valueOf(caseVo.getId()));
//    if (select != null) {
//      return new Result(Status.CASE_ALT_EXIST);
//    }
    caseMapper.add(caseVo);
    return new Result(Status.SUCCESS);
  }

  @Override
  public Result delete(Integer id) {
    caseMapper.delete(id);
    return new Result(Status.SUCCESS);
  }

  @Override
  public Result update(CasePo caseVo) {
    caseMapper.update(caseVo);
    return new Result(Status.SUCCESS);
  }

  @Override
  public Result<CasePo> select(Integer id) {
    CasePo select = caseMapper.select(id);
    Result<CasePo> result = new Result<>(Status.SUCCESS);
    result.setData(select);
    return result;
  }

  @Override
  public Result<List<CasePo>> list(Integer pageNum,Integer limit) {
    if (pageNum <= 0) {
      pageNum = Constants.DEFAULT_PAGE_NUM;
    }
    if (limit <= 1) {
      limit = Constants.DEFAULT_PAGE_SIZE;
    }
    PageHelper.startPage(pageNum, limit);
    List<CasePo> list = caseMapper.list();
    Result<List<CasePo>> result = new Result<>(Status.SUCCESS);
    result.setData(list);
    return result;
  }

  @Override
  public Result<List<CasePo>> listById(String personId,Integer pageNum,Integer limit) {
    if (pageNum <= 0) {
      pageNum = Constants.DEFAULT_PAGE_NUM;
    }
    if (limit <= 1) {
      limit = Constants.DEFAULT_PAGE_SIZE;
    }
    PageHelper.startPage(pageNum, limit);
    List<CasePo> caseVos = caseMapper.listById(personId);
    Result<List<CasePo>> result = new Result<>(Status.SUCCESS);
    result.setData(caseVos);
    return result;
  }

  @Override
  public Result deleteList(List ids) {
    if (ids.size()<=0) return new Result(Status.SUCCESS);
    caseMapper.deleteList(ids);
    return new Result(Status.SUCCESS);
  }
}
