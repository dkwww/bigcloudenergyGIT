package com.yidu.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import com.yidu.domain.Debty;

public interface DebtyMapper {
	int queryDebtyNum(String id);
	
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
	 * 
	 * 方法说明：根据采购订单查询财务
	 * @param comId
	 * @return
	 * @author dengknagwei
	 * @date：2018年12月27日
	 */
	Debty findcwId(String comId);
	
	
	/**
	 * 
	 * 方法说明：减财务
	 * @param buyMoney
	 * @param debtyId
	 * @return
	 * @author dengkangwei
	 * @date：2019年1月8日
	 */
	@Update("UPDATE drug_debty SET deb_money = deb_money - #{buyMoney} WHERE deb_id = #{debtyId}")
	int updateMoney(@Param("buyMoney")BigDecimal buyMoney,@Param("debtyId")String debtyId);
	
	
	/**
	 * 方法说明：加财务
	 * @param money
	 * @param debtyId
	 * @author 郑有宏
	 * @return
	 */
	@Update("UPDATE drug_debty SET deb_money = deb_money + #{buyMoney} WHERE deb_id = #{debtyId}")
	int addMoney(@Param("buyMoney")BigDecimal buyMoney,@Param("debtyId")String debtyId);
}
   