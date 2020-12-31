package mooc.MOOC0604;

public class MyTest {
    public static void main(String[] args) {

        String s0 = "abcdef";
        String a1 ="abc";
        //字符串常量池
        String a212321321 ="abc";


        //涉及到变量，所以 编译器不会 直接 把它 优化为  常量池中的    "abcdef"
        System.out.println(s0==(a1+"def"));
        //涉及到变量，所以 编译器不会 直接 把它 优化为  常量池中的    "abcdef"
        String s2 = a1 +"def";
        //todo :都是常量，编译器会自动优化为  abcdef
        String s3 = "abc" +"def";
        //涉及到 new 对象  编译器不优化
        String s4 = "abc" + new String("def");
        String def = new String("def");
        String s5 = "abc" +def;

        System.out.println(s0==s2);
        System.out.println(s0==s3);
        System.out.println(s0==s4);
        System.out.println(s0==s5);




        String a = "abc".intern();

        System.out.println("a__" + a);


        String a3 = new String("abc");
        String a4 = new String("abc");



        //true 指向 “abc”常量内存地址

        //自己比较自己
        System.out.println( "abc" == "abc" );
        //a3的
        System.out.println( a3 == "abc");
        System.out.println( a3 == a1 );
        System.out.println( a3 == a4 );
        System.out.println(a1==a212321321);
    }
}
