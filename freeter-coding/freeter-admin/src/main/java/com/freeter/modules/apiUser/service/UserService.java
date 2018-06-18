package com.freeter.modules.apiUser.service;

import com.baomidou.mybatisplus.service.IService;
import com.freeter.common.utils.PageUtils;
import com.freeter.modules.apiUser.entity.UserEntity;

import java.util.Map;

/**
 * 用户表
 *
 * @author liuqi
 * @email 363236211@qq.com
 * @date 2018-06-07 13:18:33
 */
public interface UserService extends IService<UserEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

