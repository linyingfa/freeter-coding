package com.freeter.modules.order.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.Query;
import com.freeter.modules.apiUser.entity.UserEntity;
import com.freeter.modules.apiUser.service.UserService;
import com.freeter.modules.order.dao.OrderDao;
import com.freeter.modules.order.entity.OrderEntity;
import com.freeter.modules.order.entity.OrderGoodEntity;
import com.freeter.modules.order.service.OrderService;


@Service("orderService")
public class OrderServiceImpl extends ServiceImpl<OrderDao, OrderEntity> implements OrderService {
    @Autowired
    UserService userService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String selectType=(String)params.get("selectType");
        String selectValue=(String)params.get("selectValue");
        String orderStatus=(String)params.get("orderStatus");
        EntityWrapper<OrderEntity> orderEntityWrapper=new EntityWrapper<OrderEntity>();
        if(orderStatus==null || "100".equals(orderStatus)){
            if("userName".equals(selectType)){
                EntityWrapper<UserEntity> userEntityWrapper=new EntityWrapper<UserEntity>();
                UserEntity userEntity=userService.selectOne(userEntityWrapper.eq("user_name",selectValue));
                orderEntityWrapper=(EntityWrapper)orderEntityWrapper.like(StringUtils.isNotBlank(selectValue),"user_id",userEntity.getUserId().toString());
            }else if("tel".equals(selectType)){
                orderEntityWrapper=(EntityWrapper)orderEntityWrapper.like(StringUtils.isNotBlank(selectValue),"tel", selectValue);
            }else if("orderNo".equals(selectType)){

                orderEntityWrapper=(EntityWrapper)orderEntityWrapper.like(StringUtils.isNotBlank(selectValue),"order_no", selectValue);
            }

        }else{
            orderEntityWrapper= (EntityWrapper<OrderEntity>) orderEntityWrapper.eq("order_status",orderStatus);
            if("userName".equals(selectType)){
                EntityWrapper<UserEntity> userEntityWrapper=new EntityWrapper<UserEntity>();
                UserEntity userEntity=userService.selectOne(userEntityWrapper.eq("user_name",selectValue));
                orderEntityWrapper=(EntityWrapper)orderEntityWrapper.like(StringUtils.isNotBlank(selectValue),"user_id",userEntity.getUserId().toString());
            }else if("tel".equals(selectType)){
                orderEntityWrapper=(EntityWrapper)orderEntityWrapper.like(StringUtils.isNotBlank(selectValue),"tel", selectValue);
            }else if("orderNo".equals(selectType)){
                orderEntityWrapper=(EntityWrapper)orderEntityWrapper.like(StringUtils.isNotBlank(selectValue),"order_no", selectValue);
            }
        }
        Page<OrderEntity> page = this.selectPage(
                new Query<OrderEntity>(params).getPage(),orderEntityWrapper
        );
        return new PageUtils(page);
    }


}
