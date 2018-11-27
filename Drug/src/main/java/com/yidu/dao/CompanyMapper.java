package com.yidu.dao;

import com.yidu.domain.Company;

public interface CompanyMapper {
    int deleteByPrimaryKey(String comId);

    int insert(Company record);

    int insertSelective(Company record);

    Company selectByPrimaryKey(String comId);

    int updateByPrimaryKeySelective(Company record);

    int updateByPrimaryKey(Company record);
}