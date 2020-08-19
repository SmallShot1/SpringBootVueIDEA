package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.GangweifenleiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.GangweifenleiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.GangweifenleiView;


/**
 * 岗位分类
 *
 * @author 
 * @email 
 * @date 2020-05-13 10:02:23
 */
public interface GangweifenleiService extends IService<GangweifenleiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GangweifenleiVO> selectListVO(Wrapper<GangweifenleiEntity> wrapper);
   	
   	GangweifenleiVO selectVO(@Param("ew") Wrapper<GangweifenleiEntity> wrapper);
   	
   	List<GangweifenleiView> selectListView(Wrapper<GangweifenleiEntity> wrapper);
   	
   	GangweifenleiView selectView(@Param("ew") Wrapper<GangweifenleiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GangweifenleiEntity> wrapper);
}

