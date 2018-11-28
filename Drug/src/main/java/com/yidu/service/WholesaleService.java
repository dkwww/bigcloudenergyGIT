package com.yidu.service;

import java.util.List;

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
	public List<Wholesale> selectAll(Wholesale wholesale);
	
	public int updateisva(Wholesale wholesale);
}
