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
	
	@Override
	public List<Member> query(Map<String, Object> maps) {
		return mapper.selectAll(maps);
	}

}
