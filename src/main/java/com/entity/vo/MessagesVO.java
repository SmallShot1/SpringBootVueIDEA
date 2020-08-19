package com.entity.vo;

import com.entity.MessagesEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 留言板
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2020-05-13 10:02:23
 */
public class MessagesVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 留言人id
	 */
	
	private Long userid;
				
	
	/**
	 * 设置：留言人id
	 */
	 
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	
	/**
	 * 获取：留言人id
	 */
	public Long getUserid() {
		return userid;
	}
			
}
