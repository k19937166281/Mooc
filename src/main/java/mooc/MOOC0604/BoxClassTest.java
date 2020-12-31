package mooc.MOOC0604;

public class BoxClassTest {
	public static void main(String[] args)
	{
		int i1 = 10;
		Integer i2 = 10;                // 自动装箱
		System.out.println(i1 == i2);   //true
		// 基本类型 和包装类型作比较时  包装类型自动拆箱
		
		Integer i3 = new Integer(10);
        // 基本类型和包装类型作比较时，包装类型自动拆箱
		System.out.println(i1 == i3);  //true

		//i2取的是常量池中的10  i3是new开辟出的新的内存地址
		System.out.println(i2 == i3); //false


        //i4  i5     都是新的对象
		Integer i4 = new Integer(5);
		Integer i5 = new Integer(5);
        System.out.println("i4==i5"+(i4==i5));
        //i4+i5时 自动拆箱为 基本类型相加  所以是  基本类型于基本类型  基本类型于包装类型 基本类型与包装类型的 比较   后二者会发生自动拆箱操作  所以结果都是  true
		System.out.println(i1 == (i4+i5));   //true
		System.out.println(i2 == (i4+i5));   //true
		System.out.println(i3 == (i4+i5));   //true
		//i6 是常量池中的  10
		Integer i6 = i4 + i5;
		//拆箱比较
		System.out.println(i1 == i6);  //true
        //同样都是 常量池中的  10
		System.out.println(i2 == i6);  //true
        //常量对象  于  new 的对象  的比较   所以  false
		System.out.println(i3 == i6);  //false
	}	
}
