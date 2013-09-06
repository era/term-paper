package br.com.findplaces.jpa.entity;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EmbeddedId;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import br.com.findplaces.commons.reflection.ClassUtils;
import br.com.findplaces.commons.reflection.PropertyUtils;

@MappedSuperclass
public abstract class BaseEntity implements Serializable {

	    private static final long serialVersionUID = 2206198812084135853L;
	    
	    private static Map<Class, Field> primaryKeyFields = new HashMap<Class, Field>();
	    
	    public Field getPrimaryKeyField(){
	    	if (!primaryKeyFields.containsKey(getClass())) {
	            synchronized (primaryKeyFields) {
	                for (Field field : ClassUtils.getAllFields(getClass())) {
	                    if ((field.getAnnotation(Id.class) != null) || (field.getAnnotation(EmbeddedId.class) != null)) {
	                        primaryKeyFields.put(getClass(), field);
	                        break;
	                    }
	                }
	            }
	        }
	        return primaryKeyFields.get(getClass());
	    }
	    
	    public Object getPrimaryKey(){
	    	Object object;
	    	try {
	    		object = PropertyUtils.getProperty(this, getPrimaryKeyField().getName());
			} catch (Exception e) {
				object = null;
			} 
	    	return object;
	    }

	    public String toString() {
	        try {
	            return this.getClass().getSimpleName() + ":" + getPrimaryKeyField().getName() + "=" + getPrimaryKey();
	        } catch (Exception ex) {
	            return super.toString();
	        }
	    }
	    
	    public String getEntityName() {
	        String className = this.getClass().getSimpleName();
	        return className.substring(0, className.length() - 2);
	    }

}
