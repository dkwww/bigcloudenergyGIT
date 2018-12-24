package com.yidu.service;

import java.util.List;

import com.yidu.domain.DrugInve;
import com.yidu.util.PageUtil;

/**
 * <p>
 * 药品库存 服务类
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
public interface DrugInvService  {
	  /**
	   * 库存表查询所有
	   * @return
	   */
	 List<DrugInve>  qureyAll(DrugInve drugInve ,PageUtil  pageUtil);
	 /**
	  * 查询行数
	  * @param drugInve
	  * @return
	  */
	  int  selectCountBySelective(DrugInve drugInve);
	  
	 List<DrugInve> findselect(DrugInve drugInve);
	 
	 /**
	  * 减库存
	  * @param drugInve
	  * @return
	  */
	 int amountupdate(DrugInve drugInve);
	 
	 /**
	   * 根据药品id查询库存
	   * @param id
	   * @return
	   */
	  public DrugInve findDrug(String id);

}
