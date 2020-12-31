package mooc.MOOC0802;

import java.math.BigInteger;

public class BigIntegerTest {

	public static void main(String[] args) {
		BigInteger b1 = new BigInteger("1");
		BigInteger b2 = new BigInteger("1");
		System.out.println("b1: " + b1 +  ", b2:" + b2);
		System.out.println("加了之后" + b2.add(b1));
		System.out.println("减" + b2.subtract(b1));
		System.out.println("乘" + b2.multiply(b1));
		System.out.println("除" + b2.divide(b1));
		System.out.println("最大值" + b2.max(b1));
		System.out.println("最小值" + b2.min(b1));
		BigInteger result[] = b2.divideAndRemainder(b1);
		System.out.println("商" + result[0] + "余" + result[1]);
		System.out.println("值是否相等" + b1.equals(b2));
		int flag = b1.compareTo(b2);
		if (flag == -1) {
            System.out.println("比较操作: b1<b2");
        } else if (flag == 0) {
            System.out.println("比较操作: b1==b2");
        } else {
            System.out.println("比较操作: b1>b2");
        }

	}
}
