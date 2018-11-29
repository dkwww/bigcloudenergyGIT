package com.yidu.service.impl;

 


import com.yidu.dao.MemberMapper;
import com.yidu.domain.Member;
import com.yidu.service.MemberService;
import com.yidu.util.TimeUtil;
import com.yidu.util.Tools;

import java.util.Date;
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
	 * 增加
	 */
	@Override
	public int addOrUpdate(Member record) {
		if (record.getMenId()!=null && !"".equals(record.getMenId())) {
			record.setOptime(new Date());
			return mapper.updateByPrimaryKeySelective(record);
		}else {
			record.setIsva("1");
			record.setSort(TimeUtil.getStrDate());
			record.setOptime(new Date());
			return mapper.insertSelective(record);
		}
	}
	
	/**
	 * 删除
	 */
	@Override
	public int delete(String menId) {
		//调用dao类根据ID查询的方法
		Member member=mapper.selectByPrimaryKey(menId);
		//取到是否有效为0
		member.setIsva("0");
		//返回dao类根据ID修改的方法
		return mapper.updateByPrimaryKeySelective(member);
	}
}