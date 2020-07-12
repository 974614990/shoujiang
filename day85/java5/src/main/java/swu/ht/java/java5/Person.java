package swu.ht.java.java5;

import java.util.Scanner;
import java.util.Random;
/**
 * 文档注释   为什么需要自己创建一个package
 * 1、避免重名
 * 2、合理的管理代码的结构
 *       views：自定义的视图
 *      activitys:界面
 *      model/java jean:模型
 *      tools：管理工具
 *      3rd:第三方控件
 *      用import 导入某个包里面的源文件 例如： import swu.pxd.java.Person;
 */

import java.util.concurrent.SynchronousQueue;

/**
 * public class Person java 的类首字母大写 类名和文件名相同
 * 在同一个源文件里面可以创建多个类
 * public 修饰的类 这个文件的名称比学会这个类名相同
 *
 * 一个源文件里面只有一个public修饰的类
 *
 * 在类里面提供一个main函数作为入口点
 */
public class Person {
/**public 入口方法 需要外部调用
 * static 静态方法 静态方法优先于类  静态方法在类加载之前就提前被加载了
 * void main方法不需要返回值 GC机制 自动释放
 */
    public static  void main(String [] args){
        System.out.print("hello!");
    System.out.println("hello!");
    System.out.println("hello word!\n");
    float version = 9.0f;
    long size = 1234L;
    //Android 9.0 size is 1234
    System.out.println("Android "+version+" szie is "+size+ "." );
    char c= 'a';
    int num = 20 ;
    boolean isExist = true;
    System.out.println(isExist);

    int[]scores = new int [5];
    scores[0] = 1;
    System.out.println(scores[0]);
    //常量字符串
    String name = "jack";
    String []names = new String[5];
    names[0] = "merry";
    System.out.println(names[0]);
    }


}
class test{
    public static void main(String[] args) {
        //输入
        //创建一个Scanner扫描仪
        Scanner sc = new Scanner(System.in);
        //开始接收一个整数
        //boolean b = sc.nextBoolean();
        //int num = sc.nextInt();
        //hasNext()判断是否还有数据
        while(sc.hasNext()){
            int num = sc.nextInt();
            System.out.println("输入的内容是:"+ num);
        }

    }

}
class Test2{
    public static void main(String[] args) {
        //产生随机数
        //创建一个random
        Random r = new Random();
        int num = r.nextInt(100);
        System.out.println(num);
    }

}