package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.DiscussqiuzhizhexinxiDao;
import com.entity.DiscussqiuzhizhexinxiEntity;
import com.service.DiscussqiuzhizhexinxiService;
import com.entity.vo.DiscussqiuzhizhexinxiVO;
import com.entity.view.DiscussqiuzhizhexinxiView;

@Service("discussqiuzhizhexinxiService")
public class DiscussqiuzhizhexinxiServiceImpl extends ServiceImpl<DiscussqiuzhizhexinxiDao, DiscussqiuzhizhexinxiEntity> implements DiscussqiuzhizhexinxiService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussqiuzhizhexinxiEntity> page = this.selectPage(
                new Query<DiscussqiuzhizhexinxiEntity>(params).getPage(),
                new EntityWrapper<DiscussqiuzhizhexinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussqiuzhizhexinxiEntity> wrapper) {
		  Page<DiscussqiuzhizhexinxiView> page =new Query<DiscussqiuzhizhexinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussqiuzhizhexinxiVO> selectListVO(Wrapper<DiscussqiuzhizhexinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussqiuzhizhexinxiVO selectVO(Wrapper<DiscussqiuzhizhexinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussqiuzhizhexinxiView> selectListView(Wrapper<DiscussqiuzhizhexinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussqiuzhizhexinxiView selectView(Wrapper<DiscussqiuzhizhexinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
