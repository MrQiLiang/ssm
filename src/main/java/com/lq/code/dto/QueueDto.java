package com.lq.code.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: qi
 * @Description:自定义队列
 * @Date: Create in 9:23 AM 2019/6/3
 */
public class QueueDto<T> {

    private List<T> list;

    private int index;


    public QueueDto() {
        this.list = new ArrayList<>();
    }

    public QueueDto(int size) {
        this.list = new ArrayList<>(size);
    }

    public void add(T t){
        list.add(t);
        index ++;
    }

    public synchronized T pop(){
        T t = null;
        if (hasNext()) {
            index--;
            t = list.get(index);
        }
        return t;
    }

    /**
     *  判断是否还有元素存在
     * @return
     */
    public synchronized boolean hasNext(){
        boolean result = true;
        if (index==0){
            result = false;
        }
        return result;
    }

    public int getIndex(){

        return this.index;
    }

}
