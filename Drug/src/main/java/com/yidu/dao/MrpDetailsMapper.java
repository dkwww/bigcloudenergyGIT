package com.yidu.dao;

import java.util.List;
import java.util.Map;

import com.yidu.domain.MrpDetails;

public interface MrpDetailsMapper {
	
	int deleteByPrimaryKey(String mdId);

    int insert(MrpDetails record);

    int insertSelective(MrpDetails record);

    MrpDetails selectByPrimaryKey(String mdId);

    int updateByPrimaryKeySelective(MrpDetails record);

    int updateByPrimaryKey(MrpDetails record);
	
	List<MrpDetails>   findById(Map<String, Object>  map);
	
	int   findBycount(MrpDetails  mrpDetails);
   
	 
    Integer   findStatistics (MrpDetails  mrpDetails);  
    
    int   findmax  (MrpDetails  mrpDetails);
    
    int  findPercentage  (MrpDetails  mrpDetails);
    
    
} 