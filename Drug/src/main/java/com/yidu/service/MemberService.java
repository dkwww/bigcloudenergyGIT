package com.yidu.service;

import java.util.List;
import java.util.Map;

import com.yidu.domain.Member;
import com.yidu.util.PageUtil;


/**
 * 会员 服务类
 *
 * @author Liuyi
 * @since 2018-11-26
 */
public interface MemberService   {
	/**
	 * 查询所有
	 * @param util 分页model
	 * @param member 会员model
	 * @return 会员的List集合
	 */
	public List<Member> query(PageUtil util,Member member);
	
	/**
	 * 增加修改
	 * @param record 会员model
	 * @return int
	 */
	public int addOrUpdate(Member record);
	
	/**
	 * 删除
	 * @param menId 会员ID
	 * @return int
	 */
	public int delete(String menId);
	/**
	 * 批量删除
	 * @param ids ID
	 * @return int
	 */
	public int bulkUpdate(List<String> ids);
	/**
	 * 分页
	 * @param member 会员model
	 * @return int
	 */
	public int findCount(Member member);
	/**
	 * 根据会员ID查询
	 * @param menId 会员ID
	 * @return 会员model
	 */
	public Member findById(String menId);
	/**
	 * 根据会员名查询
	 * @param menName 会员名
	 * @return int
	 */
	public int findMenName(String menName);
}
