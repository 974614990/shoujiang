package day8.String;

public class MyClass {
    public static void main(String [] args){
        //系统提供的类 String List(数组） Map
        //了解主要的一些方法的使用
/**
 * String String字符串是不可变的 他们可以被共享(两个字符串相同时 地址才相同  相同才能被共享)
 * 1、不可变得字符串 一旦创建 内容不能改变
 * 2、 == 比较两个对象是否相同地址
 *          equals 比较内容是否相同
 *  3、字符串的创建
 *  String str = "abc"常量字符串
 *    StringBuffer可变字符串 线程安全 效率不高
 *    StringBuilder 可变字符串 线程不安全 效率高
 *
 *    insert repalce append delete
 */
        String str ="abc";
        String str1 = "abc";

        System.out.println(str == str1);
        System.out.println(str.equals(str1));

        //构造方法
        //null 和 ""的区别 创建一个字符串 但是没有字符
        String str3 = new String();//没意义

        //使用字节数组 创建一个字符串
        byte[] name = {'a','b','c'};
        String str4 = new String(name);
        System.out.println(str4);

        //使用字节数组里面的一部分 创建一个字符串
        String  str6 = new String (name,0,2);
        System.out.println(str6);

        char [] hello = {'你','好','啊'};
        String h = new String(hello);
        System.out.println(h);

        //字符串有哪些方法
        //获取字符串中的一个字符
        //charAt
        char c = h.charAt(0);
        System.out.println(c);

        //两个字符串的比较   compareTo 可以知道两者之间的大小关系
        //0 ： 相同  > 0 大于 <0 ；小于
        int reult = str4.compareTo(str6);
        System.out.println(reult);

        //两个字符串的连接
        String nStr = str4.concat(h);
        System.out.println(nStr);

        //contains 判断一个字符串是否包含另一个字符串
        boolean r = "hello".contains("lle");
        System.out.println(r);

        //判断是否以某个字符串结尾
        String url = "http://www.baidu.com";
        if(url.endsWith("com")){
            System.out.println("网址");
        }

        if(url.startsWith("http")){
            System.out.println("http协议");
        }

        if(url.startsWith("www",7)){
            System.out.println("万维网");
        }

        //两个字符串进行比较
        //equals
        if("abc".equals("ABC")){
            System.out.println("相同");
        }else {
            System.out.println("不相同");
        }

        //创建的同时先准备好6个字符空间
        StringBuilder sb = new StringBuilder(6);

        //append 在末尾追加
        sb.append("I");
        sb.append("Love");
        sb.append("Android");
        System.out.println(sb);

        //insert 插入数据
        sb.insert(2,"also");
        System.out.println(sb);

        //repalce 替换
        //start  end string
        int start = sb.indexOf("Android");
        int end = start + "Android".length();
        sb.replace(start,end,"you");
        System.out.println(sb);


    }
}
/**
 * 图案解锁
 * 第一次运行 ：
 * 设置密码： 从终端一次输入一个整数6位
 *  确认密码
 *
 *  设置过了
 *  检查密码 3次错误机会相同就成功 不同就错误
 *
 */