package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JinzhangxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JinzhangxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JinzhangxinxiView;


/**
 * 进账信息
 *
 * @author 
 * @email 
 * @date 2021-04-26 16:59:08
 */
public interface JinzhangxinxiService extends IService<JinzhangxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JinzhangxinxiVO> selectListVO(Wrapper<JinzhangxinxiEntity> wrapper);
   	
   	JinzhangxinxiVO selectVO(@Param("ew") Wrapper<JinzhangxinxiEntity> wrapper);
   	
   	List<JinzhangxinxiView> selectListView(Wrapper<JinzhangxinxiEntity> wrapper);
   	
   	JinzhangxinxiView selectView(@Param("ew") Wrapper<JinzhangxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JinzhangxinxiEntity> wrapper);
   	
}

