package br.com.findplaces.commons.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class PropertyUtils {
	
	private PropertyUtils(){}
	
	public static Field getField(Class<?> klass, String fieldName) throws NoSuchFieldException, SecurityException{
		Field field;
		field = klass.getDeclaredField(fieldName);
		return field;
	}
	
	 public static Object getProperty(Object bean, String name) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
            return org.apache.commons.beanutils.PropertyUtils.getProperty(bean, name);
	    }

}
