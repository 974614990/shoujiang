package day11;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * 泛型 --void * 泛指某一种类型 Generic
 * 泛型类  使用泛型类型作为参数
 * 泛型方法
 * 泛型数组
 *
 */
public class MyClass {
    public static void main(String [] args){
     /*
        GenernicTest<String> g1 = new GenernicTest<>();//<包装类>
        g1.test("jack","Merry");
        */
     /*
     Collection --List --ArrayList
                       --LinkedHashSet
                --Set-----HashSet
                       --LinkedHashSet
                       --TreeSet只能存放一种类型 有序的集合可以排序的集合

      */
     /*
     1、集合里面对象不能重复 如果重复就添加不进去
     内部使用HashMap来实现 键值对 键key不能被重复的
     2、集合是无序的   添加的顺序和存储顺序无关
       哈希算法
       如何实现HashMap里面的key不同
       计算这个key对应的对象hash值
       整数：在对象地址的基础上按照一定的算法计算出来的一个整数
              如果两个对象相同 那么计算出来的hash值就相同

      */
        HashSet<String> names = new HashSet<>();
        names.add("jack");
        names.add("Merry");
        names.add("abc");

        names.removeIf(ele ->{
            return ele.compareTo("c")>0;//ASCII码
                });
        System.out.println(names);

        //可以排序的集合
        TreeSet<Float> score = new TreeSet<>();
        score.add(24.5f);
        score.add(2.0f);
        score.add(1.0f);
        System.out.println(score);

        TreeSet<Person> score1 = new TreeSet<>((Person p1,Person p2) -> p1.compareTo(p2));
        Person p1 = new Person("jack",20);
        Person p2 = new Person("tom",21);
        Person p3 = new Person("Merry",19);

        score1.add(p1);
        score1.add(p2);
        score1.add(p3);
        //equals 比较的是对象内部的内容
        //使用的两个度先后必须实现Comparable接口的CompareTo方法
        //在compareTo里面实现具体该如何比较
        System.out.println(p1 == p1);

        //HashMap  集合 存储数据的特点 ：key - value
        //key不能重复 可以是任意的对象类型  通常使用字符串String
        HashMap<String,Integer> score2= new HashMap<>();

        //添加对象： 添加键值对
        score2.put("Chinese",89);
        score2.put("Math",90);
        score2.put("English",88);

        System.out.println(score2);
        //更改某个键对应的值
        score2.put("Chinese",91);

        //获取键值对的个数
        score2.size();

        //获取所有的key
        System.out.println(score2.keySet());

        //获取所有的值  返回Collection集合
        System.out.println(score2.values());

        //获取Entry:key+ value
        System.out.println(score2.entrySet());

        //获取一个键对应的值
        System.out.println(score2.get("English"));

        //键值对的遍历
        //1.通过遍历key来得到每一个key对应的值
        for(String key: score2.keySet()){
            //通过key得到值
            int s = score2.get(key);
            System.out.println("key:" + key+" "+ "value:" +s);
        }
        //2.通过EntrySet 得到Entry对象的集合
        //一个Entry管理一个键值对 getKey getValue
        Set <Map.Entry<String,Integer>>entrys= score2.entrySet();
        for(Map.Entry entry:entrys){
            //得到Entry对应的key
            String key = (String) entry.getKey();

            //获取到Entry对应的值
            Integer value = (Integer)entry.getKey();

            System.out.println("key:" + key+" "+ "value:" +value);
        }
    }
}


class Person implements Comparable{
    String name ;
    int age;

    public Person(String name, int age){
        this.name = name ;
        this.age = age;
    }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        //1、判断o对象是不是Person的一个对象
        if(o instanceof  Person){
            Person o1 = (Person)o;
            //自己规定比较的策略
            if(this.age !=o1.age){
                return this.age - o1.age;
            }else {
                //年龄相同的情况下 再再名字的首字母
                return  this.name.compareTo(o1.name);
            }
        }else {
            return  -1;
        }
    }
}
class GenernicTest<T>{
    int age;
    T a1;
    T a2;

    public void test(T a1 , T a2){
        this.a1 = a1;
        this.a2 = a2;

       System.out.println(a1.equals(a2));
    }
}
