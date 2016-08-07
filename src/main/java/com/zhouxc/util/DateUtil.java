package com.zhouxc.util;

import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2015/4/9.
 */
public class DateUtil {

    public static String dateToString(Date date) {
        if(date != null) {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        } else {
            return "";
        }
    }

    public static Date stringToDate(String date) {
        Date date1 = null;
        try {
            if(!StringUtils.isEmpty(date))
                date1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date1;
    }
}
