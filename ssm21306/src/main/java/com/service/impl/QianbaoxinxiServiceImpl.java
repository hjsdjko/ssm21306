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


import com.dao.QianbaoxinxiDao;
import com.entity.QianbaoxinxiEntity;
import com.service.QianbaoxinxiService;
import com.entity.vo.QianbaoxinxiVO;
import com.entity.view.QianbaoxinxiView;

@Service("qianbaoxinxiService")
public class QianbaoxinxiServiceImpl extends ServiceImpl<QianbaoxinxiDao, QianbaoxinxiEntity> implements QianbaoxinxiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QianbaoxinxiEntity> page = this.selectPage(
                new Query<QianbaoxinxiEntity>(params).getPage(),
                new EntityWrapper<QianbaoxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<QianbaoxinxiEntity> wrapper) {
		  Page<QianbaoxinxiView> page =new Query<QianbaoxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<QianbaoxinxiVO> selectListVO(Wrapper<QianbaoxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public QianbaoxinxiVO selectVO(Wrapper<QianbaoxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<QianbaoxinxiView> selectListView(Wrapper<QianbaoxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public QianbaoxinxiView selectView(Wrapper<QianbaoxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
