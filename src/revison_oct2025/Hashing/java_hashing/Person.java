package revison_oct2025.Hashing.java_hashing;

import java.util.Objects;

public class Person implements Comparable {
    String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    // When the hash of two objects is same then the equals() method is called to see if these 2 objects are
    // logically equal or not, because multiple objects could yield same hash i.e. collision
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public int compareTo(Object o) {
        Person p = (Person) o;
        return this.name.compareTo(p.name);
    }
}
