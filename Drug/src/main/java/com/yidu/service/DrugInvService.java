package com.yidu.service;

import java.util.List;

import com.yidu.controller.vo.Repertory;
import com.yidu.domain.DrugInve;
import com.yidu.domain.MatInv;
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
	 * 查询所有药品库存总数
	 * @param id
	 * @return
	 */
	int queryDrug(String id);
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
	   List<DrugInve>  selectDrugId(DrugInve drugInve);
	 
	 /**
	   * 根据药品id查询库存
	   * @param id
	   * @return
	   */
	  public List<DrugInve> findDrug(String id);
	  
	  
	  /**
	   * 根据主键查询
	   * @param id
	   * @return
	   */
	  public DrugInve findById(String id);
	  
	  
	  /**
	   * 根据药品id查询查询
	   * @param id
	   * @return
	   */
	  public DrugInve findBydrugId(String qcFkId);
	  
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
	 
	 int insertSelective(DrugInve drugInve);
	 
	 /**
	  * 根据id修改库存
	  * @param qdetAmount
	  * @param diId
	  * @return
	  */
	 int updateAmounts(Integer qdetAmount, String diId);
	 
	 /**
	  * 根据id减库存
	  * @param qdetAmount
	  * @param diId
	  * @return
	  */
	 int minusAmounts(Integer qdetAmount, String diId);
}
