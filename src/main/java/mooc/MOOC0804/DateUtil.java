package mooc.MOOC0804;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.TemporalAdjusters;
 
public class DateUtil {
 
    public static void main(String[] args) {
 
        LocalDate today = LocalDate.now();
        //today.getYear()  方法比 Calendar 的get  简单    isLeapYear 是否是 闰年
        System.out.println("Year "+today.getYear()+" is Leap Year  "+today.isLeapYear());
 
        // 父类实现了比较器   与之01/01/2015比较     还有一个  isAfter
        System.out.println("Today is before 01/01/2015  "+today.isBefore(LocalDate.of(2015,1,1)));
 
        //当前时分秒
        System.out.println("Current DateTime="+today.atTime(LocalTime.now()));
 
        //网管 加时间 方法
        System.out.println("10 days after today will be "+today.plusDays(10));
        System.out.println("3 weeks after today will be "+today.plusWeeks(3));
        System.out.println("20 months after today will be "+today.plusMonths(20));
 
        System.out.println("10 days before today will be "+today.minusDays(10));
        System.out.println("3 weeks before today will be "+today.minusWeeks(3));
        System.out.println("20 months before today will be "+today.minusMonths(20));

        System.out.println("-------------------------");


        System.out.println("First date of this month= "+today.with(TemporalAdjusters.firstDayOfMonth()));
        LocalDateTime localDateTime =LocalDateTime.now();

        LocalDateTime with = localDateTime.with(TemporalAdjusters.lastDayOfYear());
        System.out.println("LocalDateTime with" +with);

        LocalDate lastDayOfYear = today.with(TemporalAdjusters.lastDayOfYear());
        System.out.println("Last date of this year= "+lastDayOfYear);

        //计算时间差   这里是距离下一年
        //Period Format= P5M15D   5个月 15天
        //Months remaining in the year= 5  5个月
        Period period = today.until(lastDayOfYear);
        System.out.println("Period Format= "+period);
        System.out.println("Months remaining in the year= "+period.getMonths());

        //贼鸡儿麻烦
    }
}


