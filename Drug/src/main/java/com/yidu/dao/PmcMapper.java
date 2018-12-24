package com.yidu.dao;

import java.util.List;
import java.util.Map;

import com.yidu.domain.Pmc;

public interface PmcMapper {
    int deleteByPrimaryKey(String pmcId);

    int insert(Pmc record);

    int insertSelective(Pmc record);

    Pmc selectByPrimaryKey(String pmcId);

    int updateByPrimaryKeySelective(Pmc record);

    int updateByPrimaryKey(Pmc record);

	List<Pmc> selectBySelective(Map<String, Object> map);

	int selectCountBySelective(Pmc record);
	
	int bulkDeleteByPrimaryKeySelective(List<String> ids);

	int check(String pmcId);

	String isCheck(String pmcId);  
	
	Pmc selectById(String pmcId);

	List<Pmc> selectByAudit(Map<String, Object> map);

	int selectAuditCount(Pmc record);
}