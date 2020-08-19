package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.QiuzhizhexinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.QiuzhizhexinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.QiuzhizhexinxiView;


/**
 * 求职者信息
 *
 * @author 
 * @email 
 * @date 2020-05-13 10:02:23
 */
public interface QiuzhizhexinxiService extends IService<QiuzhizhexinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<QiuzhizhexinxiVO> selectListVO(Wrapper<QiuzhizhexinxiEntity> wrapper);
   	
   	QiuzhizhexinxiVO selectVO(@Param("ew") Wrapper<QiuzhizhexinxiEntity> wrapper);
   	
   	List<QiuzhizhexinxiView> selectListView(Wrapper<QiuzhizhexinxiEntity> wrapper);
   	
   	QiuzhizhexinxiView selectView(@Param("ew") Wrapper<QiuzhizhexinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<QiuzhizhexinxiEntity> wrapper);
}

