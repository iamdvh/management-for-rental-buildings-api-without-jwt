package com.iamdvh.utils;

import java.util.Map;

public class MapUtils {
	public static <T> T getObject(Map<String, Object> maps, String key, Class<T> tClass) {
		try {
			if (tClass.getTypeName().equals("java.lang.String")) {
				return maps.containsKey(key) ? (maps.get(key) != null ? tClass.cast(maps.get(key)) : null) : null;
			}
			return maps.containsKey(key) ? (maps.get(key).toString() != "" ? tClass.cast(maps.get(key)) : null) : null;
		} catch (Exception e) {
			return null;
		}
	}

}
