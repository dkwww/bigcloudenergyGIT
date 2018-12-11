package com.yidu.service.impl;

 
import com.yidu.dao.SaleMapper;
import com.yidu.domain.Sale;
import com.yidu.service.SaleService;
import com.yidu.util.PageUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 销售单 服务实现类
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Service
public class SaleServiceImpl   implements SaleService {
	/**
	 * 注入销售单Mapper
	 */
	@Resource
	private SaleMapper mapper;
}
