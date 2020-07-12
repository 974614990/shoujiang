package day10.demo;

import java.util.ArrayList;

public class MyClass {
    public static void main(String [] args){
        ArrayList<Person>  people = new ArrayList<>();

        Person p1 =  new Person("张家辉",35);
        Person p2 =  new Person("张婕",25);
        Person p3 =  new Person("张飞",30);
        Person p4 =  new Person("小王",45);
        Person p5 =  new Person("小杰",15);

        people.add(p1);
        people.add(p2);
        people.add(p3);
        people.add(p4);
        people.add(p5);


    }
}
class Person {
    String name;
    int age;

    public  Person(String name,int age){
        this.name  = name ;
        this.age = age ;

    }
}
