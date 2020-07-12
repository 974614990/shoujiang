package day3;

public class Test {
    public static void main(String [] args){
        Poker1 p = new Poker1();
        p.setNumber("jacker");
        System.out.println(p.getNumber());

        Poker1 pp =new Poker1("k","♥");
        System.out.println(pp.getNumber());
        System.out. println(pp.getColor());

    }
}
class Poker1 {
    private String number;
    private String color;
//类的默认构造方法
    public Poker1(){//无参
        System.out.println("构造方法");
    }
    //构造方法的重载  重新写一个有参数的构造方法
    public Poker1(String num, String col){
        number = num;
        color = col;
        System.out.println("自定义的构造方法");
    }


    public boolean bigerThen(String number){
        return true;

    }
    public void t1(int ...ages){

    }
    //给外部提供一个set方法 通过这个方法间接给number赋值 可以对外部的值进行控制
    public void setNumber(String num){
        number = num;
    }
    //给外部提供一个get 方法访问某个变量的值
    public String getNumber(){
        return number;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
//static 修饰的属性和方法都会在对象创建之前优先加载

/**
 * 方法  实例方法/对象方法 ：必须创建某一个对象才能调用的方法
 * 类方法/静态方法： 不需要创建对象 直接用这个类调用 ,不能使用对象调用
 *
 * 静态属性
 * 1、定义一个常量 只能赋值一次
 * 2、单例设计模式
 */
class MyClass{
    public void test() {
        System.out.println("这是对象方法");
    }
    public static void test2(){
        System.out.println("这是静态方法");
    }

}
class T1 {
    public static void main(String[] args) {
        //使用类的实例方法 对象方法
        MyClass c1 = new MyClass();
        c1.test();

        //使用类方法 静态方法
        MyClass.test2();

        //什么情况下需要写静态方法
        //工厂设计模式Factory
        //当不需要记录数据 只关心功能就可以使用静态方法
        //静态方法里面不能调用这个类的属性和非静态方法
    }
}

