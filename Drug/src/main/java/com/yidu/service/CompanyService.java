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
     * 查询所有
     * @return
     */
	List<Company> findAll(Company company,PageUtil pageUtil);
	
	int selectCount(Company company);
	
	 /**
     * 增加或者修改的方法
     * @param vo
     * @return
     */
    int addOrUpdate(Company com);
    
    
    int insertSelective(Company record);

    int companyUpdate(List<String> ids);

    int updateByPrimaryKeySelective(Company record);
}
