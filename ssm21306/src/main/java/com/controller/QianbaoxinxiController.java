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
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.QianbaoxinxiEntity;
import com.entity.view.QianbaoxinxiView;

import com.service.QianbaoxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 钱包信息
 * 后端接口
 * @author 
 * @email 
 * @date 2021-04-26 16:59:08
 */
@RestController
@RequestMapping("/qianbaoxinxi")
public class QianbaoxinxiController {
    @Autowired
    private QianbaoxinxiService qianbaoxinxiService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,QianbaoxinxiEntity qianbaoxinxi, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("qishou")) {
			qianbaoxinxi.setGonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<QianbaoxinxiEntity> ew = new EntityWrapper<QianbaoxinxiEntity>();
		PageUtils page = qianbaoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, qianbaoxinxi), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,QianbaoxinxiEntity qianbaoxinxi, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("qishou")) {
			qianbaoxinxi.setGonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<QianbaoxinxiEntity> ew = new EntityWrapper<QianbaoxinxiEntity>();
		PageUtils page = qianbaoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, qianbaoxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( QianbaoxinxiEntity qianbaoxinxi){
       	EntityWrapper<QianbaoxinxiEntity> ew = new EntityWrapper<QianbaoxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( qianbaoxinxi, "qianbaoxinxi")); 
        return R.ok().put("data", qianbaoxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(QianbaoxinxiEntity qianbaoxinxi){
        EntityWrapper< QianbaoxinxiEntity> ew = new EntityWrapper< QianbaoxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( qianbaoxinxi, "qianbaoxinxi")); 
		QianbaoxinxiView qianbaoxinxiView =  qianbaoxinxiService.selectView(ew);
		return R.ok("查询钱包信息成功").put("data", qianbaoxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        QianbaoxinxiEntity qianbaoxinxi = qianbaoxinxiService.selectById(id);
        return R.ok().put("data", qianbaoxinxi);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        QianbaoxinxiEntity qianbaoxinxi = qianbaoxinxiService.selectById(id);
        return R.ok().put("data", qianbaoxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody QianbaoxinxiEntity qianbaoxinxi, HttpServletRequest request){
    	qianbaoxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(qianbaoxinxi);

        qianbaoxinxiService.insert(qianbaoxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody QianbaoxinxiEntity qianbaoxinxi, HttpServletRequest request){
    	qianbaoxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(qianbaoxinxi);
    	qianbaoxinxi.setUserid((Long)request.getSession().getAttribute("userId"));

        qianbaoxinxiService.insert(qianbaoxinxi);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody QianbaoxinxiEntity qianbaoxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(qianbaoxinxi);
        qianbaoxinxiService.updateById(qianbaoxinxi);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        qianbaoxinxiService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<QianbaoxinxiEntity> wrapper = new EntityWrapper<QianbaoxinxiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("qishou")) {
			wrapper.eq("gonghao", (String)request.getSession().getAttribute("username"));
		}

		int count = qianbaoxinxiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
