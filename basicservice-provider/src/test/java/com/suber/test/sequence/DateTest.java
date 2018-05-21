package com.suber.test.sequence;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Date;

public class DateTest {

    public static void main(String[] args) {
        Date date = new Date(Long.MAX_VALUE);
        System.out.println(System.currentTimeMillis());
        System.out.println(DateFormatUtils.format(date,"yyyy-MM:dd:hh:mm:ss:SSS"));
        System.out.println(DateFormatUtils.format(new Date(),"yyyy-MM:dd:hh:mm:ss:SSS"));
        System.out.println(DateFormatUtils.format(new Date(9999999999999L),"yyyy-MM:dd:hh:mm:ss:SSS"));
        System.out.println(DateFormatUtils.format(new Date(999999999999L),"yyyy-MM:dd:hh:mm:ss:SSS"));
        System.out.println(DateFormatUtils.format(new Date(100000000000L),"yyyy-MM:dd:hh:mm:ss:SSS"));
    }
}
