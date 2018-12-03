package com.yidu.service;

 

import java.util.List;

import com.yidu.domain.Mrp;
import com.yidu.util.PageUtil;

/**
 * <p>
 * 制造计划 服务类
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
public interface MrpService   {
	 /** 
	  * 查询所有  分页
	  * @param mrp 
	  * @param pageUtil
	  * @return
	  */
	public  List<Mrp>  qureyAll(Mrp  mrp , PageUtil pageUtil);
	
	
	/**
	 * 查询行数
	 * @param mrp
	 * @return
	 */
	   public  int  selectCountBySelectiv (Mrp  mrp);

}
  