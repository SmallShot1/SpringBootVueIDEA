package com.dao;

import com.entity.XuelixinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.XuelixinxiVO;
import com.entity.view.XuelixinxiView;


/**
 * 学历信息
 * 
 * @author 
 * @email 
 * @date 2020-05-13 10:02:23
 */
public interface XuelixinxiDao extends BaseMapper<XuelixinxiEntity> {
	
	List<XuelixinxiVO> selectListVO(@Param("ew") Wrapper<XuelixinxiEntity> wrapper);
	
	XuelixinxiVO selectVO(@Param("ew") Wrapper<XuelixinxiEntity> wrapper);
	
	List<XuelixinxiView> selectListView(@Param("ew") Wrapper<XuelixinxiEntity> wrapper);

	List<XuelixinxiView> selectListView(Pagination page,@Param("ew") Wrapper<XuelixinxiEntity> wrapper);
	
	XuelixinxiView selectView(@Param("ew") Wrapper<XuelixinxiEntity> wrapper);
}
