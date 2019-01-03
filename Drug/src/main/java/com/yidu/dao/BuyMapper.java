package com.yidu.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import com.yidu.domain.Audit;
import com.yidu.domain.Buy;


public interface BuyMapper {
    int deleteByPrimaryKey(String buyId);

    int insert(Buy record);

    int insertSelective(Buy record);

    Buy selectByPrimaryKey(String buyId);

    int updateByPrimaryKeySelective(Buy record);

    int updateByPrimaryKey(Buy record);
    
    
    /**
     * 查询所有
     * @return
     */
    public List<Buy> findAll(Map<String, Object> map);
    
    /**
     * 查找总行数
     * @param buy
     * @return
     */
	public int selectCountBySelective(Buy buy);
	
	/**
	 * 
	 * 方法说明：查询所有
	 * @param map
	 * @return
	 * @author dengknagwei
	 * @date：2019年1月3日
	 */
    public List<Buy> showList(Map<String, Object> map);
    /**
     * 
     * 方法说明：查找总行数
     * @param buy
     * @return
     * @author dengknagwei
     * @date：2019年1月3日
     */
    int selectCount(Buy buy);
    
    /**
     * 审核查询所有
     * @param map
     * 邓康威
     * @return
     */
    public List<Buy> AuditshowList(Map<String,Object> map);
    
    /**
     * 审核查询总行数
     * @param buy
     * @author 郑有宏
     * @return
     */
    public int AuditselectCount(Buy buy);
    
    
    /**
	 * 修改审核状态
	 * @param status
	 * @param buyId
	 * @author 郑有宏
	 * @return
	 */
	@Update("UPDATE drug_buy SET buy_audit = #{audit} WHERE buy_id = #{buyId}")
	int updateAudit(@Param("audit")String audit,@Param("buyId")String buyId);

	/**
	 * 修改订单状态
	 * @param status
	 * @param buyId
	 * @author 郑有宏
	 * @return
	 */
	@Update("UPDATE drug_buy SET buy_state = #{status} WHERE buy_id = #{buyId}")
	int updateStates(@Param("status")String status,@Param("buyId")String buyId);
}