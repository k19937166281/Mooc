package mooc.MOOC0604;

public class B {
	public Integer num = 100;
	public Integer num2 = 128;
	public Character c = 100;
	
	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		//Integer -128~127�г�����  true
		System.out.println(a.num == b.num);
		//Integer 128���ڳ�����          false
		System.out.println(a.num2 == b.num2);
		//Character 0-127�ڳ�����    true
		System.out.println(a.c == b.c);
	}

}
