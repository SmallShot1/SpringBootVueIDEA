package com.dao;

import com.entity.ZhaopinxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZhaopinxinxiVO;
import com.entity.view.ZhaopinxinxiView;


/**
 * 招聘信息
 * 
 * @author 
 * @email 
 * @date 2020-05-13 10:02:22
 */
public interface ZhaopinxinxiDao extends BaseMapper<ZhaopinxinxiEntity> {
	
	List<ZhaopinxinxiVO> selectListVO(@Param("ew") Wrapper<ZhaopinxinxiEntity> wrapper);
	
	ZhaopinxinxiVO selectVO(@Param("ew") Wrapper<ZhaopinxinxiEntity> wrapper);
	
	List<ZhaopinxinxiView> selectListView(@Param("ew") Wrapper<ZhaopinxinxiEntity> wrapper);

	List<ZhaopinxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<ZhaopinxinxiEntity> wrapper);
	
	ZhaopinxinxiView selectView(@Param("ew") Wrapper<ZhaopinxinxiEntity> wrapper);
}
