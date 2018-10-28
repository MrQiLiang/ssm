package com.lq.code.entity;

import java.io.Serializable;
import java.lang.reflect.Field;

/**
 * Created by qi on 2017/7/16.
 */
public class IdEntity implements Serializable {

    //数据id
    protected Long id;
    //数据状态（与业务逻辑无关）
    protected Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer=new StringBuffer();
        Class clazz=this.getClass();
        Field[] fields=clazz.getDeclaredFields();
        stringBuffer.append("id:"+this.getId()+"\n");
        for (Field field:fields){
            field.setAccessible(true);
            Object val=null;
            try {
                val=field.get(this);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            stringBuffer.append(field.getName()+":"+val+"\n");
        }
        return stringBuffer.toString();
    }
}
