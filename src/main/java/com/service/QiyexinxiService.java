package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.QiyexinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.QiyexinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.QiyexinxiView;


/**
 * 企业信息
 *
 * @author 
 * @email 
 * @date 2020-05-13 10:02:22
 */
public interface QiyexinxiService extends IService<QiyexinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<QiyexinxiVO> selectListVO(Wrapper<QiyexinxiEntity> wrapper);
   	
   	QiyexinxiVO selectVO(@Param("ew") Wrapper<QiyexinxiEntity> wrapper);
   	
   	List<QiyexinxiView> selectListView(Wrapper<QiyexinxiEntity> wrapper);
   	
   	QiyexinxiView selectView(@Param("ew") Wrapper<QiyexinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<QiyexinxiEntity> wrapper);
}

