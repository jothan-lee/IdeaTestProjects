/**
 * Aistarfish.com Inc.
 * Copyright (c) 2017-2021 All Rights Reserved.
 */
package
		com.jothan.test.fieldname.util;

import java.lang.reflect.Field;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author LanAn_Lee
 * Created by on 2021-06-06 20:36
 */
public class ObjectFieldutil {
	/**
	 * 此处是根据属性名来给属性名赋值的方法
	 *
	 * @param key    属性名
	 * @param value  属性名的值
	 * @param object 属性的实体类
	 */
	public static void setValues(String key, String value, Object object) {
		Object returnStr = null;
		try {
			Field[] fields = object.getClass().getDeclaredFields();
			for (Field field : fields) {
				field.setAccessible(true);
				returnStr = field.get(object);
				if (field.getAnnotation(JsonProperty.class) != null) {
					JsonProperty annotation = ((JsonProperty) field.getAnnotation(JsonProperty.class));
					if (annotation != null) {
						System.out.println(annotation + "");
						String jsonPropertyValue = annotation.value();
						if (key.equals(jsonPropertyValue)) {
							field.set(object, value);
							break;
						}
					}
				} else {
					String fieldName = field.getName();
					if (key.equals(fieldName)) {
						field.set(object, value);
						break;
					}
				}
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据属性名得到属性名的值的方法
	 *
	 * @param key    属性名
	 * @param object 对象
	 */
	public static Object getValues(String key, Object object) throws IllegalAccessException {
		//  Object returnStr = null;
		//try {
		java.lang.reflect.Field[] fields = object.getClass().getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			if (field.getAnnotation(JsonProperty.class) != null) {
				JsonProperty annotation = ((JsonProperty) field.getAnnotation(JsonProperty.class));
				if (annotation != null) {
					String jsonPropertyValue = annotation.value();
					if (key.equals(jsonPropertyValue)) {
						Object values = field.get(object);
						return values;
					}
				}
			} else {
				//获取的不是@jsonproperty的属性名称
				String fieldName = field.getName();
				if (key.equals(fieldName)) {
					Object values = field.get(object);
					return values;
				}
			}
		}
		return null;
	}
}
