package mooc.MOOC0804;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZoneOffset;
 
public class LocalDateTimeExample {
 
    public static void main(String[] args) {
 
        //��ǰ���� ʱ����
        LocalDateTime today = LocalDateTime.now();
        System.out.println("Current DateTime="+today);
 
        //�������ڣ� ʱ��������������
        today = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        System.out.println("Current DateTime="+today);
 
        //ָ������ʱ������������
        LocalDateTime specificDate = LocalDateTime.of(2014, Month.JANUARY, 1, 10, 10, 30);
        System.out.println("Specific Date="+specificDate);
 
        //��ʱ�䲻�ԣ������쳣DateTimeException
        //LocalDateTime feb29_2014 = LocalDateTime.of(2014, Month.FEBRUARY, 28, 25,1,1);
        
        //�Ϻ�ʱ��
        LocalDateTime todayShanghai = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
        System.out.println("Current Date in Shanghai="+todayShanghai);
 
         
        //��01/01/1970 10000��
        LocalDateTime dateFromBase = LocalDateTime.ofEpochSecond(10000, 0, ZoneOffset.UTC);
        System.out.println("10000th second time from 01/01/1970= "+dateFromBase); 
    } 
}