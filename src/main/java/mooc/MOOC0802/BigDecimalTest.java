package mooc.MOOC0802;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Locale;

public class BigDecimalTest {
	public static void main(String[] args) {



		BigDecimal b1 = new BigDecimal("123456789.987654321"); // ����BigDecimal����
		BigDecimal b2 = new BigDecimal("987654321.123456789"); // ����BigDecimal����
		System.out.println("b1: " + b1 +  ", b2:" + b2);
		System.out.println("2412阿斯顿" + b2.add(b1)); // �ӷ�����
		System.out.println("����������" + b2.subtract(b1)); // ��������
		System.out.println("�˷�������" + b2.multiply(b1)); // �˷�����

		//��Ҫָ��λ������ֹ����ѭ�������߰�����try-catch��

        //  需要指定位数，防止无限循环   或者把  divide 语句放在 try-catch 中
        //  第二个参数表示 保留几位小数   第三个参数代表着  四舍五入       计算是以10进制 计算的
          System.out.println("����������" + b2.divide(b1,10,BigDecimal.ROUND_HALF_UP)); // ��������
		
		System.out.println("�������" + b2.max(b1)); // ��������
		System.out.println("��С����" + b2.min(b1)); // �����С��
		
		int flag = b1.compareTo(b2);
		if (flag == -1) {
            System.out.println("�Ƚϲ���: b1<b2");
        } else if (flag == 0) {
            System.out.println("�Ƚϲ���: b1==b2");
        } else {
            System.out.println("�Ƚϲ���: b1>b2");
        }
		
		System.out.println("===================");
		
		//建议使用 字符串赋值
		System.out.println(new BigDecimal("2.3"));
		//这种方式 是 使用 double来赋值的     这时候 可能会出来一个   2.29XXXXXXXXXXXXXXX
		System.out.println(new BigDecimal(2.3));

		
		System.out.println("===================");
		
		BigDecimal num1 = new BigDecimal("10");
		BigDecimal num2 = new BigDecimal("3");
		//
		BigDecimal num3 = num1.divide(num2, 3, BigDecimal.ROUND_HALF_UP);
		System.out.println(num3);
	}
}
