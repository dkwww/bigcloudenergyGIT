package com.yidu.service;

import java.util.List;
import java.util.Map;

import com.yidu.domain.Member;
import com.yidu.util.PageUtil;


/**
 * <p>
 * 会员 服务类
 * </p>
 *
 * @author Liuyi
 * @since 2018-11-26
 */
public interface MemberService   {
	/**
	 * 查询所有
	 * @param maps map集合
	 * @return
	 */
	public List<Member> query(PageUtil util,Member member);
	
	/**
	 * 增加修改
	 * @param menId model
	 * @return
	 */
	public int addOrUpdate(Member record);
	
	/**
	 * 删除
	 * @param menId 会员ID
	 * @return
	 */
	public int delete(String menId);
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	public int bulkUpdate(List<String> ids);
	/**
	 * 分页
	 * @param member model
	 * @return
	 */
	public int findCount(Member member);
	/**
	 * 根据ID查询
	 * @param menId 
	 * @return
	 */
	public Member findById(String menId);

	public int findMenName(String menName);
	
	
}
