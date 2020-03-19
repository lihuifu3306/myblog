package com.crazy.core.util;

import java.util.Random;

/**
 * @author shkstart
 * @create 2019-04-03 10:31
 * 随机字符生成
 */
public class RandomString {
    private static final char[] SYMBOLS = new char[62];
    private static final char[] NUMBER = new char[10];

    static {
        for (int idx = 0; idx < 10; ++idx) {
            NUMBER[idx] = (char) ('0' + idx);
            SYMBOLS[idx] = (char) ('0' + idx);
        }
        for (int idx = 10; idx < 36; ++idx) {
            SYMBOLS[idx] = (char) ('a' + idx - 10);
        }
        for (int idx = 36; idx < 62; ++idx) {
            SYMBOLS[idx] = (char) ('A' + idx - 36);
        }
    }

    private final Random random = new Random();

    private final char[] buf;

    public RandomString(int length) {
        if (length < 1) {
            throw new IllegalArgumentException("length < 1: " + length);
        }
        buf = new char[length];
    }

    /**
     * 生成随机字符串
     *
     * @return
     */
    public String nextString() {
        for (int idx = 0; idx < buf.length; ++idx) {
            buf[idx] = SYMBOLS[random.nextInt(SYMBOLS.length)];
        }
        return new String(buf);
    }

    /**
     * 返回固定位数的随机整数
     *
     * @return
     */
    public Integer nextInt() {
        for (int idx = 0; idx < buf.length; ++idx) {
            int rd = random.nextInt(NUMBER.length);
            while (idx == 0 && rd == 0) {
                rd = random.nextInt(NUMBER.length);
            }
            buf[idx] = NUMBER[rd];
        }
        return Integer.parseInt(new String(buf));
    }
}
