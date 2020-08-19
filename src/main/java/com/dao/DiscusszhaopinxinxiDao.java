package com.dao;

import com.entity.DiscusszhaopinxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusszhaopinxinxiVO;
import com.entity.view.DiscusszhaopinxinxiView;


/**
 * 招聘信息评论表
 * 
 * @author 
 * @email 
 * @date 2020-05-13 10:02:23
 */
public interface DiscusszhaopinxinxiDao extends BaseMapper<DiscusszhaopinxinxiEntity> {
	
	List<DiscusszhaopinxinxiVO> selectListVO(@Param("ew") Wrapper<DiscusszhaopinxinxiEntity> wrapper);
	
	DiscusszhaopinxinxiVO selectVO(@Param("ew") Wrapper<DiscusszhaopinxinxiEntity> wrapper);
	
	List<DiscusszhaopinxinxiView> selectListView(@Param("ew") Wrapper<DiscusszhaopinxinxiEntity> wrapper);

	List<DiscusszhaopinxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusszhaopinxinxiEntity> wrapper);
	
	DiscusszhaopinxinxiView selectView(@Param("ew") Wrapper<DiscusszhaopinxinxiEntity> wrapper);
}
