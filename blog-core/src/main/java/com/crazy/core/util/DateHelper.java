package com.crazy.core.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author shiyi
 * @version 1.0
 * @date 2020-3-21 21:40
 */
public class DateHelper {

    public static String YYYYMMDD = "yyyy-MM-dd";

    public static String today() {
        return dateToString(new Date(), YYYYMMDD);
    }

    public static String dateToString(Date date, String format) {
        SimpleDateFormat sf = new SimpleDateFormat(format);
        return sf.format(date);
    }

}
