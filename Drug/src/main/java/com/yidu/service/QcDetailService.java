package com.yidu.service;

import java.util.List;

import com.yidu.domain.QcDetail;

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
	
	
	
}
