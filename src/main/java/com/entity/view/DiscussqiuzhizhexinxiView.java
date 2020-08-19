package com.entity.view;

import com.entity.DiscussqiuzhizhexinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 求职者信息评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2020-05-13 10:02:23
 */
@TableName("discussqiuzhizhexinxi")
public class DiscussqiuzhizhexinxiView  extends DiscussqiuzhizhexinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussqiuzhizhexinxiView(){
	}
 
 	public DiscussqiuzhizhexinxiView(DiscussqiuzhizhexinxiEntity discussqiuzhizhexinxiEntity){
 	try {
			BeanUtils.copyProperties(this, discussqiuzhizhexinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
