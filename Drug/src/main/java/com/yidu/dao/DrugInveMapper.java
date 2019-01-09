package com.yidu.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.yidu.controller.vo.Repertory;
import com.yidu.domain.DrugInve;

public interface DrugInveMapper {
    int deleteByPrimaryKey(String diId);

    int insert(DrugInve record);

    int insertSelective(DrugInve record);

    DrugInve selectByPrimaryKey(String diId);

    int updateByPrimaryKeySelective(DrugInve record);

    int updateByPrimaryKey(DrugInve record);
    
    /**
     *  查询所有
     * @return
     */
    List<DrugInve> qureyAll(Map<String, Object> map);
    /**
     * 查询行数
     * @param record
     * @return
     */
    	
    int  selectCountBySelective(DrugInve  record);
    
    public List<DrugInve> findselect(DrugInve drugInve);
    
    /**
     * 减库存
     * @param drugInve
     * @return
     */
    public int amountupdate(DrugInve drugInve);
    /**
     * 查询是否有该药品
     * @param id
     * @return
     */
    
    List<DrugInve> selectDrugId(String   id);
    
    /**
     * 根据药品ID修改库存数量
     * @param drugInve
     * @return
     */
    int   updateamount(DrugInve drugInve);
    
    
    /**
     * 
     * @param id
     * @return
     */
    
    List<DrugInve> findDrug(String id);
    /**
     * 根据商品id查询库存
     * @param drugId
     * @return 库存model
     * @author ly
     */
    public DrugInve findDrugId(Map<String, Object> map);
    
    List<Repertory> queryBalance(String id);
    
    /**
     * 
     * 方法说明：药品库存加库存数量
     * @param qdetAmount
     * @param diId
     * @return
     * @author zhengyouhong
     * @date：2018年12月27日
     */
    @Update("UPDATE drug_drug_inv SET di_amount = di_amount + #{diAmount} WHERE di_id = #{diId}")
	int updateAmounts(@Param("diAmount")Integer qdetAmount,@Param("diId")String diId);

    @Select("select * from drug_drug_inv")
	DrugInve findById(String id);

    @Select("SELECT * FROM drug_drug_inv WHERE drug_id=#{qcFkId} ")
	DrugInve findQcId(@Param("qcFkId")String qcFkId);
}