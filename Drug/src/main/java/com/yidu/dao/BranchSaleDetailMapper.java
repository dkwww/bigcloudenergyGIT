package com.yidu.dao;

import java.util.List;
import java.util.Map;

import com.yidu.controller.vo.Series;
import com.yidu.domain.BranchSaleDetail;
/**
 * 零售明细mapper
 * @author liuyi
 * @since 2018-11-26
 *
 */
public interface BranchSaleDetailMapper {
    int deleteByPrimaryKey(String bsdId);

    int insert(BranchSaleDetail record);

    int insertSelective(BranchSaleDetail record);

    BranchSaleDetail selectByPrimaryKey(String bsdId);

    int updateByPrimaryKeySelective(BranchSaleDetail record);

    int updateByPrimaryKey(BranchSaleDetail record);

    /**
     * 查询所有
     * @param map 集合
     * @return
     */
	List<BranchSaleDetail> query(Map<String, Object> map);
	/**
	 * 分页
	 * @param saleDetail 零售明细model
	 * @return
	 */
	int findCount(BranchSaleDetail saleDetail);
	/**
	 * 根据名字查询
	 * @return
	 */
	List<Series> queryName(String id);
	/**
	 * 根据ID查询
	 * @param map 集合
	 * @return
	 */
	int queryId(Map<String, Object> map);
	
	List<Series> queryMoney(String id);
}