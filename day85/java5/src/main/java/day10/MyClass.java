package day10;

import java.io.ObjectInputStream;
import java.lang.invoke.LambdaConversionException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;


/**
 * String StringBuffer StringBuilder
 *
 * File 文件的创建 目录的创建删除
 * 文件输入输出 OutputStream     InputStream
 *          字节  FileOutputStream  FileInputStream
 *           字符  FileWriter        FileReader
 *           对象  ObjectOutputStream  ObjectInputStream
 *                  BufferedOutputStream  BufferedInputStream
 *
 *                  RandomAccessFile 随机访问文件 rw 可读可写
 *
 *                  文件操作完毕 要关闭 close()
 *
 *  数组：存储多个对象 int [] score = {}; int [] score = new score[10];
 *  弊端 ：数组长度是不可变的 内容可以变
 *
 *  实际开发中需要一个能够随时改变的数组 -> 集合Collection
 *  Collection 抽象接口 定义集合的相关操作
 *        |--  List 列表 数组 接口 特点 ：有序 可以重复
 *              |--ArrayList
 *              |-- LinkedArrayList
 *        |-- Set "集合" 特点 ： 无序  不重复
 *             |---HashSet
 *  （集合）Map 接口  映射关系 Key-Value 键值对  键不能相同 值可以相同
 *          | --HashMap
 *   Collections
 *
 *  集合的元素个数是可变的
 *  添加元素add
 *  删除元素remove
 *  获取元素个数 size
 *
 *  插入元素
 *  访问元素
 *
 */
public class MyClass {
    public static void main(String[] args) {
        //Collection接口的方法
        Collection<String> t1 = new ArrayList();

        //添加一个对象
        t1.add("jack");
        t1.add("Merry");
        System.out.println(t1);

        //删除一个对象
        t1.remove("jack");
        System.out.println(t1);

        //获取元素个数
        System.out.println(t1.size());

        //判断是否包含一个元素
        if (t1.contains("Merry")) {
            System.out.println("有Meryy");
        } else {
            System.out.println("没有Meryy");
        }

        //判断是否为空
        if (t1.isEmpty()) {
            System.out.println("是空的");
        }

        //判断两个集合是否相同(比较集合里面的内容）
        Collection<String> t2 = new ArrayList();
        t2.add("Merry");
        t2.add("jack");
        t2.add("tom");
        t2.add("rose");

        if (t1.equals(t2)) {
            System.out.println("两个集合相同");
        } else {
            System.out.println("两个集合不相同");
        }

        //清空
        t1.clear();
        System.out.println(t1);

        //集合的遍历
        //1、使用Iterator来遍历
        //hasNext 判断是否有元素
        //next 获取下一个对象
        //remove 删除当前遍历后的对象
        Iterator iterator = t2.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        //2、for-each  （增强for循环)  快速循环
        for (String obj : t2) {
            System.out.println(obj);
        }

        //3、for - i
        for (int i = 0; i < t2.size(); i++) {
            System.out.println(((ArrayList<String>) t2).get(i));
        }

        //List 接口 extends collection
        //ArrayList  连续的内存空间 优点 ：访问方便get() 缺点：元素的删除和添加
        //LinkedArrayList 内部使用链表链接 不一定连续（基本不连续） 优点 ：增加删除效率高 缺点：访问
        //集合里面只能存放对象
        //byte char int long float double boolean
        //包装类
        //Byte Char Integer Long Float Double Boolean
        //自动将基本数据类型包装为对应的类
        ArrayList<Integer> score = new ArrayList<>();
        score.add(2);
        score.add(3);//在末尾添加
        score.add(0, 1);//在指定位置插入
        System.out.println(score);

        //访问指定元素
        score.get(1);

        //修改一个元素set set(地址，值)
        score.set(0, 0);
        System.out.println(score);

        //删除
        score.remove(0);//删除指定位置的元素
        System.out.println(score);

        score.remove((Integer) 2);//删除指定的对象
        System.out.println(score);

        //删除所有 清空
        score.clear();
        System.out.println(score);

        ArrayList<Integer> a2 = new ArrayList<>();
        a2.add(1);
        a2.add(2);
        a2.add(3);
        score.addAll(a2);//将一个集合里面的内容添加到当前集合中
        System.out.println(score);

        ArrayList<Integer> a3 = new ArrayList<>();
        a3.add(1);
        a3.add(2);
        score.retainAll(a3);//取两个集合的交集
        System.out.println(a3);

        //访问某个对象在集合里面的索引 indexOf
        ArrayList<Integer> a4 = new ArrayList<>();
        a4.add(1);
        a4.add(2);
        a4.add(2);
        a4.add(1);
        System.out.println(score.indexOf(1));//如果所访问的元素有多个相同值访问第一次出现的位置
        System.out.println(score.lastIndexOf(1));//最后一次出现的位置

        //将ArrayList转化为普通数组 toArray
        Integer[] objects = new Integer[a4.size()];
        a4.toArray(objects);
        for (Integer i : objects) {
            System.out.println(i);
        }

        Iterator iterator1 = a4.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());


            //删除某个范围内的对象

            //获取某个范围的子集和
            List<Integer> integers = a4.subList(1, 2);
            System.out.println(integers);

        }

        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        //Lambda表达式 把一个函数当成一个对象
        //nums.removeIf(obj ->obj % 2 == 0);
        //for(Integer obj :nums){
         //   if(obj % 2 == 0){
         //       nums.remove(obj);
           // }
      //  }
        for(int i = 0; i < nums.size();i++){
            Integer obj = nums.get(i);
            if(obj % 2 == 0){
                nums.remove(obj);
                i--;
            }
            i++;
        }
        System.out.println(nums);

        //1、使用方式 定义一个类实现接口
        /*
        ArrayClass ac  = new ArrayClass();
        int [] num = {1,2,3,4,5,6};
        PXDClass pc = new PXDClass();
        ac.test(num,pc);
        */
        //2、使用匿名类
        /*
        ArrayClass ac  = new ArrayClass();
        int [] num = {1,2,3,4,5,6};
        ac.test(num, new Show() {
            @Override
            public void customShow(int element) {
                System.out.println(element);
            }
        });
        */
        //3、使用Lambda
        //如果参数是一个接口列对象 且接口里面只有一个方法
        //可以省略方法名
        /*
        ArrayClass ac  = new ArrayClass();
        int [] num = {1,2,3,4,5,6};
        ac.test(num,(int element) ->{
            System.out.println(element);
        });

        //4、如果只有一个参数 参数类型可以省略
        ArrayClass ac  = new ArrayClass();
        int [] num = {1,2,3,4,5,6};
        ac.test(num,element -> {
            System.out.println(element);
        });
        */
        //5、 如果代码块里面只有一行语句 大括号可以省略
        ArrayClass ac  = new ArrayClass();
        int [] num = {1,2,3,4,5,6};
        ac.test(num,element -> System.out.println(element));


        /**
         * 创建一个类Person name age
         * 定义一个集合ArrayList 对象 保存多个Person对象
         * 统计年龄大于30的人数
         * 统计名字中有张的人数
         */

        List<Person> list = new ArrayList<>();
        Person p1 = new Person("张飞",35);
        Person p2 = new Person("张辽",32);
        Person p3 = new Person("张婕",30);
        Person p4 = new Person("张伟",33);
        Person p5 = new Person("王强",42);

        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);
        int ageCount = 0;
        int zhangCount = 0;
        for(Person p:list){
            if(p.age >30){
                ageCount++;
            }
            if(p.name.contains("张")){
                zhangCount++;
            }
        }
        System.out.println("年龄大于30的人数：" +ageCount +" "+"姓张的人数："+zhangCount);


        ArrayList<Integer> a1 = new ArrayList<>();
        a1.add(2);
        a1.add(4);
        a1.add(1);
        a1.add(3);

      //1.  a1.sort(new PXDCompare());
        /*2.
        a1.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return integer - t1;
            }
        });
        */

        System.out.println(a1);
    }
}
class Person{
    String name;
    int age;
    public Person(String name,int age){
        this.name = name;
        this .age = age ;
    }
}
/**
 * Collection接口的方法
 * 添加一个对象 add
 * 删除一个对象 remove
 * 获取元素个数 size
 * 删除所有 清空 clear
 * 判断集合中是否由某个元素contains
 * 是否为空  isEmpty
 * 判断两个集合是否相同 equals
 *
 * 集合的遍历 iterator  hasNext()  next();
 * ArrayList的操作：
 *
 */

//闭包 enclusure 把函数作为一个方法的参数
class ArrayClass{
    public void test(int [] target,Show s){
        for(int element :target){
            s.customShow(element);
        }
    }
}
//必须是接口 这个接口里面只有一个方法
interface Show{
    void customShow(int element);
}
/*
class PXDClass implements Show{
    @Override
    public void customShow(int element) {
        System.out.println(element);
    }
}
  */
//从写一个比较器
class PXDCompare implements Comparator {
    //  什么时候需要手动创建比较器
    //如果系统默认提供的方法不能完成我们的比较
    //1、参与比较的对象必须要
    @Override
    public int compare(Object o, Object t1) {
        int mo = (int)o;
        int mt1 = (int)t1;
        return mo-mt1;
    }
}
/**
 * 自己实现ArrayList功能 支持所有兑现的存储  add add(i, o) remove(i) remove(o) remove (s,e) set(i ,o ) sort
 * 什么是泛型
 */