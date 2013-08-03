package br.com.findeplaces.jpa.entity;

import java.io.Serializable;
import java.lang.reflect.Field;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity implements Serializable {

	    private static final long serialVersionUID = 2206198812084135853L;
	    
	    public abstract Field getPrimaryKeyField();
	    
	    public abstract Object getPrimaryKey();

	    public String toString() {
	        try {
	            return this.getClass().getSimpleName() + ":" + getPrimaryKeyField().getName() + "=" + getPrimaryKey();
	        } catch (Exception ex) {
	            return super.toString();
	        }
	    }
	    
	    public abstract Object getId();

	    public String getEntityName() {
	        String className = this.getClass().getSimpleName();
	        return className.substring(0, className.length() - 2);
	    }

}
