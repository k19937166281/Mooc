package mooc.MOOC0804;

import java.util.Calendar;
import java.util.Date;

public class CalendarTest {

	Calendar calendar = Calendar.getInstance();

	public void test1() {
        // 获取当前年份
        int year = calendar.get(Calendar.YEAR);
        //（格里高利日历规则  年份  是 0-11）  取到+1才对
        int month = calendar.get(Calendar.MONTH) + 1;
        //获取 日
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        //获取 12小时制  小时
        int hour = calendar.get(Calendar.HOUR);
        //获取 24小时制 小时
        // int hour = calendar.get(Calendar.HOUR_OF_DAY);
        // 分
        int minute = calendar.get(Calendar.MINUTE);
        // 秒
        int second = calendar.get(Calendar.SECOND);

        // 英语国家星期从星期日 开始计算   他们的星期1时我们的星期日  ，所以 减 1 就是我们的
        int weekday = calendar.get(Calendar.DAY_OF_WEEK)-1;


        System.out.println("currentTime" + year + "year" + month + "month" + day + "day" + hour
                + "hour" + minute + "minute" + second + "second" + "week" + weekday);
    }


    public void test2() {
        // ͬ�����¸��µĽ���calendar.add(Calendar.MONTH, 1);
        //年份+1  就是下一年
        calendar.add(Calendar.YEAR, 1);

        // ��ȡ��
        int year = calendar.get(Calendar.YEAR);
        // ��ȡ��
        int month = calendar.get(Calendar.MONTH) + 1;
        // ��ȡ��
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        System.out.println("һ���Ľ��죺" + year + "��" + month + "��" + day + "��");
    }

    //求值： 6月的最后一天是多少号
    public void test3() {

        int currentMonth = 6;
        // 设置  年月日     2020年 7月（英语国家的6 是我们的 7月） 的第一天  1日
        calendar.set(calendar.get(Calendar.YEAR), currentMonth, 1);
        //日变量   减 1天   就得到了 6月的最后一天
        calendar.add(Calendar.DATE, -1);

        //获取   参照于这个月的日
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        System.out.println("最后一天是" + day + "日");
    }

    // 设置日期    set设置    get 获取
    public void test4() {
	    //param1 field ，value   年 2000
        calendar.set(Calendar.YEAR, 2000);
        System.out.println("设置了" + calendar.get(Calendar.YEAR) + "年");

        calendar.set(2018, 7, 8);
        //getYear  感觉是一个很棒的方法   不必再去  分为 几个方法    getYear getMonth getDay getMinute getSecond
        int year = calendar.get(Calendar.YEAR);
        // ��ȡ��
        int month = calendar.get(Calendar.MONTH)+1;
        // ��ȡ��
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        System.out.println("year" + year + "month" + month + "day" + day );
    }

    //add  roll
    public void test5() {
        //8月8
        calendar.set(2018, 8, 8);
        //7月31
        calendar.add(Calendar.DAY_OF_MONTH, -8);

        // 2018
        int year = calendar.get(Calendar.YEAR);
        // 7
        int month = calendar.get(Calendar.MONTH)+1;
        // 31
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        System.out.println("2018.8.8, add-8before" + year + "." + month + "." + day);

        calendar.set(2018, 8, 8);
        //此处使用 roll方法
        calendar.roll(Calendar.DAY_OF_MONTH, -8);


        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH)+1;

        day = calendar.get(Calendar.DAY_OF_MONTH);
//不改变  月份   只改变   ri
        System.out.println("2018.8.8, roll-8before" + year + "." + month + "." + day);
    }


	public static void main(String[] args) {
		CalendarTest c = new CalendarTest();
		c.test1();
		System.out.println("============");
		c.test2();
		System.out.println("============");
		c.test3();
		System.out.println("============");
		c.test4();
		System.out.println("============");
		c.test5();

	}

}
