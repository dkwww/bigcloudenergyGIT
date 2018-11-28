package com.yidu.dao;

import java.util.List;
import java.util.Map;

import com.yidu.domain.Member;

public interface MemberMapper {
    int deleteByPrimaryKey(String menId);

    int insert(Member record);

    int insertSelective(Member record);

    Member selectByPrimaryKey(String menId);

    int updateByPrimaryKeySelective(Member record);

    int updateByPrimaryKey(Member record);
    /**
     * 显示列表
     * @param maps
     * @return
     */
    public List<Member> selectAll(Map<String, Object> maps);
}