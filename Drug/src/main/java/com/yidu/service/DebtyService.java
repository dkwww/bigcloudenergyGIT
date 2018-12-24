package com.yidu.service;

import java.util.List;

import com.yidu.domain.Debty;

import com.yidu.util.PageUtil;

/**
 * <p>
 * 财务表 服务类
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
public interface DebtyService   {
	/**
     *财务 查询所有
     * @return
     */
	List<Debty> findAll(Debty debty,PageUtil pageUtil);
	
	
	/**
	 * 查询总共多少条数据
	 * @param Debty 财务对象
	 * @return
	 */
	int selectCount(Debty debty);

	 /**
	  * 增加或者修改的方法
	  * @param det 财务对象
	  * @return
	  */
    int addOrUpdate(Debty det);
    

    /**
     * 增加的方法
     * @param record 财务对象
     * @return
     */
    int insertSelective(Debty  record);
   
    /**
     * 财务批量修改
     * @param ids 根据传入的id查询
     * @return
     */
    int debtyUpdate(List<String> ids);

    /**
     * 修改
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Debty record);
    
    /**
     * 审核修改金额
     * @param debty
     * @return
     */
    int moneyupdate(Debty debty);
    
    /**
     * 根据药品id查询
     * @param drugId
     * @return
     */
    Debty findByComId(String drugId);
}
