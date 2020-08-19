package com.dao;

import com.entity.QiyexinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.QiyexinxiVO;
import com.entity.view.QiyexinxiView;


/**
 * 企业信息
 * 
 * @author 
 * @email 
 * @date 2020-05-13 10:02:22
 */
public interface QiyexinxiDao extends BaseMapper<QiyexinxiEntity> {
	
	List<QiyexinxiVO> selectListVO(@Param("ew") Wrapper<QiyexinxiEntity> wrapper);
	
	QiyexinxiVO selectVO(@Param("ew") Wrapper<QiyexinxiEntity> wrapper);
	
	List<QiyexinxiView> selectListView(@Param("ew") Wrapper<QiyexinxiEntity> wrapper);

	List<QiyexinxiView> selectListView(Pagination page,@Param("ew") Wrapper<QiyexinxiEntity> wrapper);
	
	QiyexinxiView selectView(@Param("ew") Wrapper<QiyexinxiEntity> wrapper);
}
