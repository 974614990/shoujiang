package day8;

/**
 * 接口实现回调 代理设计模式
 */
public class MyClass {
    public static void main(String [] args){
        //创建一个阅读界面
        Read read = new Read();
        read.goToSetting();
    }
}


