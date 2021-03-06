package com.yidu.service.impl;
import com.yidu.dao.MemberMapper;
import com.yidu.domain.Member;
import com.yidu.service.MemberService;
import com.yidu.util.PageUtil;
import com.yidu.util.TimeUtil;
import com.yidu.util.Tools;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
/**
 * 会员 服务实现类
 *
 * @author Liuyi
 * @since 2018-11-26
 */
@Service
public class MemberServiceImpl   implements MemberService {
	/**
	 * 注入会员mapper
	 */
	@Resource
	MemberMapper mapper;
	
	/**
	 * 查询所有
	 * @param util 分页model
	 * @param member 会员model
	 */
	@Override
	public List<Member> query(PageUtil util,Member member) {
		//new一个Map集合
		Map<String, Object> map=new HashMap<>();
		//取到页数
		map.put("util", util);
		//取到会员
		map.put("member", member);
		//返回dao类查询所有的方法
		return mapper.selectAll(map);
	}
	/**
	 * 增加修改
	 * @param record 会员model
	 */
	@Override
	public int addOrUpdate(Member record) {
		//如果会员ID不等于空并且不等于空字符串
		if (record.getMenId()!=null && !"".equals(record.getMenId())) {
			//取到操作时间
			record.setOptime(new Date());
			//返回会员mapper里面修改后查询的方法
			return mapper.updateByPrimaryKeySelective(record);
		}else {
			//取到是否有效为1
			record.setIsva("1");
			//取到排序
			record.setSort(TimeUtil.getStrDate());
			//取到操作时间
			record.setOptime(new Date());
			//返回会员mapper里面增加后查询的方法
			return mapper.insertSelective(record);
		}
	}
	
	/**
	 * 删除
	 * @param menId 会员ID
	 * @return 会员mapper里面根据ID修改的方法
	 */
	@Override
	public int delete(String menId) {
		//调用dao类根据ID查询的方法
		Member member=mapper.selectByPrimaryKey(menId);
		//取到是否有效为0
		member.setIsva("0");
		//返回会员mapper里面根据ID修改的方法
		return mapper.updateByPrimaryKeySelective(member);
	}
	
	/**
	 * 批量删除
	 * @param ids ID
	 * @return 会员mapper里面批量删除的方法
	 */
	@Override
	public int bulkUpdate(List<String> ids) {
		//返回会员mapper里面批量删除的方法
		return mapper.bulkDelete(ids);
	}
	
	/**
	 * 分页
	 * @param member 会员model
	 * @return 会员mapper里面分页的方法
	 */
	@Override
	public int findCount(Member member) {
		//返回会员mapper里面分页的方法
		return mapper.findCount(member);
	}
	/**
	 * 根据会员ID查询
	 * @param menId 会员ID
	 * @return 会员mapper里面查询的方法
	 */
	@Override
	public Member findById(String menId) {
		//返回会员mapper里面查询的方法
		return mapper.selectByPrimaryKey(menId);
	}
	/**
	 * 根据会员名查询
	 * @param menName 会员名
	 * @return rows
	 */
	@Override
	public int findMenName(String menName) { 
		//调用会员mapper里面根据名字查询的方法
		int rows=mapper.selectMenName(menName);
		//返回rows
		return rows;
	}
}