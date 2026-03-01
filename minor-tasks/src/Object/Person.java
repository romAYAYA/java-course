package Object;

//public class Person {
//    private final String name;
//
//    public Person(String name) {
//        this.name = name;
//    }
//}

import java.util.Objects;

public class Person {
    public String name;
    public String middleName;
    public int age;
    public String job;

    public Person(String name, String middleName, int age, String job) {
        this.name = name;
        this.middleName = middleName;
        this.age = age;
        this.job = job;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || o.getClass() != getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(middleName, person.middleName);
    }
}