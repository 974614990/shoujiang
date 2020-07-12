package day11;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Exception1 异常处理
 * 错误：error
 * 异常处理： 处理运行过程中出现的不可控制的错误 使程序更健壮
 *
 * Exception1-
 * try{
 * 执行的代码
 * 可能出现异常
 * 一旦出现异常  系统自动为我们创建一个异常对象 并抛出
 * }catch(NullPointerException){
 * 如果需要自己处理异常就catch
 * }catch(IOException){
 * 如果有多个异常  可以使用多个catch来捕获
 * 如果有多个异常   catch的顺序是从小到大
 * }catch（Exception1 e）{
 *
 * }finally{
 * 不管有没有异常finally 都会执行
 * 处理资源回收 网络连接 数据库连接 I/O流
 * }
 * 如果异常出现后面的代码将不会执行
 * try代码块 不要抓太多
 *
 * 使用throws抛出异常 给外部处理
 *
 * 当特殊情况出现了   自己可以选择抛出异常
 *
 * 自定义异常类
 */
public class Exception1 {
    public static void main(String[] args) {
        /*
        int a = 0;
        int b = 20;
        FileReader fr = null;
        try {
            int c = b / a;
            System.out.println("hello");

            fr = new FileReader("");
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (IOException i) {

            }
        }
        //圆括号里面只能添加可以关闭的对象
        //实现了Closeable接口的对象
        //如果出现异常系统就自动关闭这个资源
        try (FileReader fr1 = new FileReader("ddd")) {

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            TException.test();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        */
        try{
            TException.test3();
        }catch (PXDException e){
            System.out.println(e.getMessage());
        }
    }
}

class TException{
    public static void test() throws FileNotFoundException,NullPointerException{
        FileReader fr = new FileReader("");
    }
    public static void test2() throws IllegalAccessException{
        //。。。。。
        if(2 > 1){
            throw new IllegalAccessException();
        }
    }
    public static void test3() throws PXDException{
        throw  new PXDException("自己的异常类：无所作为");
    }
}

class PXDException extends Exception{
    //1、、提供一个无参构造方法
    public PXDException(){

    }

    //2、提供一个有参构造方法  参数是一个字符串
    public PXDException(String desc){
        super(desc);
    }
}