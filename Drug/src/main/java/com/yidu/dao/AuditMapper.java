package com.yidu.dao;

import java.util.List;
import java.util.Map;

import com.yidu.domain.Audit;

public interface AuditMapper {
    int deleteByPrimaryKey(String audId);

    int insert(Audit record);

    int insertSelective(Audit record);

    Audit selectByPrimaryKey(String audId);

    int updateByPrimaryKeySelective(Audit record);

    int updateByPrimaryKey(Audit record);
    
    /**
     * 查询所有
     * @return
     */
    public List<Audit> findAll(Map<String, Object> map);

    /**
     * 查询总行数
     * @param audit
     * @return
     */
	int findCount(Audit audit);
	
	
	/**
	 * 查询所有
	 * @param map
	 * @author 邓康威
	 * @return
	 */
	List<Audit> showList(Map<String, Object> map);
	
	/**
	 * 查询总行数
	 * @param audit
	 * @author 邓康威
	 * @return
	 */
	int selectCount(Audit audit);
	
	/**
     * 显示财务总经理表
     * @return
     */
    public List<Audit> wholeceo(Map<String, Object> map);
    
    public int wholeceoupdate(String audId);
    
    /**
     * 显示财务审核表
     * @return
     */
    public List<Audit> financeo(Map<String, Object> map);
    
    
    public int finanupdate(String audId);

	
	/**
     * 显示分店财务审核
     * @return
     */
    public List<Audit> showBuy(Map<String, Object> map);
	
	/**
     * 显示分店总经理表
     * @return
     */
    public List<Audit> showCEO(Map<String, Object> map);
    
    /**
     * 显示总店财务审核
     * @return
     */
    public List<Audit> findSale(Map<String, Object> map);
	
	/**
     * 显示总店总经理审核
     * @return
     */
    public List<Audit> findCEO(Map<String, Object> map);
    
    
    /**
     * 根据采购id查询审核
     * @param buyId
     * @author 邓康威
     * @return
     */
	List<Audit> findById(String buyId);
	
	/**
	 * 根据业务编号查询财物或经理审核
	 * @param audFkId
	 * @param type
	 * @return
	 */
	Audit findByFk(Map<String, Object> map);
}