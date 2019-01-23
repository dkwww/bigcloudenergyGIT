package com.yidu.service;

import java.util.List;

import com.yidu.domain.DrugInvDetail;
import com.yidu.domain.DrugInve;
import com.yidu.util.PageUtil;

/**
 * <p>
 * 药品库存明细 服务类
 * <x/p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
public interface DrugInvDetailService  {
/**
 * 根据ID查询
 * @param id
 * @return
 */
	List<DrugInvDetail>   findById(String  id);
	/**
	 * 查询行数
	 * @param id
	 * @return
	 */
	int   selectcount(String  id);
	/**
	 * 增加一条数据
	 * @param record
	 * @return
	 */
	  int insert(DrugInvDetail record);
	  
	  List<DrugInvDetail>   findBydiId(DrugInvDetail record,PageUtil  pageUtil);
	  
	
	int insertSelective(DrugInvDetail record);
	
	
	int  findcount(String  id);
}
