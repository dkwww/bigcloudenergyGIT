package com.yidu.dao;

import java.util.List;
import java.util.Map;

import com.yidu.domain.MaterialList;

public interface MaterialListMapper {
    int deleteByPrimaryKey(String mlId);

    int insert(MaterialList record);

    int insertSelective(MaterialList record);

    MaterialList selectByPrimaryKey(String mlId);

    int updateByPrimaryKeySelective(MaterialList record);

    int updateByPrimaryKey(MaterialList record);

	List<MaterialList> selectBySelective(Map<String, Object> map);

	int selectCountBySelective(MaterialList record);
	
	List<MaterialList> selectByDrug(String drugId);
	 
	
	  List<MaterialList> selectBydrugId (String   id);
}