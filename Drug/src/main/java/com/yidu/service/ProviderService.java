package com.yidu.service;

import java.util.List;

import com.yidu.domain.Provider;

/**
 * <p>
 * 原料供应商 服务类
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
public interface ProviderService   {
	
	List<Provider> showList(Provider pro);
}
