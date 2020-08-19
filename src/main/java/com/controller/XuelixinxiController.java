package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.XuelixinxiEntity;
import com.entity.view.XuelixinxiView;

import com.service.XuelixinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 学历信息
 * 后端接口
 * @author 
 * @email 
 * @date 2020-05-13 10:02:23
 */
@RestController
@RequestMapping("/xuelixinxi")
public class XuelixinxiController {
    @Autowired
    private XuelixinxiService xuelixinxiService;
    

    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XuelixinxiEntity xuelixinxi, HttpServletRequest request){
        EntityWrapper<XuelixinxiEntity> ew = new EntityWrapper<XuelixinxiEntity>();
		PageUtils page = xuelixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xuelixinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XuelixinxiEntity xuelixinxi, HttpServletRequest request){
        EntityWrapper<XuelixinxiEntity> ew = new EntityWrapper<XuelixinxiEntity>();
		PageUtils page = xuelixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xuelixinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XuelixinxiEntity xuelixinxi){
       	EntityWrapper<XuelixinxiEntity> ew = new EntityWrapper<XuelixinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xuelixinxi, "xuelixinxi")); 
        return R.ok().put("data", xuelixinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XuelixinxiEntity xuelixinxi){
        EntityWrapper< XuelixinxiEntity> ew = new EntityWrapper< XuelixinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xuelixinxi, "xuelixinxi")); 
		XuelixinxiView xuelixinxiView =  xuelixinxiService.selectView(ew);
		return R.ok("查询学历信息成功").put("data", xuelixinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") String id){
        XuelixinxiEntity xuelixinxi = xuelixinxiService.selectById(id);
        return R.ok().put("data", xuelixinxi);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") String id){
        XuelixinxiEntity xuelixinxi = xuelixinxiService.selectById(id);
        return R.ok().put("data", xuelixinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XuelixinxiEntity xuelixinxi, HttpServletRequest request){
    	xuelixinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xuelixinxi);
        xuelixinxiService.insert(xuelixinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XuelixinxiEntity xuelixinxi, HttpServletRequest request){
    	xuelixinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xuelixinxi);
        xuelixinxiService.insert(xuelixinxi);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody XuelixinxiEntity xuelixinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xuelixinxi);
        xuelixinxiService.updateById(xuelixinxi);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xuelixinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<XuelixinxiEntity> wrapper = new EntityWrapper<XuelixinxiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = xuelixinxiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	

}
