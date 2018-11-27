/**
 * 
 */
package com.yidu.util;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


/**
 * 项目名：chapter02
 * 文件名：UploadTool.java
 * @author ZhouJun
 * @date： 2018年8月22日下午9:31:11
 * 类说明: 上传文件工具类
 */
public class UploadUtil {
	public static String upload(HttpServletRequest req) throws Exception{
		MultipartHttpServletRequest mreq = (MultipartHttpServletRequest)req;
		MultipartFile file = mreq.getFile("file");
		if(!"".equals(file.getOriginalFilename())){
			String fileName = UUID.randomUUID().toString().replace("-", "")+"."+file.getOriginalFilename().split("\\.")[1];
			String path = req.getSession().getServletContext().getRealPath("/")+"upload/"+fileName;
			file.transferTo(new File(path));
			return "upload/"+fileName;
		}
		return null;
	}
}
