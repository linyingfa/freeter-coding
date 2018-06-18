package com.freeter.modules.good.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.freeter.modules.good.entity.CategoryEntity;
import com.freeter.modules.good.entity.view.CategoryView;
import com.freeter.modules.good.entity.vo.CategoryVO;

/**
 * 分类表
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-05-28 17:34:00
 */
public interface CategoryDao extends BaseMapper<CategoryEntity> {

	List<CategoryVO> selectListVO(@Param("ew") Wrapper<CategoryEntity> wrapper);

	CategoryVO selectVO(@Param("ew") Wrapper<CategoryEntity> wrapper);

	List<CategoryView> selectListView(@Param("ew") Wrapper<CategoryEntity> wrapper);

	CategoryView selectView(@Param("ew") Wrapper<CategoryEntity> wrapper);
}
