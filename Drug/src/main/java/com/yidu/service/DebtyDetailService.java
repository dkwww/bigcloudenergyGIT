package com.yidu.service;

import java.util.List;


import com.yidu.domain.DebtyDetail;
import com.yidu.util.PageUtil;

/**
 * <p>
 * 财物明细 服务类
 * </p>
 *
 * @author liuwenxuan
 * @since 2018-11-26
 */
public interface DebtyDetailService  {
	/**
     *财务 查询所有
     * @return
     */
	List<DebtyDetail> findAll(DebtyDetail debty,PageUtil pageUtil,String id);
	
	
	/**
	 * 查询总共多少条数据
	 * @param Debty 财务对象
	 * @return
	 */
	int selectCount(DebtyDetail debty);
	
	/**
	 * 
	 * 方法说明：增加
	 * @param debty
	 * @return
	 * @author dengknagwei
	 * @date：2018年12月27日
	 */
	int addmx(DebtyDetail debty);
}
