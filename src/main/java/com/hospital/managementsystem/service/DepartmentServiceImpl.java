package com.hospital.managementsystem.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.hospital.managementsystem.common.Constants;
import com.hospital.managementsystem.domin.po.CasePo;
import com.hospital.managementsystem.domin.po.DepartmentPo;
import com.hospital.managementsystem.enums.Status;
import com.hospital.managementsystem.mapper.CaseMapper;
import com.hospital.managementsystem.mapper.DepartmentMapper;
import com.hospital.managementsystem.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author ning.wang
 * @date 2021/4/29 0:53
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

  @Autowired
  DepartmentMapper departmentMapper;

  @Override
  public Result add(DepartmentPo departmentPo) {
//    CaseVo select = caseMapper.select(Integer.valueOf(caseVo.getId()));
//    if (select != null) {
//      return new Result(Status.CASE_ALT_EXIST);
//    }
    departmentPo.setDepartmentId(UUID.randomUUID().toString().substring(0,12).toLowerCase());
    departmentMapper.add(departmentPo);
    return new Result(Status.SUCCESS);
  }

  @Override
  public Result delete(Integer id) {
    departmentMapper.delete(id);
    return new Result(Status.SUCCESS);
  }

  @Override
  public Result update(DepartmentPo departmentPo) {
    departmentMapper.update(departmentPo);
    return new Result(Status.SUCCESS);
  }

  @Override
  public Result<DepartmentPo> select(Integer id) {
    DepartmentPo select = departmentMapper.select(id);
    Result<DepartmentPo> result = new Result<>(Status.SUCCESS);
    result.setData(select);
    return result;
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
    List<DepartmentPo> list = departmentMapper.list();
    PageInfo<DepartmentPo> pageInfo = new PageInfo<>(list);
    long total = pageInfo.getTotal();
    Result<Map<String,Object>> result = new Result<>(Status.SUCCESS);
    HashMap<String, Object> hashMap = Maps.newHashMap();
    hashMap.put("result",list);
    hashMap.put("totals",total);
    result.setData(hashMap);
    return result;
  }

  @Override
  public Result<Map<String,Object>> listById(String personId, Integer pageNum, Integer limit) {
    if (pageNum <= 0) {
      pageNum = Constants.DEFAULT_PAGE_NUM;
    }
    if (limit <= 1) {
      limit = Constants.DEFAULT_PAGE_SIZE;
    }
    PageHelper.startPage(pageNum, limit);
    List<DepartmentPo> caseVos = departmentMapper.listById(personId);
    PageInfo<DepartmentPo> pageInfo = new PageInfo<>(caseVos);
    long total = pageInfo.getTotal();
    Result<Map<String,Object>> result = new Result<>(Status.SUCCESS);
    HashMap<String, Object> hashMap = Maps.newHashMap();
    hashMap.put("result",caseVos);
    hashMap.put("totals",total);
    result.setData(hashMap);
    return result;
  }

  @Override
  public Result deleteList(List ids) {
    if (ids.size() <= 0) return new Result(Status.SUCCESS);
    departmentMapper.deleteList(ids);
    return new Result(Status.SUCCESS);
  }

  @Override
  public Result selectByName(String departmentName) {
    DepartmentPo departmentPo = departmentMapper.selectByName(departmentName);
    Result<Object> result = new Result<>(Status.SUCCESS);
    result.setData(departmentPo);
    return result;
  }
}
