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
     * 显示采购审核
     * @return
     */
    public List<Audit> showBuy(Map<String, Object> map);
	
	/**
     * 显示总经理表
     * @return
     */
    public List<Audit> showCEO(Map<String, Object> map);
    
    /**
     * 显示财务总经理表
     * @return
     */
    public List<Audit> wholeceo(Map<String, Object> map);
}