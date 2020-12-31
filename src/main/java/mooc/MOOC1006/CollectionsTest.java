package mooc.MOOC1006;

import java.util.ArrayList;
import java.util.Collections;

public class CollectionsTest {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(12);
        list.add(2);
        list.add(19);

        Collections.sort(list);
        System.out.println("sort");
        list.forEach(i-> System.out.println(i));
        System.out.println("--------------------");
        //index
        System.out.println("index  " + Collections.binarySearch(list, 12));
        //maxValue
        System.out.println("maxValue"+Collections.max(list));
        //minValue
        System.out.println("minValue"+Collections.min(list));
        //reverse
        Collections.reverse(list);
        System.out.println("reverse");
        list.forEach(i-> System.out.println(i));
        System.out.println("--------------------");
        System.out.println("fill");
         //批量赋值
        Collections.fill(list, 100);
        list.forEach(i-> System.out.println(i));


	}
}
