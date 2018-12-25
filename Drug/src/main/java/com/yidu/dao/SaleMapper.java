package com.yidu.dao;

import java.util.List;
import java.util.Map;

import com.yidu.domain.Buy;
import com.yidu.domain.Sale;
import com.yidu.domain.SaleDetail;

public interface SaleMapper {
    int deleteByPrimaryKey(String saleId);

    int insert(Sale record);

    int insertSelective(Sale record);

    Sale selectByPrimaryKey(String saleId);

    int updateByPrimaryKeySelective(Sale record);

    int updateByPrimaryKey(Sale record);
    
    /**
     * 查询所有
     * @return
     */
    public List<Sale> findAll(Map<String, Object> map);
    
    /**
     * 查找总行数
     * @param buy
     * @return
     */
	public int findCount(Sale sale);
	
}