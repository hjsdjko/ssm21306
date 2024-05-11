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


import com.dao.JinzhangxinxiDao;
import com.entity.JinzhangxinxiEntity;
import com.service.JinzhangxinxiService;
import com.entity.vo.JinzhangxinxiVO;
import com.entity.view.JinzhangxinxiView;

@Service("jinzhangxinxiService")
public class JinzhangxinxiServiceImpl extends ServiceImpl<JinzhangxinxiDao, JinzhangxinxiEntity> implements JinzhangxinxiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JinzhangxinxiEntity> page = this.selectPage(
                new Query<JinzhangxinxiEntity>(params).getPage(),
                new EntityWrapper<JinzhangxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JinzhangxinxiEntity> wrapper) {
		  Page<JinzhangxinxiView> page =new Query<JinzhangxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<JinzhangxinxiVO> selectListVO(Wrapper<JinzhangxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JinzhangxinxiVO selectVO(Wrapper<JinzhangxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JinzhangxinxiView> selectListView(Wrapper<JinzhangxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JinzhangxinxiView selectView(Wrapper<JinzhangxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
