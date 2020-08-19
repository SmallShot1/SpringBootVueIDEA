package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussqiuzhizhexinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussqiuzhizhexinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussqiuzhizhexinxiView;


/**
 * 求职者信息评论表
 *
 * @author 
 * @email 
 * @date 2020-05-13 10:02:23
 */
public interface DiscussqiuzhizhexinxiService extends IService<DiscussqiuzhizhexinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussqiuzhizhexinxiVO> selectListVO(Wrapper<DiscussqiuzhizhexinxiEntity> wrapper);
   	
   	DiscussqiuzhizhexinxiVO selectVO(@Param("ew") Wrapper<DiscussqiuzhizhexinxiEntity> wrapper);
   	
   	List<DiscussqiuzhizhexinxiView> selectListView(Wrapper<DiscussqiuzhizhexinxiEntity> wrapper);
   	
   	DiscussqiuzhizhexinxiView selectView(@Param("ew") Wrapper<DiscussqiuzhizhexinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussqiuzhizhexinxiEntity> wrapper);
}

