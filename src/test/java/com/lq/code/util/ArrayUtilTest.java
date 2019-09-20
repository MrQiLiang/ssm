package com.lq.code.util;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author: qi
 * @Description:
 * @Date: Create in 10:44 PM 2019/9/19
 */
public class ArrayUtilTest {

    @Test
    public void of() {

        String [] strArray = ArrayUtil.of("hello","world","!");

        Integer[] intArray = ArrayUtil.of(1,2,2,3,4,5);

    }
}