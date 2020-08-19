package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YingpinxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YingpinxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YingpinxinxiView;


/**
 * 应聘信息
 *
 * @author 
 * @email 
 * @date 2020-05-13 10:02:23
 */
public interface YingpinxinxiService extends IService<YingpinxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YingpinxinxiVO> selectListVO(Wrapper<YingpinxinxiEntity> wrapper);
   	
   	YingpinxinxiVO selectVO(@Param("ew") Wrapper<YingpinxinxiEntity> wrapper);
   	
   	List<YingpinxinxiView> selectListView(Wrapper<YingpinxinxiEntity> wrapper);
   	
   	YingpinxinxiView selectView(@Param("ew") Wrapper<YingpinxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YingpinxinxiEntity> wrapper);
}

