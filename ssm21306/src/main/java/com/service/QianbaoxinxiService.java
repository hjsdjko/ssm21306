package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.QianbaoxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.QianbaoxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.QianbaoxinxiView;


/**
 * 钱包信息
 *
 * @author 
 * @email 
 * @date 2021-04-26 16:59:08
 */
public interface QianbaoxinxiService extends IService<QianbaoxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<QianbaoxinxiVO> selectListVO(Wrapper<QianbaoxinxiEntity> wrapper);
   	
   	QianbaoxinxiVO selectVO(@Param("ew") Wrapper<QianbaoxinxiEntity> wrapper);
   	
   	List<QianbaoxinxiView> selectListView(Wrapper<QianbaoxinxiEntity> wrapper);
   	
   	QianbaoxinxiView selectView(@Param("ew") Wrapper<QianbaoxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<QianbaoxinxiEntity> wrapper);
   	
}

