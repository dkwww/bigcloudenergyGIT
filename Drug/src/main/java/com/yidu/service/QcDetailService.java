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
	 * @param qcdetail
	 * @author	邓康威
	 * @return
	 */
	int add(QcDetail qcdetail);

	List<QcDetail> findById(QcDetail qcdetail);
	
	List<QcDetail> findByIds(String qcId);
	
	int  insert  (QcDetail  qcDetail);
	
	List<QcDetail>  selectbyId(QcDetail record ,PageUtil   pageUtil);
	  List<QcDetail>  selectqctype(Map<String , Object> map);
	 int  selectbycount(QcDetail record); 
	 
	 
	  int updateByPrimaryKeySelective(QcDetail record);
	  
	  
	
}
