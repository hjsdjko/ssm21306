package com.dao;

import com.entity.JinzhangxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JinzhangxinxiVO;
import com.entity.view.JinzhangxinxiView;


/**
 * 进账信息
 * 
 * @author 
 * @email 
 * @date 2021-04-26 16:59:08
 */
public interface JinzhangxinxiDao extends BaseMapper<JinzhangxinxiEntity> {
	
	List<JinzhangxinxiVO> selectListVO(@Param("ew") Wrapper<JinzhangxinxiEntity> wrapper);
	
	JinzhangxinxiVO selectVO(@Param("ew") Wrapper<JinzhangxinxiEntity> wrapper);
	
	List<JinzhangxinxiView> selectListView(@Param("ew") Wrapper<JinzhangxinxiEntity> wrapper);

	List<JinzhangxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<JinzhangxinxiEntity> wrapper);
	
	JinzhangxinxiView selectView(@Param("ew") Wrapper<JinzhangxinxiEntity> wrapper);
	
}
