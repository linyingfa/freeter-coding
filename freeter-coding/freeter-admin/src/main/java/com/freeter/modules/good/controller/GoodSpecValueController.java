package com.freeter.modules.good.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.R;
import com.freeter.common.utils.SpecUtil;
import com.freeter.common.validator.ValidatorUtils;
import com.freeter.modules.good.entity.GoodSpecPriceEntity;
import com.freeter.modules.good.entity.GoodSpecValueEntity;
import com.freeter.modules.good.service.GoodSpecPriceService;
import com.freeter.modules.good.service.GoodSpecValueService;

/**
 * 商品规格值表
 *
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-06-02 15:23:17
 */
@RestController
@RequestMapping("good/goodspecvalue")
public class GoodSpecValueController {
	@Autowired
	private GoodSpecValueService goodSpecValueService;

	@Autowired
	private GoodSpecPriceService goodSpecPriceService;

	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("good:goodspecvalue:list")
	public R list(@RequestParam Map<String, Object> params) {
		PageUtils page = goodSpecValueService.queryPage(params);

		return R.ok().put("page", page);
	}

	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("good:goodspecvalue:info")
	public R info(@PathVariable("id") Integer id) {
		GoodSpecValueEntity goodSpecValue = goodSpecValueService.selectById(id);

		return R.ok().put("goodSpecValue", goodSpecValue);
	}

	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("good:goodspecvalue:save")
	public R save(@RequestBody GoodSpecValueEntity goodSpecValue) {
		ValidatorUtils.validateEntity(goodSpecValue);
		goodSpecValueService.insert(goodSpecValue);

		return R.ok();
	}

	/**
	 * 保存
	 */
	@RequestMapping("/saveGoodSpecValue")
	// @RequiresPermissions("good:goodspecvalue:save")
	public R saveGoodSpecValue(@RequestBody List<GoodSpecValueEntity> goodSpecValueList) {
		
		
		
		goodSpecValueService.insertBatch(goodSpecValueList);

		List<List<GoodSpecValueEntity>> listType = SpecUtil.getTypeGoodSpecValueList(goodSpecValueList);

		List<GoodSpecPriceEntity> listGoodSpecPrice = SpecUtil.getGoodSpecPriceList(listType);

		goodSpecPriceService.insertBatch(listGoodSpecPrice);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@RequestMapping("/deleteSpec")
	@RequiresPermissions("good:good:delete")
	public R deleteSpec(Integer goodId) {
		Map columnMap = new HashMap();
		columnMap.put("good_id", goodId);
		goodSpecValueService.deleteByMap(columnMap);
		goodSpecPriceService.deleteByMap(columnMap);
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("good:goodspecvalue:update")
	public R update(@RequestBody GoodSpecValueEntity goodSpecValue) {
		ValidatorUtils.validateEntity(goodSpecValue);
		goodSpecValueService.updateAllColumnById(goodSpecValue);// 全部更新

		return R.ok();
	}

	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("good:goodspecvalue:delete")
	public R delete(@RequestBody Integer[] ids) {
		goodSpecValueService.deleteBatchIds(Arrays.asList(ids));
		return R.ok();
	}

}
