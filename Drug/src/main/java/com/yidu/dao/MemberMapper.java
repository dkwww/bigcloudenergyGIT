package com.yidu.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.yidu.domain.Member;
import com.yidu.util.PageUtil;
/**
 * 会员mapper
 * @author liuyi
 * @since 2018-11-26
 *
 */
public interface MemberMapper {
	/**
	 * 删除
	 * @param menId 会员ID
	 * @return int
	 */
    int deleteByPrimaryKey(String menId);
    /**
     * 增加
     * @param record 会员model
     * @return int
     */
    int insert(Member record);
    /**
     * 增加
     * @param record 会员ID
     * @return int
     */
    int insertSelective(Member record);
    /**
     * 查询
     * @param menId 会员ID
     * @return 会员model
     */
    Member selectByPrimaryKey(String menId);
    /**
     * 修改完后查询
     * @param record 会员
     * @return int
     */
    int updateByPrimaryKeySelective(Member record);
    /**
     * 修改
     * @param record 会员
     * @return int
     */
    int updateByPrimaryKey(Member record);
    /**
     * 查询所有
     * @param maps 集合
     * @return 会员的List集合
     */
    public List<Member> selectAll(Map<String, Object> maps);
    /**
     * 批量删除
     * @param ids
     * @return int
     */
    int bulkDelete(List<String> ids);
    /**
     * 分页
     * @param record 会员model
     * @return int
     */
    int findCount(Member record);
    
    /**
     * 根据会员名查询
     * @param menName 会员名
     * @return int
     */
    @Select("select count(*) from drug_member where men_name=#{menName}")
	int selectMenName(String menName);
}