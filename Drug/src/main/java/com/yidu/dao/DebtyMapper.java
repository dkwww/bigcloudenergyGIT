package com.yidu.dao;

import java.util.List;
import java.util.Map;


import com.yidu.domain.Debty;

public interface DebtyMapper {
    int deleteByPrimaryKey(String debId);

    int insert(Debty record);

    int insertSelective(Debty record);

    Debty selectByPrimaryKey(String debId);

    int updateByPrimaryKeySelective(Debty record);

    int updateByPrimaryKey(Debty record);
    
    /**
     * 查询所有
     * @param vo
     * @return
     */
    List<Debty> selectAll(Map<String, Object> map);
 
    
    int selectCount(Debty debty);
  
    int DebtyDeleteByPrimaryKeySelective(List<String> ids);
    
    /**
     * 财务审核完成修改金额
     * @param debty
     * @return
     */
    int moneyupdate(Debty debty);
}
   