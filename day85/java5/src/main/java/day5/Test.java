package day5;



/**
 * 类里面存在
 * 成员变量
 * 构造方法
 * 方法
 * 代码块 {} 在对象创建之前 就优先会被调用
 * 格式  修饰符{
 *          预先执行的内容
 *          }
 *   类里面可以有多个代码块
 *  执行顺序和出现的先后顺序相同
 *  尽量不要再类里面写多个代码块
 *  静态代码块 里面不能调用成员变量和实例方法
 *
 * 内部类
 *
 *
 * 继承
 * 多态
 * 组合
 */
public class Test {
    public static void main(String [] args){
        Person p = new Person();
    }
}
/**
 * 在创建一个对象之前需要先做点准备工作
 * 1、构造方法
 * 2、静态变量
 * 3、静态方法 必须主动调用才执行
 *
 */
class Person{
    int age ;
    {
        age = 20;
        System.out.println("代码块 age = " +age);
    }
    static {
        System.out.println("静态代码块优先被执行");
    }

    public Person(){
        System.out.println("默认的无参构造方法");
    }
    public Person(int ager){
        this.age = age;
        System.out.println("有参构造方法");
    }
}


/**
 *  定义一个类 可以在多个地方定义
 *  1、单独创建一个文件管理类
 *  2、直接在文件里面 类的上面 和下面创建
 *  3、直接在某个类内部创建一个类
 *       一个类依附于另一个类\
 *      静态内部类不能调用类外部属性
 *      而普通内部类可以调用
 *      外部类访问内部类需要创建一个内部类的对象才能访问
 *
 */

class  RelativeLayout {
    String view;
    LayoutParams layoutParams;
    //在显示一个视图前 必须告诉系统这个视图的位置
    public void show(float left,float right,float top,float bottom){
       layoutParams =new LayoutParams(left,right,top,bottom);
        System.out.println("视图" + view + "显示出来了");
        System.out.println("left:" + left + "top:" + top + "right:" + right + "bottom:" + bottom);
    }
    /**
    public void show(LayoutParams Layout) {
        System.out.println("视图" + view + "显示出来了");
        System.out.println("left:" + Layout.leftMergin + "top:" + Layout.topMergin + "right:" + Layout.rightMergin + "bottom:" + Layout.bottomMergin);
    }
*/
    //定义一个内部类 用于管理相对布局的具体布局属性
    public  class LayoutParams {
        float leftMergin;
        float topMergin;
        float rightMergin;
        float bottomMergin;

      public  LayoutParams(float leftMergin, float topMergin, float rightMergin, float bottomMergin) {
            this.bottomMergin = bottomMergin;
            this.leftMergin = leftMergin;
            this.rightMergin = rightMergin;
            this.topMergin = topMergin;
        }
    }
}
class testLayout {
    public static void main(String[] args) {
        //创建一个相对布局 容器视图
        RelativeLayout r1 = new RelativeLayout();

        r1.view = "分享视图";

        //显示这个视图
        //准备好视图的布局属性
      //  RelativeLayout.LayoutParams params =  new RelativeLayout.LayoutParams(20,20,20,20);
       // r1.show(params);
        //使用匿名对象 只需要使用一次
        r1.show(20,20,20,20);


        TestInner t1 = new TestInner();
        t1.test();
    }
}
class TestInner{
    int a;
    int b;
    Inner inner;

    class Inner{
        //非静态的内部类 可以访问外部类的属性和方法
        public Inner(){
            a = 20;
            b = 30;

            show();
        }
    }
    public void test(){
        inner = new Inner();
    }
    public void show(){
        System.out.println("a ="+a+" "+"b =" + b);
    }
}

/**
 * 封装性  类来封装属性和方法  通过里面的访问权限 private（当前类里面访问） public（那个地方都可以访问） protected（当前包 ，类里面可以用） 对属性进行暴露
 */
/**
 * 继承   A (父类)extends （子类）B   私有内部类子类无法继承
 *      为什么要继承 获得父类的方法和属性 并且需要添加自己的属性和方法
 *      java 里面只能单继承 ，但是可以变向多继承
 *      Person
 *      Student
 *      teacher
 *
 *      所有的类都是直接或者间接继承于Object类
 *      当调用子类的方法时 如果没有有就要到父类里面去查找
 *        如果在子类里面需要调用父类的方法后显示调用父类的属性
 *        使用super
 *        什么情况下需要在一个方法里面调用super的对应方法？
 *        public voidwalk(){
 *          super.walk;
 *          }
 *          如果一个方法需要完成一个功能 ，又不能单独完成 必须要弗雷作相应的工作：
 *          1、父类做完之后 子类在操作
 *          2、子类做点事情之后 ，在调用父类操作
 *
 *        如果子类里面需要重新实现父类的方法 就需要重写
 * @override
 *
 * 如果父类有自定义构造方法
 * 子类的构造方法里必须显示调用父类的构造方法
 *
 * 如果父类有内部类 子类中有同名的内部类 那么父类中的内部类就被屏蔽了
 * 如果非要使用父类中了内部类只能使用全类名 （完整路径）Person.inners
 */
class Person1{
    String name;
    int age;

    public Person1(String name,int age){
    this.name = name;
    this.age = age;
    }
    public void walk(){
        System.out.println(name + "：人走路");
    }
    public void eat(){
        System.out.println(name + "：人吃饭");
    }
    public class inners{
        public void show(){
            System.out.println("Person inners");
        }
    }
}
//全类名 ：完整路径 Person.inners
class Student extends Person1{
    int id;
    String school;
    inners i;//内部类可以继承下来

    public Student(String name,int age,int id,String school){
        super(name,age);
        this.id = id ;
        this.school =school;
    }
    public void show(){
        System.out.println("name:" +name);
    }
    //方法重写
    @Override
    public void walk(){
        System.out.println("学生优雅的走");
    }
    @Override
    public void eat(){
        System.out.println("学生小口吃饭");
    }
    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", id=" + id +
                ", school='" + school + '\'' +
                '}';
    }
}

class TestEctends{
    public static void main(String[] args){
       /**
        Student xw = new Student();
        xw.name = "李智";
        xw.age = 20;
        xw.id = 001;
        xw.school = "家里蹲大学";
        xw.walk();
*/
       Student xw =new Student("李智",20,001,"西南大学");
       xw.walk();
        System.out.println(xw);

         C testc = new C();
         A testc2 = new C();
         testc2.info();

         Object testc3 = new C();

    }
}

/**
 * 多态 polymorphic(类行的自动向上转换)
 * 1、同一个方法 在不同的子类中有不同的实现（同一个方法多种实现）
 * 2、如果有继承关系：子类的对象可以使用父类变量接收
 */
class A{
    public void info(){
        System.out.println("in A");
    }
}
class B extends A{
    @Override
    public void info(){
        System.out.println("in B");
    }
}
class C extends B{
    @Override
    public void info(){
        System.out.println("in C");
    }
}
/**
 * 定义一个Person 类：name age
 * 提供有参的构造方法
 * 提供walk和eat方法
 *
 * 公务员：salary,看杂志数量,show
 * 公司职员：salary,tec ,show
 *
 * main 创建多个职员和公务员 放到一个数组里面
 * 将数组里面所有人的信息输出
 */


//instanceof 判断当前对象到底是那个类型的对象
class Person2{
    protected String name;
    protected int age;

    public void walk(){
        System.out.println("散步");
    }
    public void eat(){
        System.out.println("品尝");
    }
}
class Civilservant extends Person2{
    private int salary ;
    private int count ;

    //toStirng 方法
    public void show(int salary, int count){
     this.salary =salary;
     this.count = count;
        System.out.println(name+ "的工资有"+salary+"元");
        System.out.println(name+"看了"+count +"本杂志");
    }
}
class Clerk extends Civilservant{
    private int salary ;
    private String []tec ;

    public void show1(){
        String [] tec ={"修车","生产","建筑"};
        System.out.println(tec);
        System.out.println(name+"有"+tec+"技术");
    }
}
class Text{
    public static void main(String [] args){
        Civilservant a= new Civilservant();
        a.name = "小王";
        a.age = 25;

        a.show(5000,5);

        Clerk b = new  Clerk();
        b.name ="小李";
        b.age = 20;

        b.show1();
    }
}