package com.dao;

import com.entity.GangweifenleiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.GangweifenleiVO;
import com.entity.view.GangweifenleiView;


/**
 * 岗位分类
 * 
 * @author 
 * @email 
 * @date 2020-05-13 10:02:23
 */
public interface GangweifenleiDao extends BaseMapper<GangweifenleiEntity> {
	
	List<GangweifenleiVO> selectListVO(@Param("ew") Wrapper<GangweifenleiEntity> wrapper);
	
	GangweifenleiVO selectVO(@Param("ew") Wrapper<GangweifenleiEntity> wrapper);
	
	List<GangweifenleiView> selectListView(@Param("ew") Wrapper<GangweifenleiEntity> wrapper);

	List<GangweifenleiView> selectListView(Pagination page,@Param("ew") Wrapper<GangweifenleiEntity> wrapper);
	
	GangweifenleiView selectView(@Param("ew") Wrapper<GangweifenleiEntity> wrapper);
}
