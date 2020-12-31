package mooc.MOOC0804;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;
 
public class InstantExample {
 
    public static void main(String[] args) {
       //时间戳
        Instant timestamp = Instant.now();
        System.out.println("Current Timestamp = "+timestamp);

        Instant specificTime = Instant.ofEpochMilli(timestamp.toEpochMilli());
        System.out.println("Specific Time = "+specificTime);
        //可以通过这个类  进行 类的交换
        Date date = Date.from(timestamp); 
        System.out.println("current date = " + date);
    }
 
}