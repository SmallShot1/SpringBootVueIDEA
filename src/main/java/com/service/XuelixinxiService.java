package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XuelixinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.XuelixinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.XuelixinxiView;


/**
 * 学历信息
 *
 * @author 
 * @email 
 * @date 2020-05-13 10:02:23
 */
public interface XuelixinxiService extends IService<XuelixinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XuelixinxiVO> selectListVO(Wrapper<XuelixinxiEntity> wrapper);
   	
   	XuelixinxiVO selectVO(@Param("ew") Wrapper<XuelixinxiEntity> wrapper);
   	
   	List<XuelixinxiView> selectListView(Wrapper<XuelixinxiEntity> wrapper);
   	
   	XuelixinxiView selectView(@Param("ew") Wrapper<XuelixinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XuelixinxiEntity> wrapper);
}

