package com.yidu.service;

import java.util.List;

import com.yidu.domain.MrpDetails;
import com.yidu.util.PageUtil;

/**
 * <p>
 * 制造计划明细 服务类
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
public interface MrpDetailsService   {

   List<MrpDetails>  findById(MrpDetails   mrpDetails ,PageUtil  page);
   
   
   
   
   
   int  findBycount(MrpDetails   mrpDetails);
   
   int  findStatistics(MrpDetails   mrpDetails);
   
   
   int   add(MrpDetails   mrpDetails);
   
   int   findmax  (MrpDetails  mrpDetails);
   
   int   findPercentage(MrpDetails  mrpDetails);  
   
   
	  
 
}
 