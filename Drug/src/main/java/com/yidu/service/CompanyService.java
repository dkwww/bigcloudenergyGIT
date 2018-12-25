package com.yidu.service;

import java.util.List;



import com.yidu.domain.Company;
import com.yidu.util.PageUtil;

/**
 * <p>
 * 店铺（分店、总店） 服务类
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
public interface CompanyService   {
	/**
     *分店 查询所有
     * @return
     */
	List<Company> findAll(Company company,PageUtil pageUtil);
	
	/**
	 * 审核查询所有
	 * @param company 分店对象
	 * @param pageUtil 分页对象
	 * @return
	 */
	List<Company> checkfindAll(Company company,PageUtil pageUtil);
	/**
	 * 查询总共多少条数据
	 * @param company 分店对象
	 * @return
	 */
	int selectCount(Company company);
	/**
	 * 审核查询总共多少条数据
	 * @param company 分店对象
	 * @return
	 */
	int checkselectCount(Company company);
	 /**
	  * 增加或者修改的方法
	  * @param com 分店对象
	  * @return
	  */
    int addOrUpdate(Company com);
    
    /**
     * 增加的方法
     * @param record 分店对象
     * @return
     */
    int insertSelective(Company record);
    /**
     * 分店批量修改
     * @param ids 根据传入的id查询
     * @return
     */
    int companyUpdate(List<String> ids);
    /**
     * 审核批量修改
     * @param ids
     * @return
     */
    int checkcompanyUpdate(List<String> ids);
    /**
     * 修改
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Company record);

    /**
     * 根据审核id查询分公司id
     * @param qcFkId
     * @author 邓康威
     * @return
     */
	List<Company> findDeId(String qcFkId);
    
}
