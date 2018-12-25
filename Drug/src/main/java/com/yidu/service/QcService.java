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
	
	
	List<Qc>  selectqctype(Qc  qc,PageUtil pageUtil);
	
	
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

	
	
	int addQc(Buy buy);
	
	int update(Buy buy);
	
	List<Qc> findById(String qcId);


	void insertSelective(Qc qc);

}
