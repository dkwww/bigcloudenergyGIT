package com.yidu.service;

import java.util.List;
import java.util.Map;

import com.yidu.domain.QcDetail;
import com.yidu.util.PageUtil;

/**
 * <p>
 * 材料质检明细 服务类
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
public interface QcDetailService   {
	
	
	/**
	 * 增加
	 * @param qcdetail 质检明细对象
	 * @author	dengkangwei
	 * @return
	 */
	int add(QcDetail qcdetail);

	List<QcDetail> findById(QcDetail qcdetail);
	
	/**
	 * 
	 * 方法说明：根据质检id查看质检明细
	 * @param qcdetail 质检明细对象
	 * @param page 分页对象
	 * @return
	 * @author dengkangwei
	 * @date：2019年1月8日
	 */
	List<QcDetail> findByIds(QcDetail qcdetail,PageUtil page);
	
	/**
     * 方法说明：根据质检id查看质检明细总行数
     * @param qcdetail 分页对象
     * @return
     * @author dengkangwei
     * @date：2019年1月5日
     */
	int findByIdselectCount(QcDetail qcdetail);
	
	int  insert  (QcDetail  qcDetail);
	
	List<QcDetail>  selectbyId(QcDetail record ,PageUtil   pageUtil);
	  
	 int  selectbycount(QcDetail record); 
	 
	 
	  int updateByPrimaryKeySelective(QcDetail record);
	  
	  List<QcDetail> selectQcId (String  id);


	List<QcDetail> findByIdss(String qcId);
	  
	 List<QcDetail> findByQcId(String id);
	 
	 
	 /**
	 * 根据质检id查看质检明细
	 * @param qcId 质检id
	 * @author dengkangwei
	 * @return
	 */
	List<QcDetail> findkcId(String qcId);
	
}
