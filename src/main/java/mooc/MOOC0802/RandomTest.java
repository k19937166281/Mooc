package mooc.MOOC0802;


import java.util.Random;
import java.util.stream.IntStream;

public class RandomTest {

    public static void main(String[] args)
    {
        //第一种办法，采用Random类 随机生成在int范围内的随机数
        Random rd = new Random();
        System.out.println(rd.nextInt());
        System.out.println(rd.nextInt(100)); //0--100的随机数
        System.out.println(rd.nextLong());
        System.out.println(rd.nextDouble());
        System.out.println("=========================");

        //第二种，生成一个范围内的随机数 例如0到时10之间的随机数
        //Math.random[0,1)
        System.out.println(Math.round(Math.random()*10));
        System.out.println("=========================");

        //rd.ints()
        //JDK 8 新增方法  rd.ints()          因为是返回无限数量的int流，所以单独调用  rd.ints()  无法
        //System.out.println(rd.ints().count());

            //限制生成  10 个
        int[] arr = rd.ints(10).toArray();  //生成10个int范围类的个数。
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("=========================");
        // 随机出 5个   0-99 范围内的数字
        arr = rd.ints(5, 0, 100).toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        System.out.println("=========================");

        arr = rd.ints(10).limit(5).toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

}