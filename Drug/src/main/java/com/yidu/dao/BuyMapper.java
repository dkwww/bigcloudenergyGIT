package com.yidu.dao;

import java.util.List;
import java.util.Map;

import com.yidu.domain.Audit;
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
    public List<Buy> findAll(Map<String, Object> map);
    
    /**
     * 查找总行数
     * @param buy
     * @return
     */
	public int selectCountBySelective(Buy buy);
	
	/**
	 * 
	 * 方法说明：查询所有
	 * @param map
	 * @return
	 * @author dengknagwei
	 * @date：2019年1月3日
	 */
    public List<Buy> showList(Map<String, Object> map);
    /**
     * 
     * 方法说明：查找总行数
     * @param buy
     * @return
     * @author dengknagwei
     * @date：2019年1月3日
     */
    int selectCount(Buy buy);
    
    /**
     * 审核查询所有
     * @param map
     * 邓康威
     * @return
     */
    public List<Buy> AuditshowList(Map<String,Object> map);
    
    /**
     * 审核查询总行数
     * @param buy
     * @author 邓康威
     * @return
     */
    public int AuditselectCount(Buy buy);

    
}