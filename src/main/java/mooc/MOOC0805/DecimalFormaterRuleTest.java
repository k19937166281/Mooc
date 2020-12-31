package mooc.MOOC0805;

import java.text.DecimalFormat;

public class DecimalFormaterRuleTest {
	public static void main(String[]args){
        
        DecimalFormat df1,df2;
        //整数部分为零的情况下，0/#的区别
        // 整数部分为零，#认为整数不存在，可不写，，，0认为没有，但至少写一位，写0
        df1 = new DecimalFormat("#.00");//能省就省
        df2 = new DecimalFormat("0.00");
         
        System.out.println(df1.format(0.1)); // .10  
        System.out.println(df2.format(0.1)); // 0.10
        System.out.println("-------------");
         //小数部分0/#的区别

        //#代表最多有几位，0代表必须有且只能有几位
        df1 = new DecimalFormat("0.00");
        df2 = new DecimalFormat("0.##");
        //0.00的情况下 必须有 两位小数 不足则补0     0.##是可以两位也最多两位，末位为0 就删除掉 能省就省
        System.out.println(df1.format(0.1)); // 0.10
        System.out.println(df2.format(0.1)); // 0.1
         //超过两位的小数   四舍五入了   我发现规则是 大于等于 0.0045的才会被保存下来 一律0.01
        System.out.println(df1.format(0.005)); // 0.01
        System.out.println(df2.format(0.005)); // 0.01
        System.out.println("-------------");
        //整数部分有多少位    0和#对整数部分多位时的处理时一致的，就是有多少位写多少位
        df1 = new DecimalFormat("0.00");
        df2 = new DecimalFormat("#.00");
        System.out.println("-------------");
        System.out.println(df1.format(2)); // 2.00
        System.out.println(df2.format(2)); // 2.00
        System.out.println("-------------");
        System.out.println(df1.format(20)); // 20.00
        System.out.println(df2.format(20)); // 20.00
        System.out.println("-------------");
        System.out.println(df1.format(200)); // 200.00
        System.out.println(df2.format(200)); // 200.00
         
         
    }
}
