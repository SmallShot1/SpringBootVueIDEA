package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YouqinglianjieEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YouqinglianjieVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YouqinglianjieView;


/**
 * 友情链接
 *
 * @author 
 * @email 
 * @date 2020-05-13 10:02:23
 */
public interface YouqinglianjieService extends IService<YouqinglianjieEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YouqinglianjieVO> selectListVO(Wrapper<YouqinglianjieEntity> wrapper);
   	
   	YouqinglianjieVO selectVO(@Param("ew") Wrapper<YouqinglianjieEntity> wrapper);
   	
   	List<YouqinglianjieView> selectListView(Wrapper<YouqinglianjieEntity> wrapper);
   	
   	YouqinglianjieView selectView(@Param("ew") Wrapper<YouqinglianjieEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YouqinglianjieEntity> wrapper);
}

