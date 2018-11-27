package com.yidu.dao;

import com.yidu.domain.Member;

public interface MemberMapper {
    int deleteByPrimaryKey(String menId);

    int insert(Member record);

    int insertSelective(Member record);

    Member selectByPrimaryKey(String menId);

    int updateByPrimaryKeySelective(Member record);

    int updateByPrimaryKey(Member record);
}