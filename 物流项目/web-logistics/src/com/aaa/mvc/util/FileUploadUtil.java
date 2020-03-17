package com.aaa.mvc.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

/***
 *@className:FileUploadUtil.java
 *@discripton:
 *@author:zz
 *@createTime:2018-10-16上午11:01:27
 *@version:
 */
public class FileUploadUtil {

	/**
	 * 封装上传方法
	 * @param savePath
	 * @param file
	 * @param request
	 * @return
	 */
	public static String uploadFile(String savePath,MultipartFile file,HttpServletRequest request){
		//定义变量保存路径，用于存在上传后的文件目录,该目录的相对位置为WebRoot
		//String savePath ="files";
		//因为涉及文件读写，所以要把相对路径转换为绝对路径
		String realPath = request.getServletContext().getRealPath(savePath);
		System.out.println("真实路径："+realPath);
		//realPath = D:\apache-tomcat7\webapps\spring-mvc3\files
		//           D:\apache-tomcat7\webapps\spring-mvc3\files
		//获取原文件名称
		String originalFilename = file.getOriginalFilename();//1.jpg
		//获取原文件后缀名称
		String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
		//拼装文件名称
		String newFilePath =UUID.randomUUID()+suffix;
		//实例化file使用绝对路径加原文件名称，这样就创建了和原文件名称一样的空文件
		File tempFile = new File(realPath+"/"+newFilePath);
		//如果父级目录不存在，创建
		if(!tempFile.exists()){
			tempFile.mkdirs();//递归创建父目录
		}
		//文件读写，把文件从本地读到服务器上创建的文件里面
		try {
			file.transferTo(tempFile);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return savePath+"/"+newFilePath;
	}
}
