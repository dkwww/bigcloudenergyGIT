package com.yidu.service;

import java.util.List;
import java.util.Map;

import com.yidu.domain.Member;


/**
 * <p>
 * 会员 服务类
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
public interface MemberService   {
	public List<Member> query(Map<String, Object> maps);
}
