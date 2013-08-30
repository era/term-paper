package br.com.findplaces.commons.reflection;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClassUtils {
	
	@SuppressWarnings("rawtypes")
	public static List<Field> getAllFields(Class clazz) {
		List<Field> allFields = new ArrayList<Field>();
		allFields.addAll(Arrays.asList(clazz.getDeclaredFields()));
		Class superClass = clazz.getSuperclass();
		if (!superClass.equals(Object.class)) {
			allFields.addAll(getAllFields(superClass));
		}
		return allFields;
	}

}
