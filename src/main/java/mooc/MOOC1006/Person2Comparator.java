package mooc.MOOC1006;

import java.util.Arrays;
import java.util.Comparator;



//如果一个类 它是一个 final 类     可以通过 实现   Comparator 接口 来重写  compare 实现排序   1 0 -1
public class Person2Comparator  implements Comparator<Person2> {
	@Override
    public int compare(Person2 one, Person2 another) {
		int i = 0;
		i = one.getName().compareTo(another.getName());
		if (i == 0) {
			return one.getAge() - another.getAge();
		} else {
			return i;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person2[] ps = new Person2[3];
		ps[0] = new Person2("Tom", 20);
		ps[1] = new Person2("Mike", 18);
		ps[2] = new Person2("Mike", 20);

		Arrays.sort(ps, new Person2Comparator());
		for (Person2 p : ps) {
			System.out.println(p.getName() + "," + p.getAge());
		}
	}
}
