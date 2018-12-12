package com.yidu.service;

import java.util.List;
import java.util.Map;

import com.yidu.domain.Wholesale;
import com.yidu.domain.WholesaleDetail;

/**
 * <p>
 * 分店批发明细 服务类
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
public interface WholesaleDetailService   {
	public int insertSelective(WholesaleDetail wholesaleDetail);
	
	public int selectCount(Map<String, Object> map);
	
	public List<WholesaleDetail> selectdetaiM(Map<String, Object> map);
}
