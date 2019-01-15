package com.yidu.service;

import java.util.List;

import com.yidu.domain.PmcDetails;
import com.yidu.util.PageUtil;

/**
 * <p>
 * 生产计划明细 服务类
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
public interface PmcDetailsService   {
	
	/**
	 * 条件查询生产明细
	 * @param record 生产明细模型类
	 * @param pageUtil 分页工具类
	 * @return List<PmcDetails> 生产明细数据
	 * @author ZhouJun
	 */
	List<PmcDetails> findAll(PmcDetails record, PageUtil pageUtil);
	
	/**
	 * 条件查询生产明细的行数
	 * @param pmcDetail
	 * @return
	 * @author ZhouJun
	 */
	int selectCountBySelective (PmcDetails pmcDetail);
	
	/**
	 * 增加或修改
	 * @param record
	 * @return
	 * @author ZhouJun
	 */
	int addOrUpdate(PmcDetails record);

	/**
	 * 显示带完成度的生产明细
	 * @param record 生产明细模型类
	 * @param pageUtil 分页工具类
	 * @param mrpId 制造清单id
	 * @return List<PmcDetails> 生产明细数据
	 * @author ZhouJun
	 */
	List<PmcDetails> findByPmc(PmcDetails record, PageUtil pageUtil, String mrpId);
	
	/**
	 * 根据生产计划查询生产明细
	 * @param id
	 * @return
	 * @author ZhouJun
	 */
    List<PmcDetails> selectPmcId(String id);
    
    /**
     * 根据药品id查询原材料库存
     * @param drugId 药品id
     * @return List<PmcDetails> 生产明细数据
     * @author ZhouJun
     */
    List<PmcDetails> checkInv(String drugId);
}
 