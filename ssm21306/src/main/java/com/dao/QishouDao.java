package com.dao;

import com.entity.QishouEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.QishouVO;
import com.entity.view.QishouView;


/**
 * 骑手
 * 
 * @author 
 * @email 
 * @date 2021-04-26 16:59:08
 */
public interface QishouDao extends BaseMapper<QishouEntity> {
	
	List<QishouVO> selectListVO(@Param("ew") Wrapper<QishouEntity> wrapper);
	
	QishouVO selectVO(@Param("ew") Wrapper<QishouEntity> wrapper);
	
	List<QishouView> selectListView(@Param("ew") Wrapper<QishouEntity> wrapper);

	List<QishouView> selectListView(Pagination page,@Param("ew") Wrapper<QishouEntity> wrapper);
	
	QishouView selectView(@Param("ew") Wrapper<QishouEntity> wrapper);
	
}
