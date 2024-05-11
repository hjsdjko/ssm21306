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

import com.entity.QishouEntity;
import com.entity.view.QishouView;

import com.service.QishouService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 骑手
 * 后端接口
 * @author 
 * @email 
 * @date 2021-04-26 16:59:08
 */
@RestController
@RequestMapping("/qishou")
public class QishouController {
    @Autowired
    private QishouService qishouService;
    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		QishouEntity user = qishouService.selectOne(new EntityWrapper<QishouEntity>().eq("gonghao", username));
		if(user==null || !user.getMima().equals(password)) {
			return R.error("账号或密码不正确");
		}
		String token = tokenService.generateToken(user.getId(), username,"qishou",  "骑手" );
		return R.ok().put("token", token);
	}
	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody QishouEntity qishou){
    	//ValidatorUtils.validateEntity(qishou);
    	QishouEntity user = qishouService.selectOne(new EntityWrapper<QishouEntity>().eq("gonghao", qishou.getGonghao()));
		if(user!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		qishou.setId(uId);
        qishouService.insert(qishou);
        return R.ok();
    }
	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        QishouEntity user = qishouService.selectById(id);
        return R.ok().put("data", user);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	QishouEntity user = qishouService.selectOne(new EntityWrapper<QishouEntity>().eq("gonghao", username));
    	if(user==null) {
    		return R.error("账号不存在");
    	}
    	user.setMima("123456");
        qishouService.updateById(user);
        return R.ok("密码已重置为：123456");
    }


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,QishouEntity qishou, 
		HttpServletRequest request){

        EntityWrapper<QishouEntity> ew = new EntityWrapper<QishouEntity>();
		PageUtils page = qishouService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, qishou), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,QishouEntity qishou, 
		HttpServletRequest request){
        EntityWrapper<QishouEntity> ew = new EntityWrapper<QishouEntity>();
		PageUtils page = qishouService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, qishou), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( QishouEntity qishou){
       	EntityWrapper<QishouEntity> ew = new EntityWrapper<QishouEntity>();
      	ew.allEq(MPUtil.allEQMapPre( qishou, "qishou")); 
        return R.ok().put("data", qishouService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(QishouEntity qishou){
        EntityWrapper< QishouEntity> ew = new EntityWrapper< QishouEntity>();
 		ew.allEq(MPUtil.allEQMapPre( qishou, "qishou")); 
		QishouView qishouView =  qishouService.selectView(ew);
		return R.ok("查询骑手成功").put("data", qishouView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        QishouEntity qishou = qishouService.selectById(id);
        return R.ok().put("data", qishou);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        QishouEntity qishou = qishouService.selectById(id);
        return R.ok().put("data", qishou);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody QishouEntity qishou, HttpServletRequest request){
    	qishou.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(qishou);
    	QishouEntity user = qishouService.selectOne(new EntityWrapper<QishouEntity>().eq("gonghao", qishou.getGonghao()));
		if(user!=null) {
			return R.error("用户已存在");
		}

		qishou.setId(new Date().getTime());
        qishouService.insert(qishou);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody QishouEntity qishou, HttpServletRequest request){
    	qishou.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(qishou);
    	QishouEntity user = qishouService.selectOne(new EntityWrapper<QishouEntity>().eq("gonghao", qishou.getGonghao()));
		if(user!=null) {
			return R.error("用户已存在");
		}

		qishou.setId(new Date().getTime());
        qishouService.insert(qishou);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody QishouEntity qishou, HttpServletRequest request){
        //ValidatorUtils.validateEntity(qishou);
        qishouService.updateById(qishou);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        qishouService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<QishouEntity> wrapper = new EntityWrapper<QishouEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = qishouService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
