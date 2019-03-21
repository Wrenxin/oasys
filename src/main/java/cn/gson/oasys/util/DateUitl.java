package cn.gson.oasys.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 万先生
 * 2019/2/25  16:17
 */
public class DateUitl {
    public static String dateToString(){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");//小写的mm表示的是分钟
        Date date=new java.util.Date();
        String str=sdf.format(date);
        return str;
    }
}
