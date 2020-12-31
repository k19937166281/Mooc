package mooc.MOOC0605;

import java.io.File;

public class ArgumentPassing implements Cloneable{
	public static void changeValue(int a)
	{
		a = 10;
	}
	public static void changeValue(String s1)
	{
		s1 = "def";
	}
	public static void changeValue(StringBuffer s1)
	{
		s1.append("def");
	}
	public static void main(String[] args) throws CloneNotSupportedException {
		int a = 5;        //��������
		String b = "abc"; //���ɱ����
		StringBuffer c = new StringBuffer("abc"); //�ɱ����
		changeValue(a);
		changeValue(b);
		changeValue(c);
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
        ArgumentPassing argumentPassing = new ArgumentPassing();
        Object clone = argumentPassing.clone();
        Class<?> aClass = clone.getClass();
        System.out.println(aClass.getName());
        System.out.println(argumentPassing.equals(clone));
    }
}
