package mooc.MOOC0604;

public class StringConstantTest {
	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = "abc";
		String s3 = "ab" + "c"; //���ǳ��������������Ż�����ͬ
		String s4 = "a" + "b" + "c";
		System.out.println(s1 == s2); //true
		System.out.println(s1 == s3); //true
		System.out.println(s1 == s4); //true
	}
}
