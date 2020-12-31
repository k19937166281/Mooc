package mooc.MOOC0803;

public class StringBufferCapacityTest {

	public static void main(String[] args) {
		//StringBuffer�ĵĳ�ʼ��СΪ��16+��ʼ�ַ������ȣ���capacity=16+��ʼ�ַ�������
		//length ʵ�ʳ���  capacity �洢�ռ��С
		StringBuffer sb1 = new StringBuffer();
		System.out.println("sb1 length: " + sb1.length());
		//初始占用 16个字节  初始分配
		System.out.println("sb1 capacity: " + sb1.capacity());
		System.out.println("=====================");

		StringBuffer sb2 = new StringBuffer("123");
		sb2.append("456");
		//长度为 6    字节数为 19
		System.out.println("sb2 length: " + sb2.length());
		System.out.println("sb2 capacity: " + sb2.capacity());
		System.out.println("=====================");
		//length 19  capacity 为19
		sb2.append("7890123456789");
		System.out.println("sb2 length: " + sb2.length());
		System.out.println("sb2 capacity: " + sb2.capacity());
		System.out.println("=====================");

		//一旦length 大于 capacity时，capacity便在前一次的基础上加1后翻倍
        //length 20（一个字符占用一个字节）  capacity  =  （19+1）*2 也就是  40
		sb2.append("0");
		System.out.println("sb2 length: " + sb2.length());
		System.out.println("sb2 capacity: " + sb2.capacity());

		System.out.println("=====================");
		
		//如果 append的对象很长，超过了  原 capacity+1 乘以2   那么字节树会按照最新的 length来计算
		sb2.append("1234567890123456789012345678901234567890123456789012345678901234567890");
		System.out.println("sb2 length: " + sb2.length());
		System.out.println("sb2 capacity: " + sb2.capacity());

		System.out.println("=====================");
		//根据规则  91   182
		sb2.append("0");
		System.out.println("sb2 length: " + sb2.length());
		System.out.println("sb2 capacity: " + sb2.capacity());

		//把  capacity  的大小设置为 和 length相同
		sb2.trimToSize();
		System.out.println("=====after trime================");
		System.out.println("sb2 length: " + sb2.length());
		System.out.println("sb2 capacity: " + sb2.capacity());
	}

}
