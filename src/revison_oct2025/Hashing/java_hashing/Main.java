package revison_oct2025.Hashing.java_hashing;

import java.util.HashMap;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        // HashMap
        Person person1 = new Person("Charles");
        Person person2 = new Person("Charles");
        Person person3 = new Person("Turing");
        Person person4 = new Person("Turing");
        HashMap<Person, Integer> people = new HashMap<>();
        people.put(person1, 1);
        people.put(person2,1);
        people.put(person3, 2);
        people.put(person4,2);
        System.out.println(people);
        TreeMap<Person, Integer> peopleTree = new TreeMap<>();
        peopleTree.put(person1, 1);
        peopleTree.put(person2,1);
        peopleTree.put(person3,2);
        people.put(person4,2);
        System.out.println(peopleTree);
    }
}
