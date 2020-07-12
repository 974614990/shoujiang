package day7;

public class MyClass1 {
    public static void main(String [] args){
        Mycode test = new Mycode();
        test.calculate();
    }
}

/**
 * 希望实现一个模板
 * 使这个模板可以方便的测出某个代码块的执行效率
 */
abstract class  TimeTemplate{
    //通过实现这个方法获得具体测量的代码 不清楚就使用抽象方法
    public abstract void code();

    //实现测量 方法
    public void  calculate(){
        long start = System.currentTimeMillis();

        //测量的代码
        code();
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

}
class Mycode extends TimeTemplate{

    @Override
    public void code() {
        //写自己的测试代码
        int total = 0;
        for(int i = 0 ; i < 10000; i++){
            total += i;
        }
    }
}