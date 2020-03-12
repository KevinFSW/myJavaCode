package tool.set;

import java.util.HashSet;
import java.util.TreeSet;

public class SetTest{
    public static void main(String[] args) {
        HashSet<Person> hashSet = new HashSet<>();

        hashSet.add(new Person("aaa", "男", 20));
        hashSet.add(new Person("aaa", "男", 21));
        hashSet.add(new Person("aaa", "男", 22));
        hashSet.add(new Person("aaa", "男", 23));
        hashSet.add(new Person("aaa", "男", 24));
        hashSet.add(new Person("aaa", "男", 25));

        System.out.println(hashSet.size());
        System.out.println(hashSet);

        TreeSet<Person> treeSet = new TreeSet<>();

        treeSet.add(new Person("a", "男", 20));
        treeSet.add(new Person("c", "男", 21));
        treeSet.add(new Person("b", "女", 22));
        treeSet.add(new Person("b", "男", 23));
        treeSet.add(new Person("e", "男", 24));
        treeSet.add(new Person("d", "男", 25));

        System.out.println(treeSet.size());
        System.out.println(treeSet);

        Person person = new Person("d", "男", 25);
        System.out.println(person.compareTo(new Person("d", "男", 33)));

        //HashSet<String> hashSet = new HashSet<>();

        /*
        hashSet.add("0");
        hashSet.add("1fds");
        hashSet.add("aasd");
        hashSet.add("3");
        hashSet.add("bghdg");
        hashSet.add("5");
        hashSet.add("c");

        System.out.println(hashSet.size());
        System.out.println(hashSet);
        hashSet.remove("5o");
        System.out.println(hashSet);
        */
    }
}