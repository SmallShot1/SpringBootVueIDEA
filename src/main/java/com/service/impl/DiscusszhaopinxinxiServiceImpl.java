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


import com.dao.DiscusszhaopinxinxiDao;
import com.entity.DiscusszhaopinxinxiEntity;
import com.service.DiscusszhaopinxinxiService;
import com.entity.vo.DiscusszhaopinxinxiVO;
import com.entity.view.DiscusszhaopinxinxiView;

@Service("discusszhaopinxinxiService")
public class DiscusszhaopinxinxiServiceImpl extends ServiceImpl<DiscusszhaopinxinxiDao, DiscusszhaopinxinxiEntity> implements DiscusszhaopinxinxiService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusszhaopinxinxiEntity> page = this.selectPage(
                new Query<DiscusszhaopinxinxiEntity>(params).getPage(),
                new EntityWrapper<DiscusszhaopinxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusszhaopinxinxiEntity> wrapper) {
		  Page<DiscusszhaopinxinxiView> page =new Query<DiscusszhaopinxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscusszhaopinxinxiVO> selectListVO(Wrapper<DiscusszhaopinxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusszhaopinxinxiVO selectVO(Wrapper<DiscusszhaopinxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusszhaopinxinxiView> selectListView(Wrapper<DiscusszhaopinxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusszhaopinxinxiView selectView(Wrapper<DiscusszhaopinxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
