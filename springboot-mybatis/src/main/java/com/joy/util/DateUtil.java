package com.joy.util;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class DateUtil {

    /**
     * 返回yyyyMMddHHmmssSS的格式字符串
     */
    public static String getNowTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSS");
        return LocalDateTime.now(ZoneOffset.of("+8")).format(formatter);
    }

    /**
     * 返回指定长度的随机数，在前面补0
     */
    public static String getRandomNum(int strLength) {
        Random rm = new Random();
        // 获得随机数
        double pross = (1 + rm.nextDouble()) * Math.pow(10, strLength);
        // 将获得的获得随机数转化为字符串
        String fixLengthString = String.valueOf(pross);
        // 返回固定的长度的随机数
        return fixLengthString.substring(1, strLength + 1);
    }
}
