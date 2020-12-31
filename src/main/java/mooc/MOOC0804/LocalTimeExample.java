package mooc.MOOC0804;

import java.time.LocalTime;
import java.time.ZoneId;

public class LocalTimeExample {
 
    public static void main(String[] args) {

        //LocalTime 只负责  时分秒  纳秒
        LocalTime time = LocalTime.now();
        System.out.println("Current Time="+time);
 
        //设置时  分  秒  纳秒
        LocalTime specificTime = LocalTime.of(12,20,25,40);
        System.out.println("Specific Time of Day="+specificTime);
 
        //设置错了会 DateTimeException
        //LocalTime invalidTime = LocalTime.of(25,20);
 
        //可以设置 时区
        LocalTime timeSH = LocalTime.now(ZoneId.of("Asia/Shanghai"));
        System.out.println("Current Time in SH="+timeSH);
 
        
        //一天中的第  10000 秒 的  时分秒格式
        LocalTime specificSecondTime = LocalTime.ofSecondOfDay(10000);
        System.out.println("10000th second time= "+specificSecondTime);
 
    }
 
}