package com.yidu.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import com.yidu.domain.MatInv;

public interface MatInvMapper {
    int deleteByPrimaryKey(String miId);

    int insert(MatInv record);

    int insertSelective(MatInv record);

    MatInv selectByPrimaryKey(String miId);

    int updateByPrimaryKeySelective(MatInv record);

    int updateByPrimaryKey(MatInv record);
    
    
    /**
     * 查询所有
     * @param map
     * @return
     */
    List<MatInv> showList(Map<String, Object> map);
    
    /**
     * 查询总行数
     * @param matinv
     * @return
     */
    int selectCount(MatInv matinv);
    
    /**
     * 
     * 方法说明：根据质检明细id查询库存
     * @param qcFkId
     * @return
     * @author dengknagwei
     * @date：2018年12月27日
     */
	MatInv findQcId(String qcFkId);
	
	/**
     * 
     * 方法说明：加库存数量
     * @param miAmount
     * @param miId
     * @return
     * @author dengknagwei
     * @date：2018年12月27日
     */
    @Update("UPDATE drug_mat_inv SET mi_amount = mi_amount + #{miAmount} WHERE mi_id = #{miId}")
	int updateAmount(@Param("miAmount")Integer miAmount,@Param("miId")String miId);
}