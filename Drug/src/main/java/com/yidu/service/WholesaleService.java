package com.yidu.service;

import java.util.List;
import java.util.Map;

import com.yidu.domain.Drug;
import com.yidu.domain.Wholesale;

/**
 * <p>
 * 分店批发 服务类
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
public interface WholesaleService  {
	public List<Wholesale> selectAll(Map<String, Object> map);
	
	public int updateisva(Wholesale wholesale);
	
	public int updateByPrimaryKeySelective(Wholesale wholesale);
	
	int addOrUpdate(Wholesale record);
	
	public int selectCount(Map<String, Object> map);
	
	public int insertSelective(Wholesale wholesale);
}
