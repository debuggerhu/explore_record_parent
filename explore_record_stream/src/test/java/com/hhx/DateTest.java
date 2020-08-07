package com.hhx;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author huhaixaing
 * @date 2020/8/4 10:57
 * @Description: com.hhx
 */
public class DateTest {
    public static void main(String[] args) {
//        Date date = new Date();
//        System.out.println(new Date());
//        Date date = new Date();
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        dateFormat.toPattern()
//        String recordTimeStr=new Date().toString();
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date recordTime;
//        try {
//            recordTime = dateFormat.parse(recordTimeStr);
//            System.out.println("未出现");
//        } catch (ParseException e) {
//            System.out.println("出现异常");
//            return;
//        }



        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Timestamp timestamp = new Timestamp(new Date().getTime());

        System.out.println(System.currentTimeMillis());

        System.out.println(timestamp);

        System.out.println("------------------------------");
        System.out.println(new Date());
//        try {
//            System.out.println(sdf.parse(timestamp.toString()));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
    }
}
