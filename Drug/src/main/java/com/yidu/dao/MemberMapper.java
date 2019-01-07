package com.yidu.dao;

import java.util.List;
import java.util.Map;

import com.yidu.domain.Member;
import com.yidu.util.PageUtil;

public interface MemberMapper {
    int deleteByPrimaryKey(String menId);

    int insert(Member record);

    int insertSelective(Member record);

    Member selectByPrimaryKey(String menId);

    int updateByPrimaryKeySelective(Member record);

    int updateByPrimaryKey(Member record);
    /**
     * 显示列表
     * @param maps 集合
     * @return
     */
    public List<Member> selectAll(Map<String, Object> maps);
    /**
     * 批量删除
     * @param ids
     * @return
     */
    int bulkDelete(List<String> ids);
    /**
     * 分页
     * @param record 会员model
     * @return
     */
    int findCount(Member record);
}