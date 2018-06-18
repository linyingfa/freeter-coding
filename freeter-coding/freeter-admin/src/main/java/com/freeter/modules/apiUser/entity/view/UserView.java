package com.freeter.modules.apiUser.entity.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotations.TableName;
import com.freeter.modules.apiUser.entity.UserEntity;

import org.springframework.beans.BeanUtils;

import java.io.Serializable;
 

/**
 * 用户表
 * 
 * @author liuqi
 * @email 363236211@qq.com
 * @date 2018-06-07 13:18:33
 */
@TableName("cn_user")
@ApiModel(value = "User")
public class UserView  extends UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public UserView(){
	}
 
 	public UserView(UserEntity userEntity){
 	
 		BeanUtils.copyProperties(this, userEntity);
	}
}
