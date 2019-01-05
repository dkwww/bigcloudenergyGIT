package com.yidu.service;

import java.util.List;

import com.yidu.controller.vo.Repertory;
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
	  * 查找是否有该药品
	  * @param id
	  * @return
	  */
	   List<DrugInve>  selectDrugId(String   id);
	 
	 /**
	   * 根据药品id查询库存
	   * @param id
	   * @return
	   */
	  public DrugInve findDrug(String id);
	  
	  /**
	   * 质检完增加库存
	   * @param drugInve
	   * @return
	   */
	 int  updateamount (DrugInve drugInve);
	 
	 /**
	  *  库存没有就+一行数据
	  * @param record
	  * @return
	  */
	 int insert(DrugInve record);
	 
	 List<Repertory> queryBalance(String id);
}
