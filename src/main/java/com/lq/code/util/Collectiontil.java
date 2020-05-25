package com.lq.code.util;

import org.apache.commons.collections.CollectionUtils;

import java.util.Collection;

/**
 * 集合工具类
 * @author qi
 */
public class Collectiontil {

    /**
     *  判断 collection 是否为null
     * @param collection
     * @return
     */
    public static boolean isEmpty(Collection<?> collection){

        return CollectionUtils.isEmpty(collection);
    }

    /**
     *  判断 集合是否不为 null
     * @param collection
     * @return
     */
    public static boolean isNotEmpty(Collection<?> collection){

        return CollectionUtils.isNotEmpty(collection);
    }
}
