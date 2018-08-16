package com.freeter.common.mpextend.parser;

import java.util.Map;
import java.util.Set;


import cn.hutool.core.bean.BeanUtil;

public class FilterMap  {

	public static <T> void filterMap(T t, Map<String, Object> map) {
		Map<String, Object> testMap = BeanUtil.beanToMap(t, true, true);
		Set<String> set = testMap.keySet();
		for (String key : set) {
			if (map.containsKey(key)) {
				map.remove(key);
			}
		}
	}

}
