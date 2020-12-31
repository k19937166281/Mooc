package mooc.MOOC0902;

public class Son extends Father {
	@Override
    public void f1() throws RuntimeException {
		//子类重写方法，
		//所抛出的异常不能超出父类规定的范围
        System.out.println("1");
	}
}

