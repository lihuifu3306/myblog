package com.crazy.core.util;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author shkstart
 * @create 2019-04-03 10:36
 */
public class StringHelper {


    public static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public static boolean isNumber(Object str) {
        try {
            Integer.parseInt((String) str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static Pattern pattern = Pattern.compile("_[a-z]");

    /**
     * 生成随机长度的
     *
     * @param length
     * @return
     */
    public static String random(int length) {
        return new RandomString(length).nextString();
    }

    /**
     * 生成GUID
     *
     * @return
     */
    public static String generateGUID() {
        UUID guid = UUID.randomUUID();
        return guid.toString().replaceAll("\\-", "");
    }


    /**
     * 将驼峰风格替换为下划线风格
     */
    public static String camelhumpToUnderline(String str) {
        final int size;
        final char[] chars;
        final StringBuilder sb = new StringBuilder((size = (chars = str.toCharArray()).length) * 3 / 2 + 1);
        char c;
        for (int i = 0; i < size; i++) {
            c = chars[i];
            if (isUppercaseAlpha(c)) {
                sb.append('_').append(toLowerAscii(c));
            } else {
                sb.append(c);
            }
        }
        return sb.charAt(0) == '_' ? sb.substring(1) : sb.toString();
    }

    /**
     * 将下划线风格替换为驼峰风格
     */
    public static String underlineToCamelhump(String str) {
        Matcher matcher = pattern.matcher(str);
        StringBuilder builder = new StringBuilder(str);
        for (int i = 0; matcher.find(); i++) {
            builder.replace(matcher.start() - i, matcher.end() - i, matcher.group().substring(1).toUpperCase());
        }
        if (Character.isUpperCase(builder.charAt(0))) {
            builder.replace(0, 1, String.valueOf(Character.toLowerCase(builder.charAt(0))));
        }
        return builder.toString();
    }

    public static boolean isUppercaseAlpha(char c) {
        return (c >= 'A') && (c <= 'Z');
    }

    public static boolean isLowercaseAlpha(char c) {
        return (c >= 'a') && (c <= 'z');
    }

    public static char toUpperAscii(char c) {
        if (isLowercaseAlpha(c)) {
            c -= (char) 0x20;
        }
        return c;
    }

    public static char toLowerAscii(char c) {
        if (isUppercaseAlpha(c)) {
            c += (char) 0x20;
        }
        return c;
    }
}
