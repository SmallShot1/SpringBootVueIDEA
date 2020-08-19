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


import com.dao.XuelixinxiDao;
import com.entity.XuelixinxiEntity;
import com.service.XuelixinxiService;
import com.entity.vo.XuelixinxiVO;
import com.entity.view.XuelixinxiView;

@Service("xuelixinxiService")
public class XuelixinxiServiceImpl extends ServiceImpl<XuelixinxiDao, XuelixinxiEntity> implements XuelixinxiService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XuelixinxiEntity> page = this.selectPage(
                new Query<XuelixinxiEntity>(params).getPage(),
                new EntityWrapper<XuelixinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XuelixinxiEntity> wrapper) {
		  Page<XuelixinxiView> page =new Query<XuelixinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<XuelixinxiVO> selectListVO(Wrapper<XuelixinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public XuelixinxiVO selectVO(Wrapper<XuelixinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<XuelixinxiView> selectListView(Wrapper<XuelixinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XuelixinxiView selectView(Wrapper<XuelixinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
