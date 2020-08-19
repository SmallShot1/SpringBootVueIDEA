package com.dao;

import com.entity.QiuzhizhexinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.QiuzhizhexinxiVO;
import com.entity.view.QiuzhizhexinxiView;


/**
 * 求职者信息
 * 
 * @author 
 * @email 
 * @date 2020-05-13 10:02:23
 */
public interface QiuzhizhexinxiDao extends BaseMapper<QiuzhizhexinxiEntity> {
	
	List<QiuzhizhexinxiVO> selectListVO(@Param("ew") Wrapper<QiuzhizhexinxiEntity> wrapper);
	
	QiuzhizhexinxiVO selectVO(@Param("ew") Wrapper<QiuzhizhexinxiEntity> wrapper);
	
	List<QiuzhizhexinxiView> selectListView(@Param("ew") Wrapper<QiuzhizhexinxiEntity> wrapper);

	List<QiuzhizhexinxiView> selectListView(Pagination page,@Param("ew") Wrapper<QiuzhizhexinxiEntity> wrapper);
	
	QiuzhizhexinxiView selectView(@Param("ew") Wrapper<QiuzhizhexinxiEntity> wrapper);
}
