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


import com.dao.QiuzhizhexinxiDao;
import com.entity.QiuzhizhexinxiEntity;
import com.service.QiuzhizhexinxiService;
import com.entity.vo.QiuzhizhexinxiVO;
import com.entity.view.QiuzhizhexinxiView;

@Service("qiuzhizhexinxiService")
public class QiuzhizhexinxiServiceImpl extends ServiceImpl<QiuzhizhexinxiDao, QiuzhizhexinxiEntity> implements QiuzhizhexinxiService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QiuzhizhexinxiEntity> page = this.selectPage(
                new Query<QiuzhizhexinxiEntity>(params).getPage(),
                new EntityWrapper<QiuzhizhexinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<QiuzhizhexinxiEntity> wrapper) {
		  Page<QiuzhizhexinxiView> page =new Query<QiuzhizhexinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<QiuzhizhexinxiVO> selectListVO(Wrapper<QiuzhizhexinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public QiuzhizhexinxiVO selectVO(Wrapper<QiuzhizhexinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<QiuzhizhexinxiView> selectListView(Wrapper<QiuzhizhexinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public QiuzhizhexinxiView selectView(Wrapper<QiuzhizhexinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
