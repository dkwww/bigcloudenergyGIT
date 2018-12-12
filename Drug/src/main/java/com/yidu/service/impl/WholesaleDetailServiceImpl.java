package com.yidu.service.impl;

 
import com.yidu.dao.WholesaleDetailMapper;
import com.yidu.domain.WholesaleDetail;
import com.yidu.service.WholesaleDetailService;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 分店批发明细 服务实现类
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Service
public class WholesaleDetailServiceImpl  implements WholesaleDetailService {
	@Resource
	WholesaleDetailMapper wholeMap;
		
	@Override
	public int insertSelective(WholesaleDetail wholesaleDetail) {
		return wholeMap.insertSelective(wholesaleDetail);
	}

	@Override
	public int selectCount(Map<String, Object> map) {
		return wholeMap.selectCount(map);
	}

	@Override
	public List<WholesaleDetail> selectdetaiM(Map<String, Object> map) {
		return wholeMap.selectdetaiM(map);
	}

}
