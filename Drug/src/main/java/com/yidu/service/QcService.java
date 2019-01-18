package com.yidu.service;

import java.util.List;

import com.yidu.domain.Admin;
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
	 * 分店质检查询所有
	 * @param qc
	 * @param pageUtil
	 * @author zhengyouhong
	 * @return
	 */
	List<Qc> branchQuality(Qc  qc,PageUtil pageUtil,Admin admin);
	
	/**
	 * 修改
	 * @param qc
	 * @author dengkangwei
	 * @return
	 */
	int buyQcadd(Qc qc);
	
	/**
	 * 材料查询所有
	 * @param qc 质检对象
	 * @param page 分页对象
	 * @author dengkangwei
	 * @return
	 */
	List<Qc> showList(Qc qc,PageUtil page);
	
	/**
	 * 查看总行数
	 * @param qc 质检对象
	 * @author dengkangwei
	 * @return
	 */
	int selectCount(Qc qc);

	
	/**
	 * 采购订单增加到质检
	 * @param buy 采购订单对象
	 * @author dengkangwei
	 * @return
	 */
	int addQc(Buy buy);
	
	/**
	 * 修改
	 * @param buy 采购订单对象
	 * @author dengkangwei
	 * @return
	 */
	int update(Buy buy);
	
	/**
	 * 根据质检id查询所有
	 * @param qcId 质检id
	 * @author dengkangwei
	 * @return
	 */
	List<Qc> findById(String qcId);
	
	
	  int  updateByPrimaryKeySelective(Qc  qc);

	int add(Qc qc);

	/**
	 * 分店质检增加
	 * @param buy
	 * @return
	 */
	int qualityAdd(Buy buy);

	int branchQualityAdd(Buy buy);

}
