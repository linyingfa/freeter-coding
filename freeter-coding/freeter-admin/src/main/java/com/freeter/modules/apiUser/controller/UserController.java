package com.freeter.modules.apiUser.controller;

import java.util.Arrays;
import java.util.Map;

import com.freeter.common.validator.ValidatorUtils;
import com.freeter.modules.apiUser.entity.UserEntity;
import com.freeter.modules.apiUser.entity.view.UserSearch;
import com.freeter.modules.apiUser.entity.view.UserView;
import com.freeter.modules.apiUser.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;




/**
 * 用户表
 *
 * @author liuqi
 * @email 363236211@qq.com
 * @date 2018-06-07 13:18:33
 */
@RestController
@RequestMapping("user")
@Api(tags="用户表接口")
public class UserController {
    @Autowired
    private UserService userService;
 
	
    /**
     * 查询
     */
    @GetMapping("/search")
    @ApiOperation("查询用户表")
    public R search(UserSearch userSearch){
		ValidatorUtils.validateEntity(userSearch);
        EntityWrapper< UserEntity> ew = new EntityWrapper< UserEntity>();
		UserEntity user = new  UserEntity( userSearch);
		ew.setEntity(user);
		userService.selectList(ew);
		return R.ok("查询用户表成功").put("data",userService.selectList(ew));
    }

	

    /**
     * 信息
     */
    @GetMapping("/info/{userId}")
    @ApiOperation("获取相应的用户表")
    public R info(@PathVariable("userId") Long userId){
        UserEntity user = userService.selectById(userId);

        return R.ok().put("user", user);
    }

    /**
     * 保存
     */
    @PostMapping("/save/json")
    @ApiOperation("添加用户表数据")
    public R saveJson(@RequestBody UserEntity user){
    	ValidatorUtils.validateEntity(user);
        userService.insert(user);
        return R.ok();
    }
    
    /**
     * 保存
     */
    @PostMapping("/save/form")
    @ApiOperation("添加用户表数据 （参数：表单格式）")
    public R saveForm(UserEntity user){
    	ValidatorUtils.validateEntity(user);
        userService.insert(user);

        return R.ok();
    }

    /**
     * 修改（参数：json）
     */
    @PostMapping("/update/json")
    @ApiOperation("修改用户表数据（参数：json格式）")
    public R updateJson(@RequestBody UserEntity user){
        ValidatorUtils.validateEntity(user);
        userService.updateAllColumnById(user);//全部更新
        
        return R.ok();
    }


    /**
     * 修改（参数：传统表单）
     */
    @PostMapping("/update/form")
    @ApiOperation("修改用户表数据（参数：表单格式）")
    public R updateForm(UserEntity user){
        ValidatorUtils.validateEntity(user);
        userService.updateAllColumnById(user);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @ApiOperation("删除用户表数据")
    public R delete(@RequestBody Long[] userIds){
        userService.deleteBatchIds(Arrays.asList(userIds));
        return R.ok();
    }

}
