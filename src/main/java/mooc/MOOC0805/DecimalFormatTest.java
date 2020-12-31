package mooc.MOOC0805;

import java.text.DecimalFormat;

public class DecimalFormatTest {

	public static void main(String[] args) {
		DecimalFormat df1 = new DecimalFormat("0.0"); 

		DecimalFormat df2 = new DecimalFormat("#.#");

		DecimalFormat df3 = new DecimalFormat("000.000");
//#比较强    不额外增加字符，不强制减少字符
		DecimalFormat df4 = new DecimalFormat(".###");

		System.out.println(df1.format(12.34)); //12.3

		System.out.println(df2.format(12.34)); //12.3

		System.out.println(df3.format(1456546542.34)); //012.340

		System.out.println(df4.format(56562.34)); //12.34

		DecimalFormat df5 = new DecimalFormat("0.00");
		double d1 = 123456789.123456;
		double d2 = 987654321.987654321;

		System.out.println("format1_d1=" + df5.format(d1));// ���format1_d1=123456789.12
		System.out.println("format1_d2=" + df5.format(d2));// format1_d2=987654321.99
//每三位 +   ，  规则
		DecimalFormat df6 = new DecimalFormat("#,##0.00");
		System.out.println("format2_d1=" + df6.format(d1));// �����format2_d1=123,456,789.12
		System.out.println("format2_d2=" + df6.format(d2));// �����format2_d2=987,654,321.99
															// ��������

	}

}
