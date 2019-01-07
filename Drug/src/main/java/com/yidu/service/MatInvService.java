package com.yidu.service;

import java.util.List;

import com.yidu.domain.MatInv;
import com.yidu.util.PageUtil;

/**
 * <p>
 * 原材料库存 服务类
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
public interface MatInvService  {
	/**
	 * 根据ID和数量查询
	 * @param record
	 * @return
	 */
	List<MatInv> selectByamount(MatInv record);
	/**
	 * 查询所有
	 * @param matinv
	 * @return
	 */
	List<MatInv> showList(MatInv matinv,PageUtil page);
	
	/**
	 * 查询总行数
	 * @param matinv
	 * @return
	 */
	int selectCount(MatInv matinv);

	
	int add(MatInv matinv);
	
	
	MatInv findQcId(String qcFkId);
	
	/**
	 * 
	 * 方法说明：加库存数量
	 * @param miAmount
	 * @param miId
	 * @return
	 * @author dengknagwei
	 * @date：2018年12月27日
	 */
	int updateAmount(Integer miAmount,String miId);
	
	/**
	 * 增加
	 * @param inv
	 * @return int
	 */
	int insertSelective(MatInv inv);
	
}
