package com.entity.view;

import com.entity.JinzhangxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 进账信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-04-26 16:59:08
 */
@TableName("jinzhangxinxi")
public class JinzhangxinxiView  extends JinzhangxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public JinzhangxinxiView(){
	}
 
 	public JinzhangxinxiView(JinzhangxinxiEntity jinzhangxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, jinzhangxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
