package com.yidu.dao;

import java.util.List;
import java.util.Map;

import com.yidu.domain.DrugType;

public interface DrugTypeMapper {
    int deleteByPrimaryKey(String dtId);

    int insert(DrugType record);

    int insertSelective(DrugType record);

    DrugType selectByPrimaryKey(String dtId);

    int updateByPrimaryKeySelective(DrugType record);

    int updateByPrimaryKey(DrugType record);
    
    List<DrugType> selectList();

	List<DrugType> selectBySelective(Map<String, Object> map);

	int selectCountBySelective(DrugType record);

	int bulkDeleteByPrimaryKeySelective(List<String> ids);
}