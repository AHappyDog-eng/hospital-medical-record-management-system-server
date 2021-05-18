package com.hospital.managementsystem.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.hospital.managementsystem.common.Constants;
import com.hospital.managementsystem.domin.User;
import com.hospital.managementsystem.domin.po.CasePo;
import com.hospital.managementsystem.domin.po.DepartmentPo;
import com.hospital.managementsystem.domin.po.DoctorPo;
import com.hospital.managementsystem.enums.Status;
import com.hospital.managementsystem.mapper.DoctorMapper;
import com.hospital.managementsystem.mapper.UserMapper;
import com.hospital.managementsystem.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ning.wang
 * @date 2021/5/12 22:07
 */
@Service
public class DoctorServiceImpl implements DoctorService {
  @Autowired
  private DoctorMapper doctorMapper;
  @Autowired
  private UserMapper userMapper;

  @Override
  public Result add(DoctorPo doctorPo) {
    DoctorPo doctorByNumberId = doctorMapper.getDoctorByNumberId(doctorPo.getNumberId());
    if (doctorByNumberId != null) {
      return new Result(Status.USER_EXIST_ERROR);
    }
    doctorMapper.add(doctorPo);
    User user = new User();
    user.setPower(1);
    user.setRole("doctor");
    user.setUsername(doctorPo.getTel());
    user.setPassword("123456");
    user.setNumberId(doctorPo.getNumberId());
    user.setHeadSculptureUrl("none");
    userMapper.register(user);
    Result<Object> result = new Result<>(Status.SUCCESS);
    return result;
  }

  @Override
  public Result delete(Integer id) {
    doctorMapper.delete(id);
    return new Result(Status.SUCCESS);
  }

  @Override
  public Result update(DoctorPo doctorPo) {
    doctorMapper.update(doctorPo);
    return new Result(Status.SUCCESS);
  }

  @Override
  public Result<DoctorPo> select(Integer id) {
    DoctorPo select = doctorMapper.select(id);
    Result<DoctorPo> result = new Result<>(Status.SUCCESS);
    result.setData(select);
    return result;

  }

  @Override
  public Result<Map<String, Object>> list(Integer pageNum, Integer limit) {
    if (pageNum <= 0) {
      pageNum = Constants.DEFAULT_PAGE_NUM;
    }
    if (limit <= 1) {
      limit = Constants.DEFAULT_PAGE_SIZE;
    }
    PageHelper.startPage(pageNum, limit);
    List<DoctorPo> list = doctorMapper.list();
    PageInfo<DoctorPo> pageInfo = new PageInfo<>(list);
    long total = pageInfo.getTotal();
    Result<Map<String, Object>> result = new Result<>(Status.SUCCESS);
    HashMap<String, Object> hashMap = Maps.newHashMap();
    hashMap.put("result", list);
    hashMap.put("totals", total);
    result.setData(hashMap);
    return result;
  }

  @Override
  public Result<Map<String, Object>> listById(String personId, Integer pageNum, Integer limit) {
    if (pageNum <= 0) {
      pageNum = Constants.DEFAULT_PAGE_NUM;
    }
    if (limit <= 1) {
      limit = Constants.DEFAULT_PAGE_SIZE;
    }
    PageHelper.startPage(pageNum, limit);
    List<DoctorPo> caseVos = doctorMapper.listById(personId);
    PageInfo<DoctorPo> pageInfo = new PageInfo<>(caseVos);
    long total = pageInfo.getTotal();
    Result<Map<String, Object>> result = new Result<>(Status.SUCCESS);
    HashMap<String, Object> hashMap = Maps.newHashMap();
    hashMap.put("result", caseVos);
    hashMap.put("totals", total);
    result.setData(hashMap);
    return result;
  }

  @Override
  public Result deleteList(List ids) {
    if (ids.size() <= 0) return new Result(Status.SUCCESS);
    doctorMapper.deleteList(ids);
    return new Result(Status.SUCCESS);
  }

  @Override
  public Result getDoctorByNameAndDep(String name, String department) {
    DoctorPo doctor = doctorMapper.getDoctorByNameAndDep(name, department);
    Result<DoctorPo> result = new Result<>();
    result.setData(doctor);
    return result;
  }
}
