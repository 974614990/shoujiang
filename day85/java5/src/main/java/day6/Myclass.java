package day6;

public class Myclass {
    public static void main(String []args){
        //BaseAndroidStudy study = new BaseAndroidStudy("java编程思想","攻克腾讯"); 抽象类不能实例化
        //创建抽象类的具体对象 1、 显示的创建一个类 继承与抽象类 创建这个类的对象
        Student xw = new Student("小王","Java编程思想","拿到一份好的offer");
        //2.使用匿名类 只使用一次
        BaseAndroidStudy zs = new BaseAndroidStudy("Java编程思想","高薪") {
            @Override
            public void StudyC() {
                System.out.println("参加培训");
            }
        };
    }
}
/**
 * 抽象类 abstract
 * 模板的作用 模具 -> 玩具（颜色不一样 材质不一样）
 *
 */
/**
 * 定义一个抽象类 管理学习Android Q开发的路线
 * 抽象类里面定义使用这个功能就必须（可以选择）实现的方法或者属性
 *抽象类有abstract修饰 里面可以创建抽象方法
 * 不能创建抽象类的实例化
 */

abstract class BaseAndroidStudy{
    //定义一个代码块
    {
        System.out.println("锻炼身体");
    }
    //定义一个属性 用于保存数据
    public String javaBook;
    public Dream dream;

        //提供一个构造方法 给子类提供一个方法 给自己的属性赋值
    public BaseAndroidStudy(String javaBook,String dream){
        this.javaBook = javaBook;
        this.dream = new Dream();
        this.dream.name = dream;
    }

    //定义一个静态的常量
    public static final String CBOOK = "C Primier";//static 静态变量是共享的

   public abstract void StudyC();//不知道如何去学就不需要实现 子类来实现abstract要使用

    //定义一个普通方法 已经确定实现这个方法培训的实现
    public void studyJava(){
        System.out.println("参加Android的培训");
    }

    //定义一个内部类用来管理每个人的梦想
     private class Dream{
        public String name;

        public void show(){
            System.out.println("我的梦想是："+name);
        }
    }
}

/**
 * 使用extends来继承一个抽象类、如果继承一个抽象类 就必须实现抽象类里面的抽象方法
 *
 * 如果不实现抽象方法，也可以把这个类定义文件抽象类
 */
class Student extends BaseAndroidStudy{
    String name;

    @Override
    public void StudyC() {
        System.out.println("看书看视频");
    }
    public Student(String name,String  bookName,String dream){
        super(bookName,dream);
        this.name = name;
    }
}
/**
 * 接口 interface 定义一套方法用于对象之间的通信  谁用谁实现
 *  不要把接口理解为某一个物理存在的东西
 *  接口就是定义一套规则 /规范
 */

/**
 * 接口里面默认的变量都是static final 常量 一定要初始化 常量默认大写
 * 默认情况下不需要自己写public static final
 * 不能定义变量 只能定义常量
 *
 * 接口里面不允许定义代码块
 * 接口里面不能定义构造方法
 * 接口里面不能添加普通方法/对象方法/实例方法
 * 只有抽象方法 默认就是public abstract
 *
 * 如果需要定义已经有实现的方法 就使用default
 *
 * 接口里面可以定义内部类 在内部类里面可以定义方法 默认public static
 *
 * 使用implements 实现一个接口
 *
 * 一个类可以实现多个接口 多个接口之间用 ， 隔开
 *
 * 一个类里面可以继承多个接口 多个接口之间用 , 隔开
 */
 interface TestInterfance{

     int I = 100;
     int COUNT = 20;

     void test();

     class inner{
         int name;
         public void show(){
             System.out.println("内部类");
         }
     }
 }

interface TestInterfance2{

    int I = 100;
    int COUNT = 20;

    void test2();

    class inner{
        int name;
        public void show(){
            System.out.println("内部类");
        }
    }
}

class  PXDClass implements TestInterfance,TestInterfance2{
     @Override
     public void test(){
        TestInterfance.inner in = new TestInterfance.inner();
         in.show();
     }
     @Override
    public void  test2(){

     }

 }
 class Te{
     public static void main (String [] args){
         //接口的实现
         PXDClass pxd = new PXDClass();
         TestInterfance2 t = new PXDClass();
     }
 }
