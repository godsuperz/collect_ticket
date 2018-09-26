package com.super223.utils;

/**
 * 字符串工具类
 * @author superz
 */
public class StringUtil {
    /**
     *判断一个字符是否是中文
     */
    public static boolean isChinese(char c) {
        // 根据字节码判断
        return c >= 0x4E00 &&  c <= 0x9FA5;
    }

    /**
     *判断一个字符串是否含有中文
     */
    public static boolean isChinese(String str) {
        if (str == null) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (isChinese(c)) {
                // 有一个中文字符就返回
                return true;
            }
        }
        return false;
    }
}
