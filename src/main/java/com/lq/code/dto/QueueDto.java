package com.lq.code.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: qi
 * @Description:自定义队列
 * @Date: Create in 9:23 AM 2019/6/3
 */
public class QueueDto<T> {

    /**
     * 队列内部数组
     */
    private List<T> list;
    /**
     * 队列索引　
     */
    private AtomicInteger index = new AtomicInteger(0);


    public QueueDto() {

        this.list = new ArrayList<>();

    }

    public QueueDto(int size) {
        this.list = new ArrayList<>(size);
    }

    public void add(T t){
        list.add(t);
        index.getAndIncrement();

    }

    public  T pop(){
        T t = null;
        if (hasNext()) {
            index.getAndAdd(-1);
            t = list.get(index.get());
        }
        return t;
    }

    /**
     *  判断是否还有元素存在
     * @return
     */
    public boolean hasNext(){
        boolean result = true;
        int nowIndex = index.get();
        if (nowIndex == 0){
            result = false;
        }
        return result;
    }

    public int getIndex(){

        return this.index.get();
    }

}
