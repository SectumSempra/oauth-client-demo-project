package com.be.demo.common.cahce;

import java.util.Arrays;

public class CacheKeyGenerator {

	/**
	 * Append the method name , param to an array and create a deepHashCode of the
	 * array as redis cache key
	 * 
	 * @param methodName
	 * @param params
	 * @return
	 */
	public static String generateKey(String methodName, Object... params) {
		if (params.length == 0) {
			return new Integer(methodName.hashCode()).toString();
		}
		Object[] paramList = new Object[params.length + 1];
		paramList[0] = methodName;
		System.arraycopy(params, 0, paramList, 1, params.length);
		int hashCode = Arrays.deepHashCode(paramList);
		return new Integer(hashCode).toString();
	}

	public static String generateKeyV2(String simpleNameClass, String methodName) {
		return getKey(simpleNameClass, methodName);
	}

	private static String getKey(String simpleNameClass, String methodName) {
		final String KEY_SEPERATOR = "#";

		StringBuilder sb = new StringBuilder();
		sb.append(simpleNameClass);
		sb.append(KEY_SEPERATOR);
		sb.append(methodName);
		sb.append(KEY_SEPERATOR);
		String str = sb.toString();
		String key = str.substring(0, str.length() - 1);
		return key;
	}

}
