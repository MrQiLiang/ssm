package com.lq.code.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.lq.code.util.BeanUtil;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by qi on 2017/7/16.
 */
public class IdEntity implements Serializable {

    /**
     *  数据id
     */
    @TableId(type = IdType.AUTO)
    protected Long id;
    /**
     * 数据状态（与业务逻辑无关）
     */
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
        List<Field> fieldList = BeanUtil.getAllField(clazz);
        fieldList.forEach((field)->{
            field.setAccessible(true);
            Object val=null;
            try {
                val=field.get(this);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            stringBuffer.append(field.getName()+":"+val+"\n");

        });
        return stringBuffer.toString();
    }
}
