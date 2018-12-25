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
	
	List<PmcDetails> findAll(PmcDetails record, PageUtil pageUtil);

	int selectCountBySelective (PmcDetails pmcDetail);
	
	int addOrUpdate(PmcDetails record);

	List<PmcDetails> findByPmc(PmcDetails record, PageUtil pageUtil, String mrpId);

	boolean checkInv(List<PmcDetails> list);
}
 