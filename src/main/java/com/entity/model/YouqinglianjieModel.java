package com.entity.model;

import com.entity.YouqinglianjieEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 友情链接
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2020-05-13 10:02:23
 */
public class YouqinglianjieModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * logo
	 */
	
	private String logo;
		
	/**
	 * 网址
	 */
	
	private String wangzhi;
		
	/**
	 * 网站介绍
	 */
	
	private String wangzhanjieshao;
				
	
	/**
	 * 设置：logo
	 */
	 
	public void setLogo(String logo) {
		this.logo = logo;
	}
	
	/**
	 * 获取：logo
	 */
	public String getLogo() {
		return logo;
	}
				
	
	/**
	 * 设置：网址
	 */
	 
	public void setWangzhi(String wangzhi) {
		this.wangzhi = wangzhi;
	}
	
	/**
	 * 获取：网址
	 */
	public String getWangzhi() {
		return wangzhi;
	}
				
	
	/**
	 * 设置：网站介绍
	 */
	 
	public void setWangzhanjieshao(String wangzhanjieshao) {
		this.wangzhanjieshao = wangzhanjieshao;
	}
	
	/**
	 * 获取：网站介绍
	 */
	public String getWangzhanjieshao() {
		return wangzhanjieshao;
	}
			
}
