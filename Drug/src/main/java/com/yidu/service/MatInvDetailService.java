package com.yidu.service;

import java.util.List;

import com.yidu.domain.MatInvDetail;
import com.yidu.util.PageUtil;

/**
 * <p>
 * 原材料库存明细 服务类
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
public interface MatInvDetailService  {
	
	/**
	 * 
	 * 方法说明：根据库存查询库存明细
	 * @param matdetail
	 * @return
	 * @author dengknagwei
	 * @date：2018年12月27日
	 */
	List<MatInvDetail> findById(MatInvDetail matdetail,PageUtil page);
	
	/**
	 * 
	 * 方法说明：查询总行数
	 * @param matdetail
	 * @return
	 * @author dengknagwei
	 * @date：2018年12月27日
	 */
	int selectCount(MatInvDetail matdetail);
	
	/**
	 * 
	 * 方法说明：增加库存记录
	 * @param matdetail
	 * @return
	 * @author dengknagwei
	 * @date：2018年12月27日
	 */
	int addkcdetail(MatInvDetail matdetail);
}
