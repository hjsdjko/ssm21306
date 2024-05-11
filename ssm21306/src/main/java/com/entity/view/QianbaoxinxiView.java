package com.entity.view;

import com.entity.QianbaoxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 钱包信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-04-26 16:59:08
 */
@TableName("qianbaoxinxi")
public class QianbaoxinxiView  extends QianbaoxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public QianbaoxinxiView(){
	}
 
 	public QianbaoxinxiView(QianbaoxinxiEntity qianbaoxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, qianbaoxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
