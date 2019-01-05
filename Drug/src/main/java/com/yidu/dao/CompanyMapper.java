package com.yidu.dao;


import java.util.List;
import java.util.Map;

import com.yidu.domain.Company;


public interface CompanyMapper {
    int deleteByPrimaryKey(String comId);

    int insert(Company record);

    int insertSelective(Company record);

    Company selectByPrimaryKey(String comId);

    int updateByPrimaryKeySelective(Company record);

    int updateByPrimaryKey(Company record);
    
    /**
     * 查询所有
     * @param vo
     * @return
     */
    List<Company> selectAll(Map<String, Object> map);
    List<Company> checkselectAll(Map<String, Object> map);
    
    int selectCount(Company company);
    int checkselectCount(Company company);
    /**
     * 分店批量删修改为0
     * @param ids
     * @return
     */
    int companyDeleteByPrimaryKeySelective(List<String> ids);
    /**
     * 审核分店批量修改为1
     * @param ids
     * @return
     */
    int checkcompanyDeleteByPrimaryKeySelective(List<String> ids);
  
    /**
     * 根据审核id查询分公司
     * @param qcFkId
     * @return
     */
	List<Company> findDeId(String qcFkId);
    
}