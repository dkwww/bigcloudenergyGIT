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
     * 分店分页以及模糊查询
     * @param map
     * @return
     */
    List<Company> selectAll(Map<String, Object> map);
    List<Company> checkselectAll(Map<String, Object> map);
    /**
     * 查询总共多少条数据 
     * @param company
     * @return
     */
    int selectCount(Company company);
    /**
     * 根据条件为分店和状态为0的查询总共多少条数据
     * @param company
     * @return
     */
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