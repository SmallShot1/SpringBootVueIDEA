package com.dao;

import com.entity.DiscussqiuzhizhexinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussqiuzhizhexinxiVO;
import com.entity.view.DiscussqiuzhizhexinxiView;


/**
 * 求职者信息评论表
 * 
 * @author 
 * @email 
 * @date 2020-05-13 10:02:23
 */
public interface DiscussqiuzhizhexinxiDao extends BaseMapper<DiscussqiuzhizhexinxiEntity> {
	
	List<DiscussqiuzhizhexinxiVO> selectListVO(@Param("ew") Wrapper<DiscussqiuzhizhexinxiEntity> wrapper);
	
	DiscussqiuzhizhexinxiVO selectVO(@Param("ew") Wrapper<DiscussqiuzhizhexinxiEntity> wrapper);
	
	List<DiscussqiuzhizhexinxiView> selectListView(@Param("ew") Wrapper<DiscussqiuzhizhexinxiEntity> wrapper);

	List<DiscussqiuzhizhexinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussqiuzhizhexinxiEntity> wrapper);
	
	DiscussqiuzhizhexinxiView selectView(@Param("ew") Wrapper<DiscussqiuzhizhexinxiEntity> wrapper);
}
