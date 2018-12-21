package com.yidu.service;

import java.util.List;

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
	
	int  insert  (QcDetail  qcDetail);
	
	List<QcDetail>  selectbyId(QcDetail record ,PageUtil   pageUtil);
	
	 int  selectbycount(QcDetail record); 
}
