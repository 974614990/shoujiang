package day4;

import java.sql.Array;
import java.util.ArrayList;

/**
 * 单例设计模式
 * 1、不允许用户创建这个类的对象
 *   将类的构造方法私有化
 * 2、在自己的类里面提供创建对象的方法
 */
public class Test {
    public static void main (String [] args){
        //正常情况下创建一个对象
       // Poker p = new Poker();
        Poker.shared.test();
        Player.getInstans();

    }
}

//一、第一种单例设计模式创建方法 饿汉式
class Poker{

    //1、默认构造函数
    //public Poker(){}
    //私有化
    private Poker(){}
    //2、定义一个静态的成员变量 记录这个单例对象

    /**
     * 单例命名： default sharedInstance  manager
     */
    public static final Poker shared = new Poker();

    public void test(){}
}

//懒汉式
class Player{

    //1、私有化
    private Player(){}
    //2、创建静态变量
   public static Player shared = null;
    //3、提供给外部一个访问的方法
    public static  Player getInstans(){
        //锁
        Object b =new Object();
        synchronized (b) {
            if (shared == null) {
                //如果没有创建  那么就创建一个
                shared = new Player();

            }
        }
        return shared;
    }
}

/**
 * 数组里面保存的都是对象的引用（指针）
 * 改变数组里面的对象的属性变量
 * 原始对象的值也跟着改变
 * 因为大家都是指向同一个内存空间
 */
class Test2{
    public static void main(String[] args){
        //线性表  <操作对象>泛型 名字 里面必须要指定
        ArrayList<Person> people = new ArrayList<>();
        //size 获取数组的元素
        people.size();
        //添加数据
        Person xw =new Person();
        people.add(xw);

        Person zs = new Person();
        people.add(zs);
        // 访问数据
        Person xw2 = people.get(0);
        xw2.name = "小王";
        System.out.println(xw.name);
    }
}
class Person{
    public String name;
}