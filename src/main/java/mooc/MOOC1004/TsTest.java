package mooc.MOOC1004;

import java.util.TreeSet;

public class TsTest {

    public static void main(String[] args) {

        TreeSet<Person> people = new TreeSet<>();

        people.add(new Person(1));
        people.add(new Person(2));
        people.add(new Person(3));
        people.add(new Person(4));
        people.add(new Person(1));
        people.add(new Person(2));
        people.add(new Person(3));
        people.add(new Person(4));

        System.out.println(people.size());

    }

}
