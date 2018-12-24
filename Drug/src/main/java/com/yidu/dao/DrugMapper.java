package com.yidu.dao;

import java.util.List;
import java.util.Map;

import com.yidu.domain.Drug;

public interface DrugMapper {
    int deleteByPrimaryKey(String drugId);

    int insert(Drug record);

    int insertSelective(Drug record);

    Drug selectByPrimaryKey(String drugId);

    int updateByPrimaryKeySelective(Drug record);

    int updateByPrimaryKey(Drug record);
    
    List<Drug> selectBySelective(Map<String, Object> map);
    
    int selectCountBySelective(Drug record);
    
	int bulkDeleteByPrimaryKeySelective(List<String> ids);

	int check(String drugId);

	String isCheck(String drugId);
	
	List<Drug> selectBySelectives(Map<String, Object> map);

	List<Drug> selectByAudit(Map<String, Object> map);

	int selectAuditCount(Drug record);
}