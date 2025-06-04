package com.iamdvh.utils;

public class CheckUtil {
	public static Boolean isNullOrEmpty(String value) {
		return value == null || value == "";
	}
	public static Boolean isNull(Integer value) {
		return value == null;
	}
	public static Boolean isNull(Long value) {
		return value == null;
	}
}
