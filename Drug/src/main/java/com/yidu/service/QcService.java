package com.yidu.service;

import java.util.List;

import com.yidu.domain.Qc;
import com.yidu.util.PageUtil;

/**
 * <p>
 * 质检表 服务类
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
public interface QcService  {
	
	
	List<Qc>  selectqctype(Qc  qc,PageUtil pageUtil);
	
	
	int selectCountBySelective(Qc  qc);

}
