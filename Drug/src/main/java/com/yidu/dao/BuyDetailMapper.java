package com.yidu.dao;

import java.util.List;

import com.yidu.domain.BuyDetail;
import com.yidu.domain.Drug;

public interface BuyDetailMapper {
    int deleteByPrimaryKey(String bdetId);

    int insert(BuyDetail record);

    int insertSelective(BuyDetail record);

    BuyDetail selectByPrimaryKey(String bdetId);

    int updateByPrimaryKeySelective(BuyDetail record);

    int updateByPrimaryKey(BuyDetail record);
    
    /**
     * 显示列表
     * @return
     */
    public List<BuyDetail> findAll();
    
    /**
     * 查询所有
     * @param deta
     * @author 邓康威
     * @return
     */
    public List<BuyDetail> showList(BuyDetail deta);
    
}