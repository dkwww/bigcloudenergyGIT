package com.yidu.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

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
    
    /**
     * 根据店铺id查询
     * @param comId
     * @return
     */
	Debty findByComId(String comId);

	/**
	 * 根据店铺id查询财务
	 * @author 邓康威
	 * @param comId
	 * @return
	 */
	List<Debty> findcomIds(String comId);
	
	/**
	 * 减财务
	 * @param money
	 * @param debtyId
	 * @author 邓康威
	 * @return
	 */
	@Update("UPDATE drug_debty SET deb_money = deb_money - #{money} WHERE deb_id = #{debtyId}")
	int updateMoney(@Param("money")BigDecimal money,@Param("debtyId")String debtyId);
}
   