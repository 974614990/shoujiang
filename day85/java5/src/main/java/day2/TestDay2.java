package day2;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * ctrl + p上一行
 * ctrl +N 下一行
 *
 * ctrl + b 左移一个字符
 * ctrl + F 右移一个字符
 *
 * ctrl +a 跳到行首
 * ctrl + e 跳到行尾
 *
 * Ctrl+W 扩大当前编辑界面
 *
 * ctrl+D 复制到下一行
 *
 * Alt+shift+up/down 相邻两行交换
 */
public class TestDay2 {
    public static void main(String[] args){
      //char boolean short int long float double
        //引用类型：除了上面的所有类型都是引用类型
        //数组一旦被定义 大小就定义了 无法更改
         int []score = {1,2,3};//静态
        String[] names = {"jack","merry"};


        //动态 内容动态添加
        float [] height = new float[5];
        height[0] = 165.5f;
        height[1] = 170f;
        //概念性的东西是类
        //具体的东西是对象
        Random r = new Random();
        //尽量不要扩大变量的作用域
        int []count = new int[10];
        for (int i = 0;i < 10 ;i++){
            r.nextInt(10);
            count[i] = r.nextInt(10);
        }

        //数组的三种遍历方式
        //数组输出方式1
        for(int i = 0;i< 10;i++){
            System.out.print(count[i] +" ");
        }
        System.out.println();
        //数组输出方式2
        for(int temp : count ){
            System.out.print(temp+" ");

        } System.out.println();
        //数组输出方式3
        System.out.println(Arrays.toString(count));

    }
}
class GuessNumber {
    public static void main(String[] args) {
        //定义一个数组保存原始数字
        int[] org = new int[4];
        //保存用户输入的数字
        int[] guess = new int[4];
        //产生四个随机数
        Random random = new Random(10);
        for (int i = 0; i < 4; i++) {
            //产生一个随机数
            int temp = random.nextInt(10);

            //判断是否存在
            boolean result = contains(org, temp);
            if (result) {
                //确保i对应的位置能够得到一个不重复的数字
                i--;
            } else {
                org[i] = temp;
            }
        }
        //排序
        Arrays.sort(org);
        System.out.println(Arrays.toString(org));
        //定义一个扫描仪对象scanner
        Scanner scanner = new Scanner(System.in);
        //开始游戏
        while (true) {
            int countA = 0;
            int countB = 0;
            System.out.print("请输入猜测的数字：");
            for (int i = 0; i < 4; i++) {
                guess[i] = scanner.nextInt();
            }
            //判断用户输入
            /**
             * 1、判断是否存在 2、位置是否相同
             */
            //判断是否存在
            for (int i = 0; i < 4; i++) {
                boolean result = contains(guess, org[i]);//indext0f索引值
                if (result) {
                    //数字存在
                    //判断位置是否相同
                    int index = index0f(guess, org[i]);
                    if (index == i) {
                        //数字和位置都相同
                        countA++;
                    } else {
                        countB++;
                    }
                }
            }
            if (countA == 4) {
                System.out.println("恭喜全对！！！！");
                break;
            } else {
                System.out.println(countA + "A" + countB + "B");
            }

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {

                }
            }
        }

    }

    //自己写一个方法判断某个数组里面是否含某个值
    public static boolean contains(int[] val, int obj) {
        for (int i = 0; i < val.length; i++) {
            if (val[i] == obj) {
                //重复了
                return true;
            }
        }
        return false;

    }


    /**
     * 在一个数组里面查找某个对象的索引值
     *
     * @param val
     * @param obj
     * @return
     */
    public static int index0f(int[] val, int obj) {
        for (int i = 0; i < val.length; i++) {
            if (val[i] == obj) {
                return i;
            }
        }
        return -1;
    }
}

/**
 * Scanner
 * Random
 * Java的方式实现一个通讯录
 * 1、索引->查找对应字母下面的联系人
 * 2、添加联系人  姓名 地址 电话号码 email
 * 3、删除联系人
 *
 * OOP（Object oriented programming）
 * 类：Contact   姓名 地址 电话号码 email
 * Java里面除了八大数据类型之外 都是对象
 *类  抽象的 不实际存在的 描述同一类事物（具有共同的属性和方法）一个概念 不能完成具体的事情  类就是封装
 * 对象   具体的实际存在的 某一类的实例化 对象都是new出来的  可以完成具体的事情，有内存空间   同一个类可以有多个对象
 * 属性
 * 方法
 * 构造函数
 *
 */

class TextClass{
    public static void main(String[] args){
    /*
    创建一个person类的对象 new
    使用.访问成员变量
    对象一旦创建 数形变量有初值
    char '' int long short 0
    float double 0.0 byte 0
    boolean false
     */
    Person xw =new Person();
    Person zs = new Person();

    //给这个对象对应的属性赋值
        xw.name = "小王";
        xw.age = 20;
        xw.score =99.0f;

        System.out.println(xw.name);
        System.out.println(xw.age);

        //方法的使用:
        /**
         * 调用谁（对象）的方法
         * 在类里面可以直接调用自己的方法 所有资源
         * 而在外部必须通过对象来调用
         */
        Person ls = new Person();
        ls.test();
        //匿名对象->作为一个参数传递
        int result =ls.test6( new int []{1,2,3,4,5});

    }
}
/**
 * Boolean的初始值是false
 * 定义一个类  通常情况下 一个文件对应一个类
 * 修饰符 public static final private 类名首字母大写
 * 修饰符 Class +类名{  这个类的属性 ：成员变量  这个类的功能 ：方法}
 *
 *
 * 同一个类可以创建多个对象
 * 每个对象的内存空间都是独立的（对象之间没有任何关系）
 * zs xw 除了都是通过一个类创建的之外 没有任何关系
 * 对xw 的属性进行操作 不会影响 zs
 * 存什么值：成员变量
 * 完成什么样的功能： 方法
 *
 *
 * 封装：通过访问权限实现 ：public private protected
 * 把私有的东西封装起来 不让外部使用
 * 需要给外部使用 就暴露出来
 * public 公有地 想用就用 （内部可以使用 外部可以使用）
 * private 私有 只能自己使用 外部无法访问
 * protected 受保护的 外部（同一个包里面）可以访问
 * 继承
 * 多态
 */
class Person{
    //成员变量 通常定义在类的最上面
    //default :public protected
    String name;
    int age;
    float score;
    String password;

    //方法的定义   public static final private  都有返回值
        public void test (){
            System.out.println("没有返回值 没有参数的方法");
        }
        public  void test2(){
            test();
        }
        //没有返回值 接受一个参数 （需要别人帮忙）
        public  void test3(String name){

        }
        //一个参数一个返回值
        public int test4(String name ){
            return  0;
    }//有参数就要有返回值return
    //有多个参数 每个参数用逗号隔开
    public  int test5(String name,int age){
        return  0;
    }
    //可变参数 相当于 数组 所有值求和
    public int test6(int ... counts){
        int sum = 0;
        for (int i = 0 ;i < counts.length;i++){
            sum +=counts[i];
        }
        return  0;
    }
}
/**
 * Java和C的区别
 * 1.有哪些对象参与 Person：姓名 钱  poker number color
 * pokerManager :1 产生一副牌 用数组保存  2、随机获取一张牌 3、比较两张牌的大小
 * 类 对象 属性 方法
 *
 * 一个人扮演两个角色
 * 两个人在玩扑克比大小
 * 3 4 5 6 7 8 9 10 J K Q A 2
 * ♠（黑桃） ♣（梅花） ♦（方块） ♥（红桃）
 *
 * 给第一个玩家随机一张牌 A♦ 给第二个玩家随机一张牌 K♥
 * 每一局有抵住：5
 * 每个玩家分配100块
 *
 *1、弃牌
 * 2、下注
 * 提示第一个玩家下注50   是否跟注？
 * 开始下注 ：
 */
class Person1{
    int totalmoney;
   String name;
}
class Poker{
    String color;
    int number;
}
class PokerManager{

}
class  PokerGame{
    public static void main(String [] args) {
        Person1 player1 = new Person1();
        player1.totalmoney = 2000;
        player1.name = "玩家1";
        Person1 player2 = new Person1();
        player2.totalmoney = 2000;
        player2.name = "玩家2";
        //显示玩家的相关信息
        System.out.println(player1.name + "  " + "财产：" + player1.totalmoney);
        System.out.println(player2.name + "  " + "财产：" + player2.totalmoney);

        //随机产生任意一张扑克,分别发给玩家1和玩家2

        //随机产生任意一张牌
        int[] num = new int [2];
        int[] color =new int[2];

        Random random = new Random();
        for (int i = 0; i < 2; i++) {
            int temp = random.nextInt(13)+1;
            num[i] = temp;
        }
        System.out.println(Arrays.toString(num));

        if (num[0] == num[1]){
            for (int i = 0;i < 2;i++){
                int temp1 = random.nextInt(4)+1;
                for (int j = 0;j < i;j++){
                    if (temp1 == color[j]){
                        i--;
                    }else {
                        color[i] =temp1;
                    }
                }
            }
        }else {
            for (int i = 0;i < 2;i++){
                color[i] = random.nextInt(4)+1;
            }
        }
        System.out.println(Arrays.toString(color));
        //开始游戏
        int dizhu = 5;
        while (true){
            //玩家下注

            System.out.println("请下注：");
            Scanner scanner=new Scanner(System.in);
            int money = scanner.nextInt();
            //玩家总金额减少
            player1.totalmoney = player1.totalmoney-money-dizhu;
            System.out.println();
        }


    }
}

