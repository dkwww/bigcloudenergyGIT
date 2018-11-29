package com.yidu.service.impl;

 
import com.yidu.dao.WholesaleMapper;
import com.yidu.domain.Wholesale;
import com.yidu.service.WholesaleService;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 分店批发 服务实现类
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Service
public class WholesaleServiceImpl  implements WholesaleService {
	
	@Resource
	WholesaleMapper whole;

	@Override
	public List<Wholesale> selectAll(Wholesale wholesale) {
		return whole.selectAll(wholesale);
	}

	@Override
	public int updateisva(Wholesale wholesale) {
		return whole.updateisva(wholesale);
	}
	
	@Override
	public int updateByPrimaryKeySelective(Wholesale wholesale) {
		return whole.updateByPrimaryKeySelective(wholesale);
	}
}
