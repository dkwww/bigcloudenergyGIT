package com.yidu.service.impl;

 
import com.yidu.dao.WholesaleMapper;
import com.yidu.domain.Drug;
import com.yidu.domain.Wholesale;
import com.yidu.service.WholesaleService;
import com.yidu.util.TimeUtil;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.functors.WhileClosure;
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
	public List<Wholesale> selectAll(Map<String, Object> map) {
		
		return whole.selectAll(map);
	}

	@Override
	public int updateisva(Wholesale wholesale) {
		return whole.updateisva(wholesale);
	}
	
	@Override
	public int updateByPrimaryKeySelective(Wholesale wholesale) {
		return whole.updateByPrimaryKeySelective(wholesale);
	}
	
	
	@Override
	public int addOrUpdate(Wholesale record) {
		if (record.getWholId()!=null&&!"".equals(record.getWholId())) {
			return whole.updateByPrimaryKeySelective(record);
		} else {
			record.setIsva("1");
			record.setSort(TimeUtil.getStrDate());
			record.setComId("1");
			return whole.insertSelective(record);
		}
	}

	@Override
	public int selectCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return whole.selectCount(map);
	}
}
