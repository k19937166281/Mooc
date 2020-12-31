package mooc.MOOC1004;

public class Person implements Comparable<Person> {

    private int age;

    public Person(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Person o) {
        System.out.println("---personSort---");
        return  this.age - o.age;
    }

}
