package com.yidu.service.impl;

 

import com.yidu.dao.MemberMapper;
import com.yidu.domain.Member;
import com.yidu.service.MemberService;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


/**
 * <p>
 * 会员 服务实现类
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Service
public class MemberServiceImpl   implements MemberService {
	@Resource
	MemberMapper mapper;
	
	/**
	 * 查询所有
	 */
	@Override
	public List<Member> query(Map<String, Object> maps) {
		//返回dao类查询所有的方法
		return mapper.selectAll(maps);
	}
	
	/**
	 * 修改
	 */
	@Override
	public int update(String menId) {
		Member member=mapper.selectByPrimaryKey(menId);
		member.setIsva("0");
		//返回dao类修改的方法
		return mapper.updateByPrimaryKeySelective(member);
	}

}
