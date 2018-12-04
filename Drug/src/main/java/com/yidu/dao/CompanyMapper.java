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
    
    
    int selectCount(Company company);
    
    int companyDeleteByPrimaryKeySelective(List<String> ids);
}