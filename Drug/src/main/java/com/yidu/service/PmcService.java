package com.yidu.service;

import java.util.List;

import com.yidu.domain.Pmc;
import com.yidu.util.PageUtil;

/**
 * <p>
 * 生产计划单 服务类
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
public interface PmcService  {

	List<Pmc> findAll(Pmc record, PageUtil pageUtil);

	int findCount(Pmc record);

	int addOrUpdate(Pmc record);

	int bulkUpdate(List<String> ids);

	int check(String pmcId);

	int isChack(String pmcId);

}
