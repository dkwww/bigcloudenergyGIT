package com.yidu.dao;

import com.yidu.domain.DrugInve;

public interface DrugInveMapper {
    int deleteByPrimaryKey(String diId);

    int insert(DrugInve record);

    int insertSelective(DrugInve record);

    DrugInve selectByPrimaryKey(String diId);

    int updateByPrimaryKeySelective(DrugInve record);

    int updateByPrimaryKey(DrugInve record);
}