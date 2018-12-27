package com.yidu.service;

import java.util.List;

import com.yidu.domain.Buy;
import com.yidu.domain.Qc;
import com.yidu.util.PageUtil;

/**
 * <p>
 * 质检表 服务类
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
public interface QcService  {
	
	/**
	 * 查看所有的药品质检
	 * @param qc
	 * @param pageUtil
	 * @return
	 */
	List<Qc>  selectqctype(Qc  qc,PageUtil pageUtil);
	
	/**
	 * 查询行数
	 * @param qc
	 * @return
	 */
	int selectCountBySelective(Qc  qc);
	
	
	/**
	 * 增加
	 * @param qc
	 * @author 邓康威
	 * @return
	 */
	int buyQcadd(Qc qc);
	
	/**
	 * 材料查询所有
	 * @param qc
	 * @param page
	 * @author 邓康威
	 * @return
	 */
	List<Qc> showList(Qc qc,PageUtil page);
	
	/**
	 * 查看总行数
	 * @param qc
	 * @author 邓康威
	 * @return
	 */
	int selectCount(Qc qc);

	
	/**
	 * 采购订单增加到质检
	 * @param buy
	 * @author 邓康威
	 * @return
	 */
	int addQc(Buy buy);
	
	/**
	 * 修改
	 * @param buy
	 * @author 邓康威
	 * @return
	 */
	int update(Buy buy);
	
	/**
	 * 根据id查询
	 * @param qcId
	 * @author 邓康威
	 * @return
	 */
	List<Qc> findById(String qcId);
	
	
	  int  updateByPrimaryKeySelective(Qc  qc);

	int add(Qc qc);

}
