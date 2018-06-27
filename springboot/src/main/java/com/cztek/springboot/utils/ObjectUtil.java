package com.cztek.springboot.utils;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

public class ObjectUtil {
	public static <T> List<T> castEntity(List<Object[]> list, Class<T> clazz) throws Exception {
		List<T> returnList = new ArrayList<>();
		if (list.size() == 0) {
			return returnList;
		}
		Class[] c2 = null;
		Constructor[] constructors = clazz.getConstructors();
		for (Constructor constructor : constructors) {
			Class[] tClass = constructor.getParameterTypes();
			if (tClass.length == list.get(0).length) {
				c2 = tClass;
				break;
			}
		}
		// 构造方法实例化对象
		for (Object[] o : list) {
			Constructor<T> constructor = clazz.getConstructor(c2);
			returnList.add(constructor.newInstance(o));
		}

		return returnList;
	}
}
