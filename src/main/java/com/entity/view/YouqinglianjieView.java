package com.entity.view;

import com.entity.YouqinglianjieEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 友情链接
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2020-05-13 10:02:23
 */
@TableName("youqinglianjie")
public class YouqinglianjieView  extends YouqinglianjieEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YouqinglianjieView(){
	}
 
 	public YouqinglianjieView(YouqinglianjieEntity youqinglianjieEntity){
 	try {
			BeanUtils.copyProperties(this, youqinglianjieEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
