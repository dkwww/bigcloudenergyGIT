package com.yidu.dao;

import java.util.List;
import java.util.Map;

import com.yidu.domain.Buy;


public interface BuyMapper {
    int deleteByPrimaryKey(String buyId);

    int insert(Buy record);

    int insertSelective(Buy record);

    Buy selectByPrimaryKey(String buyId);

    int updateByPrimaryKeySelective(Buy record);

    int updateByPrimaryKey(Buy record);
    
    
    /**
     * 查询所有
     * @return
     */
    public List<Buy> showList(Map<String, Object> map);
    
    /**
     * 查找总行数
     * @param buy
     * @return
     */
	public int selectCountBySelective(Buy buy);
}