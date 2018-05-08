package com.sery.labmon.utils;

/**
 * Created by LuDan on 2018/5/8 13:39
 */
public class DateUtils {

    public static void main(String[] args){
        System.out.println(TimeStampToDate(180508093545L));
        System.out.println(180508093500L%10000000000L/100000000);
        System.out.println(180548093500L%100000000/1000000);
        System.out.println(181508093500L%1000000/10000);
        System.out.println(181508093500L%10000/100);
        System.out.println(181508093545L%100/1);
        System.out.println(5);
    }

    //180508093500
    public static String TimeStampToDate(long timeStamp){
        int year = (int) (timeStamp / 10000000000L)+2000;
        int month = (int) (timeStamp % 10000000000L / 100000000);
        int day = (int) (timeStamp % 100000000 / 1000000);
        int hour = (int) (timeStamp % 1000000 / 10000);
        int minute = (int) (timeStamp % 10000 / 100);
        int second = (int) (timeStamp % 100);
        String date = String.valueOf(year)+"年"+String.valueOf(month)+"月"+String.valueOf(day)+"日 "
                +String.valueOf(hour)+":"+String.valueOf(minute)+":"+String.valueOf(second);
        return date;
    }

}
