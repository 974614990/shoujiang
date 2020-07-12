package day5.day5.demo;

import java.util.ArrayList;

import swu.ht.java.java5.Person;

public class Person3 {
    protected String name;
    protected int age;

    public Person3(String name,int age){
        this.name = name ;
        this.age = age;
    }
    public void walk(){
    }
    public void eat(){

    }
}
class CiviServant extends Person3{
    private int salary;
    private int count;

    public CiviServant(String name,int age,int salary,int count){
        super(name,age);
        this.count = count;
        this.salary = salary;
    }
    @Override
    public void walk(){
        System.out.println("慢慢的走");
    }
    @Override
    public void eat(){
        System.out.println("大吃大喝");
    }

    public void cShow(){
        System.out.println("CivilServant{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", count=" + count +
                '}');
    }
}
class Woker extends Person3{
    private int salary;
    private String tec;

    public Woker(String name ,int age , int salary,String tec){
        super(name,age);
        this.salary = salary;
        this.tec = tec;
    }
    @Override
    public void walk(){
        System.out.println("快跑");
    }
    @Override
    public void eat(){
        System.out.println("急匆匆的吃");
    }
    public void show(){
        System.out.println("Worker{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", tec='" + tec + '\'' +
                '}');
    }
}
class Test{
    public static void main(String [] args){
        //Person [] peoples = new Person[6];
        ArrayList<Person3> peoples = new ArrayList<>();

        Person3 c1 = new CiviServant("小王",30,5000,30);
        Person3 c2 = new CiviServant("小李",20,3000,34);
        Person3 c3 = new CiviServant("小徐",32,4000,32);

        peoples.add(c1);
        peoples.add(c2);
        peoples.add(c3);


        Person3 w1 = new Woker("小样",23,5646,"Android开发");
        Person3 w2 = new Woker("小张",26,5000,"IOS开发");
        Person3 w3 = new Woker("李华",30,6300,"Web开发");

        peoples.add(w1);
        peoples.add(w2);
        peoples.add(w3);

        for(Person3 p:peoples){
            //找到p到底是哪个类型的对象
            if(p instanceof CiviServant){
                //公务员
                CiviServant c = (CiviServant)p;
                c.cShow();
                c.walk();
                c.eat();
            }else {
                Woker w =(Woker)p;
                w.show();
                w.eat();
                w.walk();
            }
        }
    }
}