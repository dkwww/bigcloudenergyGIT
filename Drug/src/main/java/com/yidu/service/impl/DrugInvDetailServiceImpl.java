package com.yidu.service.impl;

 
import com.yidu.dao.DrugInvDetailMapper;
import com.yidu.domain.DrugInvDetail;
import com.yidu.service.DrugInvDetailService;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 药品库存明细 服务实现类
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Service
public class DrugInvDetailServiceImpl   implements DrugInvDetailService {
	@Resource
  private  DrugInvDetailMapper   dao;
	@Override
	public List<DrugInvDetail> findById(String id) {
		System.out.println("-------------------2-"+id);
		List<DrugInvDetail> list = dao.selectByPrimaryKey(id);
		return list  ;
	}
	@Override
	public int selectcount(String id) {
		 System.out.println("--------------------"+id);
		return dao.selectcount(id);
	}

}
