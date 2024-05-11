package com.dao;

import com.entity.QianbaoxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.QianbaoxinxiVO;
import com.entity.view.QianbaoxinxiView;


/**
 * 钱包信息
 * 
 * @author 
 * @email 
 * @date 2021-04-26 16:59:08
 */
public interface QianbaoxinxiDao extends BaseMapper<QianbaoxinxiEntity> {
	
	List<QianbaoxinxiVO> selectListVO(@Param("ew") Wrapper<QianbaoxinxiEntity> wrapper);
	
	QianbaoxinxiVO selectVO(@Param("ew") Wrapper<QianbaoxinxiEntity> wrapper);
	
	List<QianbaoxinxiView> selectListView(@Param("ew") Wrapper<QianbaoxinxiEntity> wrapper);

	List<QianbaoxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<QianbaoxinxiEntity> wrapper);
	
	QianbaoxinxiView selectView(@Param("ew") Wrapper<QianbaoxinxiEntity> wrapper);
	
}
