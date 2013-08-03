package br.com.findeplaces.jpa.entity;

import java.io.Serializable;
import java.lang.reflect.Field;

import javax.persistence.MappedSuperclass;

import br.com.findplaces.commons.reflection.PropertyUtils;

@MappedSuperclass
public abstract class BaseEntity implements Serializable {

	    private static final long serialVersionUID = 2206198812084135853L;
	    
	    public Field getPrimaryKeyField(){
	    	try {
				return PropertyUtils.getField(this.getClass(), getPrimaryKeyField().getName());
			} catch (Exception e) {
				return null;
			}
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
