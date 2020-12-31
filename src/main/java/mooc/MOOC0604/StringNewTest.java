package mooc.MOOC0604;

public class StringNewTest {
	public static void main(String[] args) {
		String s0 = "abcdef";
		String s1 = "abc";
		String s2 = "abc";
		String s3 = new String("abc");
		String s4 = new String("abc");
		
		String s5 = s1 + "def";
		String s6 = "abc" + "def";
		String s7 = "abc" + new String ("def");



		System.out.println(s5 == s7); //false
		System.out.println(s6 == s7); //false
		System.out.println(s0 == s6); //true 
		System.out.println("=========================");

		
		String s8 = s3 + "def";
		String s9 = s4 + "def";
		String s10 = s3 + new String("def");
		System.out.println(s8 == s9); //false
		System.out.println(s8 == s10); //false
		System.out.println(s9 == s10); //false
	}
}
